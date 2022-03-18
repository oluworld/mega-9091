/********************************************************************/
/*                    Connection Library                            */
/*    version: 0.6                                                  */
/*                                                                  */
/*    file: cl.h                                                    */
/*    Copyright: (c) 1998, 1999 by Ugo Varetto                      */
/*    e-mail: varetto@computer.org                                  */
/********************************************************************/

/*
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Library General Public
 *  License as published by the Free Software Foundation; either
 *  version 2 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Library General Public License for more details.
 *
 *  You should have received a copy of the GNU Library General Public
 *  License along with this library; if not, write to the Free
 *  Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 *  See the README file for more information.
 */

#ifndef _CL_H_
#define _CL_H_

#ifndef UNIX
# include <winsock2.h>
# include <process.h>
  typedef u_long IOCTL_TYPE;
#else

#include <sys/types.h>
#include <sys/time.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <sys/ioctl.h>
#include <sys/wait.h>
#include <netdb.h>
#include <unistd.h>
#include <signal.h>


typedef int SOCKET;
typedef char IOCTL_TYPE;

#define INVALID_SOCKET -1
#define closesocket(s) close(s)
#define ioctlsocket(s,cmd,argp) ioctl(s,cmd,argp)
#define Sleep(t) usleep(t*1000)
#define SD_BOTH 2
#endif



/* defines */


#define ERRMSG_SIZE 256
#define HOSTNAME_SIZE 256


/**************/
/* errors     */
/* LAST IS: 31*/

#define CL_ERR -1
#define CL_ERR_NOERROR 0
#define CL_ERR_UNKNOWN_HOST 1   /*host is unknown or unreachable*/
#define CL_ERR_INVALID_SOCKET 2 /*invalid socket created by socket(..)*/
#define CL_ERR_CONNECTION_UNAVAIL 3 /*connection attempt failed*/
#define CL_ERR_UNKNOWN_SERVICE 4 /*undefined service requested*/
#define CL_ERR_INIT_FAILED 5 /*WSAStartup didn't return 0 */
#define CL_ERR_LIBCLOSE_FAILED 6/*WSACleanup error*/
#define CL_ERR_CLOSE_SOCKET 7
#define CL_ERR_MEMORY_ALLOC 8
#define CL_ERR_NULL_POINTER 9
#define CL_ERR_SOCKET_ATTR 23
#define CL_ERR_SOCKET_BIND 24
#define CL_ERR_TIMEOUT 25
#define CL_ERR_SOCKET_BROADCAST 26
#define CL_ERR_SOCKET_CREATE 27
#define CL_ERR_ACCEPT 28
#define CL_ERRX_FORK 29
#define CL_ERRW_THREAD 30
#define CL_ERR_SELECT 31

/* end errors */
/**************/

/* use this struct to pass data to server threads functions */
struct clThreadData {
	SOCKET sock;
	void *data;
};



/**************/
/* functions  */
#ifdef __cplusplus
extern "C" {
#endif
/* error handling */
extern void clResetError();
extern void clPrintError();
extern int  clGetErrorCode();
extern void clGetErrorMessage(char *msg);
extern void clSetErrorCallback(void (*callback)(char *err_msg,int err_code));

/* core functions*/
extern int clBegin();
extern SOCKET clConnect(char *hostname,char *service_or_port,char *protocol);
extern SOCKET clConnectPort(char *hostname,unsigned short port,char *protocol);

extern int clAsyncSocket(SOCKET s);
extern int clSyncSocket(SOCKET s);

extern int clBytesAvailable(SOCKET s);

#define clTcpSocket clTcpSyncSocket
#define clUdpSocket clUdpSyncSocket

extern SOCKET clTcpSyncSocket();
extern SOCKET clUdpSyncSocket();
extern SOCKET clTcpAsyncSocket();
extern SOCKET clUdpAsyncSocket();
extern SOCKET clBroadcastSocket();

extern int clValid(SOCKET s);

extern unsigned short clGetPortByService(char *service,char *protocol);
extern int clDisconnect(SOCKET s);
extern int clClose(SOCKET s);
extern int clEnd();
extern void clSetSRDelay(int milliseconds); /* delay between consecutive clSend & clRecv */
extern int clGetSRDelay();
extern int clGetRemoteName(SOCKET s,char * hostname,char *address);

/* data transfer functions */
/* TCP */
extern int clSend(SOCKET s,char *msg,int msg_size);
extern int clRecv(SOCKET s,char *msg,int msg_size);
extern int clAsyncRecv(SOCKET s,char *msg,int msg_size,int timeout /*milliseconds*/);
extern int clAsyncSend(SOCKET s,char *msg,int msg_size,int timeout /*milliseconds*/);


/* UDP */
extern int clSendTo(SOCKET s,char *msg,int msg_size,char *host,unsigned short port);
extern int clRecvFrom(SOCKET s,char *msg,int msg_size,char *host,int host_size,unsigned short port);
extern int clAsyncRecvFrom(SOCKET s,char *msg,int msg_size,char *host,int host_size,
						   unsigned short port,int timeout /* milliseconds */ );
extern int clAsyncSendTo(SOCKET s,char *msg,int msg_size,char *host,
						   unsigned short port,int timeout /* milliseconds */ );
extern int clBroadcast(SOCKET s,char *msg,int msg_size,unsigned short port);


/* tries to send or receive all the msg_size bytes of msg */
extern int clSendAll(SOCKET s,char *msg,int msg_size);
extern int clRecvAll(SOCKET s,char *msg,int msg_size);


/* server functions */

extern SOCKET clEstablish(unsigned short portnum,int backlog);
extern SOCKET clWaitNewConnection(SOCKET s);


#define clServerByService(service,backlog,tfun,data) clServerByPort(clGetPortByService(service),backlog,tfun,data)

extern int clServerByPort(unsigned short port,
	 int backlog, void (*threadFun)(struct clThreadData *),struct clThreadData *);

extern int clKillParent(int retval);
/********** protocols specific functions **********/


extern int clSelect (int fds[], int ready[], int count, int seconds, int micro_seconds);

	 typedef char byte ;

	extern void WRAP_bind(char*addr, int addr2);
	extern void WRAP_close();
	//extern Err WRAP_connect_ex(char *address);
	extern int WRAP_fileno();
	extern int WRAP_getsockopt(int layer, int option);
	extern void WRAP_listen(int num);
	extern byte[] WRAP_recv(int buffer_size);
	extern int WRAP_send(byte[] data);
	extern void WRAP_setsockopt(int layer, int option, int value);

#ifdef __cplusplus
}
#endif

#endif /* _CL_H_*/
