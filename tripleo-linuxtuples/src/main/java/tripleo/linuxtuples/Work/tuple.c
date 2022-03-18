/*****************************************************************
 *
 * LinuxTuples - an open-source tuple system for Linux clusters
 * Copyright (c) 2003, Will Ware <wware@alum.mit.edu>
 * All rights reserved.
 *
 *    Redistribution and use in source and binary forms, with or
 *    without modification, are permitted provided that the following
 *    conditions are met:
 *
 *    + Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 *    + Redistributions in binary form must reproduce the above
 *    copyright notice, this list of conditions and the following
 *    disclaimer in the documentation and/or other materials provided
 *    with the distribution.
 *
 *    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 *    CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 *    INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 *    MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *    DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 *    CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 *    SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 *    LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 *    USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 *    AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 *    LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 *    IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 *    THE POSSIBILITY OF SUCH DAMAGE.
 *
 *****************************************************************/

#include <stdio.h>
#include <stdarg.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <sched.h>

#include "tuple.h"

/**
 * This flag tells whether or not the current executable is the
 * tuple server. If it is, then broken pipes on sockets should
 * not crash the executable.
 *
 * Doxygen likes LaTeX-flavored math:
 * \f[
 * |I_2|=\left| \int_{0}^T \psi(t)
 * \left\{
 * u(a,t)-
 * \int_{\gamma(t)}^a
 * \frac{d\theta}{k(\theta,t)}
 * \int_{a}^\theta
 * c(\xi)u_t(\xi,t)\,d\xi
 * \right\}
 * dt
 * \right|
 * \f]
 */
int i_am_server = 0;

#ifdef DEBUG
int debug_counter = 0;
#endif

/**
 * Buffer for logging tuple activity.
 * \sa tuple_server_log
 */
char logbuf[8192];
/**
 * Pointer into logbuf.
 */
int logptr = 0;

#define PERROR(x)   fprintf(stderr, __FILE__":%d  ", __LINE__); perror(x)


/**
 * Attempt to get the server name and port number from environment
 * variables.
 *
 * \return 0 if successful, 1 otherwise.
 */
int
get_server_portnumber(struct context *ctx)
{
	char *s;
	s = getenv(SERVERNAME_ENVVAR);
	if (s == NULL)
		return 1;
	if (strlen(s) == 0)
		return 1;
	strcpy(ctx->servername, s);
	s = getenv(PORTNUMBER_ENVVAR);
	if (s == NULL)
		return 1;
	ctx->portnumber = atoi(s);
	return 0;
}

/*
 * -----------------------------------------------------------
 */

/**
 *
 */
void
print_element(struct element *e)
{
	int i, n, too_long, tag = e->tag;
	unsigned char *s;
	const int max_str_len = 10;
	switch (tag) {
	case 'i':
		logptr += sprintf(logbuf + logptr, "%d", e->data.i);
		break;
	case 'd':
		logptr += sprintf(logbuf + logptr, "%f", e->data.d);
		break;
	case 's':
		s = e->data.s.ptr;
		n = e->data.s.len;
		too_long = 0;
		if (n > max_str_len) {
			n = max_str_len;
			too_long = 1;
		}
		logbuf[logptr++] = '"';
		for (i = 0; i < n; i++) {
			if (s[i] >= ' ' && s[i] <= '~') {
				logbuf[logptr++] = s[i];
			}
			else {
				logptr +=
					sprintf(logbuf + logptr,
						"\\%02X", s[i]);
			}
		}
		if (too_long) {
			logptr += sprintf(logbuf + logptr, " ...");
		}
		logbuf[logptr++] = '"';
		break;
	case '?':
		logptr += sprintf(logbuf + logptr, "???");
		break;
	default:
		logptr +=
			sprintf(logbuf + logptr,
				"<<unknown field, tag=%d>>", tag);
		break;
	}
}


/**
 *
 */
void
print_tuple(struct tuple *s)
{
	int i, n, flag = 0;
	if (logptr >= 8000)
		return;
	logptr += sprintf(logbuf + logptr, "( ");
	n = s->num_elts;
	if (n > 10) {
		n = 10;
		flag = 1;
	}
	for (i = 0; i < n; i++) {
		if (i > 0) {
			logptr += sprintf(logbuf + logptr, "\t");
		}
		print_element(&s->elements[i]);
		logptr += sprintf(logbuf + logptr, ",\n");
	}
	if (flag) {
		logptr += sprintf(logbuf + logptr, ".... ");
	}
	logptr += sprintf(logbuf + logptr, ")\n");
}


/*
 * -----------------------------------------------------------
 * JAVA CHANGES
 * -----------------------------------------------------------
 */
struct tuple *
create_tuple(const int elt_count)
{
	struct tuple *t;

	t = malloc(sizeof(struct tuple));
	if (t == NULL) {
		PERROR("malloc failed");
		EXIT();
	}
	t->num_elts = elt_count;
	t->string_space = NULL;
	t->elements = malloc(t->num_elts * sizeof(struct element));
	if (t->elements == NULL) {
		PERROR("malloc failed");
		EXIT();
	}
	return t;
}

void tuple_set_nil(struct tuple *t, const int elt_index) {
	t->elements[elt_index].tag = '?';
}
void tuple_set_int(struct tuple *t, const int elt_index, int i) {
	t->elements[elt_index].tag = 'i';
	t->elements[elt_index].data.i = i;
}
void tuple_set_double(struct tuple *t, const int elt_index, double d) {
	t->elements[elt_index].tag = 'd';
	t->elements[elt_index].data.d = d;
}
void tuple_set_str(struct tuple *t, const int elt_index, char*str, int len) {
	t->elements[elt_index].tag = 's';
	t->elements[elt_index].data.s.ptr = str;
	t->elements[elt_index].data.s.len = len;
}
void tuple_set_buf(struct tuple *t, const int elt_index, void*str, size_t len) {
	t->elements[elt_index].tag = 's';
	t->elements[elt_index].data.s.ptr = str;
	t->elements[elt_index].data.s.len = len;
}
int tuple_get_int(struct tuple *t, const int elt_index) {
	return t->elements[elt_index].data.i ;
}
double tuple_get_double(struct tuple *t, const int elt_index) {
	return t->elements[elt_index].data.d ;
}
char* tuple_get_str(struct tuple *t, const int elt_index) {
	return  t->elements[elt_index].data.s.ptr ;
}


/*
 * -----------------------------------------------------------
 */

/**
 *
 */
static struct tuple *
make_tuple_internal(char *fmt, va_list ap)
{
	int i, elt_index, len;
	double d;
	char *s;
	struct tuple *t;

	t = malloc(sizeof(struct tuple));
	if (t == NULL) {
		PERROR("malloc failed");
		EXIT();
	}
	t->num_elts = 0;
	t->string_space = NULL;
	for (s = fmt; *s; s++) {
		if (*s != '#')
			t->num_elts++;
	}
	t->elements = malloc(t->num_elts * sizeof(struct element));
	if (t->elements == NULL) {
		PERROR("malloc failed");
		EXIT();
	}

	elt_index = 0;
	while (*fmt) {
		t->elements[elt_index].tag = *fmt;
		switch (*fmt++) {
		case '?':
			/*
			 * nothing from the va_arg list
			 */
			break;
		case 'i':
			i = va_arg(ap, int);
			t->elements[elt_index].data.i = i;
			break;
		case 'd':
			d = va_arg(ap, double);
			t->elements[elt_index].data.d = d;
			break;
		case 's':
			s = va_arg(ap, char *);
			if (*fmt == '#') {
				/*
				 * string with length
				 */
				len = va_arg(ap, int);
				fmt++;
			}
			else {
				/*
				 * zero-terminated string
				 */
				len = strlen(s);
			}
			t->elements[elt_index].data.s.ptr = s;
			t->elements[elt_index].data.s.len = len;
			break;
		}
		elt_index++;
	}
	return t;
}

/**
 * Create a tuple or template, starting from a printf-style
 * variable argument list.
 */
struct tuple *
make_tuple(char *fmt, ...)
{
	struct tuple *t;
	va_list ap;
	va_start(ap, fmt);
	t = make_tuple_internal(fmt, ap);
	va_end(ap);
	return t;
}


/**
 * Deallocate all the storage for a tuple.
 */
void
destroy_tuple(struct tuple *t)
{
	if (t != NULL) {
		free(t->elements);
		if (t->string_space != NULL)
			free(t->string_space);
		free(t);
	}
}


/**
 *
 */
int
tuples_match(struct tuple *s, struct tuple *t)
{
	int i, num_elts;
	num_elts = s->num_elts;
	if (num_elts != t->num_elts)
		return 0;
	for (i = 0; i < num_elts; i++) {
		int s_tag = s->elements[i].tag;
		int t_tag = t->elements[i].tag;

		if (s_tag != '?' && t_tag != '?') {
			if (s_tag != t_tag)
				return 0;
			switch (s_tag) {
			case 'i':
				if (s->elements[i].data.i !=
				    t->elements[i].data.i)
					return 0;
				break;
			case 'd':
				if (s->elements[i].data.d !=
				    t->elements[i].data.d)
					return 0;
				break;
			case 's':
				if (s->elements[i].data.s.len !=
				    t->elements[i].data.s.len)
					return 0;
				if (strncmp(s->elements[i].data.s.ptr,
					    t->elements[i].data.s.ptr,
					    s->elements[i].data.s.len) != 0)
					return 0;
				break;
			default:
				break;
			}
		}
	}
	return 1;
}



/*
 * -----------------------------------------------------------
 */

/**
 * Return a 32-bit random unsigned integer, gotten from
 * /dev/urandom.
 */
unsigned int
random_int(void)
{
	int x, sock;
	sock = open("/dev/urandom", O_RDONLY);
	read(sock, &x, sizeof(int));
	close(sock);
	return x;
}


/*
 * -----------------------------------------------------------
 */

/**
 *
 */
int
send_chunk(struct context *ctx, char *buf, int bytes_to_send)
{
	while (bytes_to_send) {
		int gotten, masks = 0;
		/*
		 * The server should not get a SIGPIPE if a client
		 * dies, because then it will stop running. But we
		 * want clients to stop running (Broken pipe) if the
		 * server stops.
		 */
		if (i_am_server)
			masks = MSG_NOSIGNAL;
		gotten = send(ctx->sock, buf, bytes_to_send, masks);
		if (gotten < 0) {
			PERROR("send failed");
			return 1;
		}
		buf += gotten;
		bytes_to_send -= gotten;
		sched_yield();
	}
	return 0;
}


/**
 *
 */
int
send_tuple(struct context *ctx, struct tuple *t)
{
	int i, string_length;
	if (send_chunk(ctx, (char *) &t->num_elts, sizeof(int))) {
		PERROR("send_chunk failed");
		return 1;
	}
	string_length = 0;
	for (i = 0; i < t->num_elts; i++) {
		if (t->elements[i].tag == 's') {
			string_length += t->elements[i].data.s.len;
		}
	}
	if (send_chunk(ctx, (char *) &string_length, sizeof(int))) {
		PERROR("send_chunk failed");
		return 1;
	}

	string_length = 0;
	for (i = 0; i < t->num_elts; i++) {
		struct element *e = &t->elements[i];
		if (e->tag == 's') {
			/*
			 * translate pointers into indexes
			 */
			if (send_chunk(ctx, (char *) &e->tag, sizeof(int))) {
				PERROR("send_chunk failed");
				return 1;
			}
			if (send_chunk
			    (ctx, (char *) &string_length, sizeof(int))) {
				PERROR("send_chunk failed");
				return 1;
			}
			if (send_chunk
			    (ctx, (char *) &e->data.s.len, sizeof(int))) {
				PERROR("send_chunk failed");
				return 1;
			}
			string_length += e->data.s.len;
		}
		else {
			if (send_chunk
			    (ctx, (char *) e, sizeof(struct element))) {
				PERROR("send_chunk failed");
				return 1;
			}
		}
	}

	for (i = 0; i < t->num_elts; i++) {
		if (t->elements[i].tag == 's') {
			if (send_chunk(ctx,
				       (char *) t->elements[i].data.s.
				       ptr, t->elements[i].data.s.len)) {
				PERROR("send_chunk failed");
				return 1;
			}
		}
	}
	return 0;
}


/**
 *
 */
int
recv_chunk(struct context *ctx, char *buf, int size)
{
	int gotten;
	/*
	 * The server should not quit if a client dies, But we want
	 * clients to stop running (Broken pipe) if the server stops,
	 * or at least pass an error message up to whoever called
	 * down here.
	 *
	 * I had intended to use MSG_NOSIGNAL as a mask argument to
	 * recv() for this purpose, but it turns out that the signal
	 * only kills that thread, not the whole server, and that's
	 * exactly the desired behavior.
	 *
	 * Although I don't know if it puts the thread in some wierd
	 * limbo state, leaving the entry in tuple_server.c's
	 * client_list unuseable. This will be something to
	 * investigate as time permits.
	 */
	gotten = recv(ctx->sock, buf, size, MSG_WAITALL);
	if (gotten < size) {
		fprintf(stderr, "%s broke connection?\n",
			i_am_server ? "Client" : "Server");
		PERROR("recv failed");
		return 1;
	}
	return 0;
}


/**
 *
 */
struct tuple *
recv_tuple(struct context *ctx)
{
	struct tuple *s;
	int i, num_elts, string_length, element_size;

	if (recv_chunk(ctx, (char *) &num_elts, sizeof(int))) {
		PERROR("recv_chunk failed");
		return NULL;
	}

	/*
	 * return code for non-blocking gets and reads
	 */
	if (num_elts == -1) {
		return (struct tuple *) -1;
	}

	if (recv_chunk(ctx, (char *) &string_length, sizeof(int))) {
		PERROR("recv_chunk failed");
		return NULL;
	}

	s = malloc(2 * sizeof(int) +
		   num_elts * sizeof(struct element) + string_length);
	if (s == NULL) {
		PERROR("malloc failed");
		EXIT();
	}
	s->num_elts = num_elts;
	s->string_length = string_length;

	element_size = num_elts * sizeof(struct element);
	s->elements = malloc(element_size);
	if (s->elements == NULL) {
		PERROR("malloc failed");
		EXIT();
	}
	if (recv_chunk(ctx, (char *) s->elements, element_size)) {
		PERROR("recv_chunk failed");
		return NULL;
	}

	if (string_length) {
		s->string_space = malloc(string_length);
		if (s->string_space == NULL) {
			PERROR("malloc failed");
			EXIT();
		}
		if (recv_chunk(ctx, s->string_space, string_length)) {
			PERROR("recv_chunk failed");
			return NULL;
		}

		/*
		 * translate index values to pointers
		 */
		for (i = 0; i < num_elts; i++) {
			if (s->elements[i].tag == 's') {
				int n = (int) s->elements[i].data.s.ptr;
				s->elements[i].data.s.ptr =
					s->string_space + n;
			}
		}
	}
	else {
		s->string_space = NULL;
	}
	return s;
}


/*
 * -----------------------------------------------------------
 */

/**
 *
 */
static int
open_client_socket(struct context *ctx)
{
	unsigned char *p, dotted_quad[20];
	struct sockaddr_in addr;

	ctx->sock = socket(AF_INET, SOCK_STREAM, 0);
	if (ctx->sock < 0) {
		PERROR("Can't create socket");
		return 1;
	}

	/*
	 * convert server name to dotted quad
	 */
	struct hostent *he = gethostbyname(ctx->servername);
	if (he == NULL) {
		PERROR("connect failed (bad hostname?)");
		return 1;
	}
	p = he->h_addr_list[0];
	sprintf(dotted_quad, "%u.%u.%u.%u", p[0], p[1], p[2], p[3]);
	p = dotted_quad;
	memset(&addr, 0, sizeof(addr));
	addr.sin_family = AF_INET;
	addr.sin_addr.s_addr = inet_addr(p);
	addr.sin_port = htons(ctx->portnumber);

	if (connect(ctx->sock,
		    (struct sockaddr *) &addr,
		    sizeof(struct sockaddr_in)) < 0) {
		PERROR("connect failed");
		return 1;
	}

	return 0;
}




/**
 *
 */
int
put_tuple(struct tuple *s, struct context *ctx)
{
	int op = PUT;
	if (open_client_socket(ctx)) {
		PERROR("open_client_socket failed");
		return 1;
	}
	if (send_chunk(ctx, (char *) &op, sizeof(int))) {
		PERROR("send failed");
		return 1;
	}
	if (send_tuple(ctx, s)) {
		PERROR("send_tuple failed");
		return 1;
	}
	if (recv_chunk(ctx, (char *) &op, sizeof(int))) {
		PERROR("recv_chunk failed");
		return 1;
	}
	close(ctx->sock);
	return 0;
}


/**
 *
 */
struct tuple *
get_tuple(struct tuple *s, struct context *ctx)
{
	int op = GET;
	if (open_client_socket(ctx)) {
		PERROR("open_client_socket failed");
		return NULL;
	}
	if (send_chunk(ctx, (char *) &op, sizeof(int))) {
		PERROR("send failed");
		return NULL;
	}
	if (send_tuple(ctx, s)) {
		PERROR("send_tuple failed");
		return NULL;
	}
	DBGPRINTF("\n");
	s = recv_tuple(ctx);
	DBGPRINTF("s = %08x\n", (int) s);
	if (s == NULL) {
		PERROR("recv_tuple failed");
		return NULL;
	}
	if (s == (struct tuple *) -1) {
		PERROR("recv_tuple failed");
		return NULL;
	}
	close(ctx->sock);
	return s;
}


/**
 *
 */
struct tuple *
read_tuple(struct tuple *s, struct context *ctx)
{
	int op = READ;
	if (open_client_socket(ctx)) {
		PERROR("open_client_socket failed");
		return NULL;
	}
	if (send_chunk(ctx, (char *) &op, sizeof(int))) {
		PERROR("send failed");
		return NULL;
	}
	if (send_tuple(ctx, s)) {
		PERROR("send_tuple failed");
		return NULL;
	}
	DBGPRINTF("\n");
	s = recv_tuple(ctx);
	DBGPRINTF("s = %08x\n", (int) s);
	if (s == NULL) {
		PERROR("recv_tuple failed");
		return NULL;
	}
	if (s == (struct tuple *) -1) {
		PERROR("recv_tuple failed");
		return NULL;
	}
	close(ctx->sock);
	return s;
}


/**
 *
 */
struct tuple *
get_nb_tuple(struct tuple *s, struct context *ctx)
{
	int op = GET_NB;
	if (open_client_socket(ctx)) {
		PERROR("open_client_socket failed");
		return (struct tuple *) -1;
	}
	if (send_chunk(ctx, (char *) &op, sizeof(int))) {
		PERROR("send failed");
		return (struct tuple *) -1;
	}
	if (send_tuple(ctx, s)) {
		PERROR("send_tuple failed");
		return (struct tuple *) -1;
	}
	s = recv_tuple(ctx);
	if (s == NULL) {
		PERROR("recv_tuple failed");
		return (struct tuple *) -1;
	}
	if (s == (struct tuple *) -1) {
		close(ctx->sock);
		return NULL;
	}
	close(ctx->sock);
	return s;
}


/**
 *
 */
struct tuple *
read_nb_tuple(struct tuple *s, struct context *ctx)
{
	int op = READ_NB;
	if (open_client_socket(ctx)) {
		PERROR("open_client_socket failed");
		return (struct tuple *) -1;
	}
	if (send_chunk(ctx, (char *) &op, sizeof(int))) {
		PERROR("send failed");
		return (struct tuple *) -1;
	}
	if (send_tuple(ctx, s)) {
		PERROR("send_tuple failed");
		return (struct tuple *) -1;
	}
	DBGPRINTF("\n");
	s = recv_tuple(ctx);
	DBGPRINTF("s = %08x\n", (int) s);
	if (s == NULL) {
		PERROR("recv_tuple failed");
		return (struct tuple *) -1;
	}
	if (s == (struct tuple *) -1) {
		close(ctx->sock);
		return NULL;
	}
	close(ctx->sock);
	return s;
}


/*
 * -----------------------------------------------------------
 */



/**
 * Transmit a list of templates to the server, with an op code
 * of DUMP. The server will respond by sending back a list of
 * the matching tuples.
 */
struct tuple_list *
dump_tuple_space(struct tuple_list *templates, struct context *ctx)
{
	int count, op = DUMP;
	struct tuple_list *s, *t, *tlist;

	for (count = 0, s = templates; s != NULL; count++, s = s->next);

	if (open_client_socket(ctx)) {
		PERROR("open_client_socket failed");
		return NULL;
	}

	if (send_chunk(ctx, (char *) &op, sizeof(int))) {
		PERROR("send failed");
		return NULL;
	}
	if (send_chunk(ctx, (char *) &count, sizeof(int))) {
		PERROR("send failed");
		return NULL;
	}
	s = templates;
	while (s) {
		if (send_tuple(ctx, s->tup)) {
			PERROR("send_tuple failed");
			return NULL;
		}
		s = s->next;
	}
	/*
	 * Do NOT free the templates. This guy may want to
	 * use them again later. Let him free them.
	 */

	tlist = NULL;
	if (recv_chunk(ctx, (char *) &count, sizeof(int))) {
		PERROR("recv_chunk failed");
		return NULL;
	}
	while (count--) {
		struct tuple_list *x = malloc(sizeof(struct tuple_list));
		if (x == NULL) {
			/*
			 * ? ? ? ?
			 */
		}
		x->tup = recv_tuple(ctx);
		DBGPRINTF("x->tup = %08x\n", (int) x->tup);
		if (x->tup == NULL) {
			PERROR("recv_tuple failed");
			return NULL;
		}
		if (x->tup == (struct tuple *) -1) {
			PERROR("recv_tuple failed");
			return NULL;
		}
		x->next = tlist;
		tlist = x;
	}

	DBGPRINTF("tlist = %08x\n", (int) tlist);
	for (t = tlist; t != NULL;) {
		DBGPRINTF("t = %08x\n", (int) t);
		DBGPRINTF("t->tup = %08x\n", (int) t->tup);
		DBGPRINTF("t->next = %08x\n", (int) t->next);
		t = t->next;
	}

	return tlist;
}


/**
 * This works just like dump_tuple_space, but instead of
 * sending back a list of all the matching tuples, we just
 * send back a count of how many tuples match.
 */
int
count_tuple_space(struct tuple_list *templates,
		  struct context *ctx, int *result)
{
	int count, op = COUNT;
	struct tuple_list *s, *tlist;

	for (count = 0, s = templates; s != NULL; count++, s = s->next);

	if (open_client_socket(ctx)) {
		PERROR("open_client_socket failed");
		return 1;
	}

	if (send_chunk(ctx, (char *) &op, sizeof(int))) {
		PERROR("send failed");
		return 1;
	}
	if (send_chunk(ctx, (char *) &count, sizeof(int))) {
		PERROR("send failed");
		return 1;
	}
	s = templates;
	while (s) {
		if (send_tuple(ctx, s->tup)) {
			PERROR("send_tuple failed");
			return 1;
		}
		s = s->next;
	}
	/*
	 * Do NOT free the templates. This guy may want to
	 * use them again later. Let him free them.
	 */

	tlist = NULL;
	if (recv_chunk(ctx, (char *) result, sizeof(int))) {
		PERROR("recv_chunk failed");
		return 1;
	}

	return 0;
}


/**
 *
 */
int
tuple_server_log(FILE * stream, struct context *ctx)
{
	int n, op = LOG;
	const int bufsize = 8192;
	char buf[bufsize];

	if (open_client_socket(ctx)) {
		PERROR("open_client_socket failed");
		return 1;
	}
	if (send_chunk(ctx, (char *) &op, sizeof(int))) {
		close(ctx->sock);
		PERROR("send_chunk failed");
		return 1;
	}

	n = read(ctx->sock, buf, bufsize);
	if (n < 0) {
		PERROR("read failed");
		return 1;
	}
	if (n > 0 && fwrite(buf, 1, n, stream) < n)
		return 0;
	close(ctx->sock);
	return 0;
}



/*
 * -----------------------------------------------------------
 */

/**
 *
 */
static struct element *
tuple_field(struct tuple *s, int n)
{
	if (n >= s->num_elts) {
		fprintf(stderr, "tuple_field() index too big (%d)\n", n);
		fprintf(stderr, "tuple only has %d elements\n", s->num_elts);
		EXIT();
	}
	return &s->elements[n];
}


/**
 *
 */
int
tuple_int_field(struct tuple *s, int n)
{
	struct element *e;
	e = tuple_field(s, n);
	if (e->tag != 'i') {
		fprintf(stderr,
			"tuple_int_field: field %d is not an int\n", n);
		fprintf(stderr, "Here is the tuple\n");
		print_tuple(s);
		logbuf[logptr] = '\0';
		fprintf(stderr, logbuf);
		EXIT();
	}
	return e->data.i;
}


/**
 *
 */
double
tuple_double_field(struct tuple *s, int n)
{
	struct element *e;
	e = tuple_field(s, n);
	if (e->tag != 'd') {
		fprintf(stderr,
			"tuple_double_field: field %d is not a double\n", n);
		fprintf(stderr, "Here is the tuple\n");
		print_tuple(s);
		logbuf[logptr] = '\0';
		fprintf(stderr, logbuf);
		EXIT();
	}
	return e->data.d;
}


/**
 *
 */
char *
tuple_string_field(struct tuple *s, int *len, int n)
{
	struct element *e;
	e = tuple_field(s, n);
	if (e->tag != 's') {
		fprintf(stderr,
			"tuple_string_field: field %d is not a string\n", n);
		fprintf(stderr, "Here is the tuple\n");
		print_tuple(s);
		logbuf[logptr] = '\0';
		fprintf(stderr, logbuf);
		EXIT();
	}
	if (len != NULL)
		*len = e->data.s.len;
	return e->data.s.ptr;
}


/*
 * -----------------------------------------------------------
 */
