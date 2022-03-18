%module tuples

%{
#include "tuple.h"

#include <time.h>
#include <math.h>
#include <sys/time.h>
%}

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

//~ #ifndef TUPLE_H_INCLUDED
//~ #define TUPLE_H_INCLUDED

//~ #ifndef va_list
//~ #define va_list __gnuc_va_list
//~ #endif

//~ #ifdef DEBUG
//~ #define _DBG_(x)  x
//~ #else
//~ #define _DBG_(x)
//~ #endif

//~ #define ASSERT(cond)   \
   //~ _DBG_(if (!(cond)) { DBGPRINTF("assert failed: %s\n", \
                                  //~ #cond); exit(1); })

//~ #define DBGPRINTF(fmt,a...)   \
   //~ _DBG_(fprintf(stderr, "%d " __FILE__ ":%d " fmt, \
                 //~ debug_counter++, __LINE__, ##a))

//~ #define TELL(x) \
   //~ DBGPRINTF(#x " = %d\n", x)

#if defined(DEBUG)
static inline void *
mymalloc(int size, char *file, int line)
{
	void *p;
	p = malloc(size);
	fprintf(stderr, "%s:%d malloc %08x\n", file, line, (unsigned int) p);
	return p;
}
static inline void
myfree(void *p, char *file, int line)
{
	fprintf(stderr, "%s:%d free %08x\n", file, line, (unsigned int) p);
	free(p);
}

//~ #define MALLOC(n) mymalloc(n,__FILE__,__LINE__)
//~ #define FREE(n) myfree(n,__FILE__,__LINE__)
//~ #else
//~ #define MALLOC malloc
//~ #define FREE free
#endif

//~ #ifdef DEBUG
//~ /* Get a stack trace for GDB*/
//~ #define EXIT()   *((int*) 0) = 11
//~ #else
//~ #define EXIT()   exit(1)
//~ #endif

%inline {
struct timeval *
new_timeval() {
	struct timeval *s=(struct timeval *)MALLOC(sizeof(struct timeval));
	return(s);
}
void delete_timeval(struct timeval *t) {
	if(t) FREE(t);
}
}

extern int gettimeofday (struct timeval *__tv, __timezone_ptr_t __tz) ;

/* Time difference between two struct timevals.
 */
%inline {
#undef TIMEVAL_DIFF
double GET_TIMEVAL_DIFF(struct timeval before, struct timeval after) {
	return ((after.tv_sec - before.tv_sec) +
	1.0e-6 * (after.tv_usec - before.tv_usec));
}
}


/* Environment variables */
%javaconst(1);
#define SERVERNAME_ENVVAR  "LINUXTUPLES_HOST"
#define PORTNUMBER_ENVVAR  "LINUXTUPLES_PORT"
//~ %javaconst(0);

enum message_op {
	PUT = 0, 	GET = 1, 		READ = 2,
	GET_NB = 3,	READ_NB = 4, 	DUMP = 5,
	COUNT = 6, 	LOG = 7,
};

struct element{
	int tag;
	union {
		int i;
		double d;
		//~ struct _s
		//~ {
			//~ char *ptr;
			//~ int len;
		//~ }		s;
	}	data;
};

struct tuple{
	int num_elts;
	int string_length;
	struct element *elements;
	char *string_space;
};

struct tuple_list{
	struct tuple_list *next;
	struct tuple *tup;
};


%inline {
typedef int SOCKET_T;
}

struct context {
	char servername[100];
	int portnumber;
	SOCKET_T sock;
	pthread_t thr;
};



/* ================= tuple.c ================= */

#ifdef DEBUG
extern int debug_counter;
#endif
extern int i_am_server;
extern char logbuf[8192];
extern int logptr;


%exception get_server_portnumber { // TODO: change to typemap
  $action
  if (!result) {
    jclass clazz = (*jenv)->FindClass(jenv, "java/lang/Exception");
    (*jenv)->ThrowNew(jenv, clazz, "failure in linuxtuples");
    return $null;
  }
}

extern int get_server_portnumber(struct context *ctx);
extern void print_element(struct element *e);
extern void print_tuple(struct tuple *s);
//extern struct tuple *make_tuple(char *fmt, ...); //TODO: SWIG doesnt generate varargs for java
				// TODO: should just use Object[]
extern void destroy_tuple(struct tuple *t);
extern int tuples_match(struct tuple *s, struct tuple *t);
extern unsigned int random_int(void);
extern int send_chunk(struct context *ctx, char *buf, int bytes_to_send);
extern int send_tuple(struct context *ctx, struct tuple *t);
extern int recv_chunk(struct context *ctx, char *buf, int size);
extern struct tuple *recv_tuple(struct context *ctx);
extern int put_tuple(struct tuple *s, struct context *ctx);
extern struct tuple *get_tuple(struct tuple *s, struct context *ctx);
extern struct tuple *read_tuple(struct tuple *s, struct context *ctx);
extern struct tuple *get_nb_tuple(struct tuple *s, struct context *ctx);
extern struct tuple *read_nb_tuple(struct tuple *s, struct context *ctx);
extern struct tuple_list *dump_tuple_space(struct tuple_list *templates,
					   struct context *ctx);
extern int count_tuple_space(struct tuple_list *templates,
			     struct context *ctx, int *result);
extern int tuple_server_log(FILE * stream, struct context *ctx);
extern int tuple_int_field(struct tuple *s, int n);
extern double tuple_double_field(struct tuple *s, int n);
extern char *tuple_string_field(struct tuple *s, int *len, int n);

extern struct tuple *create_tuple(const int elt_count);

extern void tuple_set_int(struct tuple *t, const int elt_index, int i) ;
extern void tuple_set_double(struct tuple *t, const int elt_index, double d) ;
extern void tuple_set_str(struct tuple *t, const int elt_index, char*str, int len) ;   //TODO:safeString
extern void tuple_set_buf(struct tuple *t, const int elt_index, void*buf, size_t len); //TODO:AwxBuffer
extern int tuple_get_int(struct tuple *t, const int elt_index) ;
extern double tuple_get_double(struct tuple *t, const int elt_index) ;
extern char* tuple_get_str(struct tuple *t, const int elt_index) ;
extern void tuple_set_nil(struct tuple *t, const int elt_index) ;


//~ #endif /* TUPLE_H_INCLUDED */
