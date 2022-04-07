package tripleo.impohrt.cl;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version: 1.3.21
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */
class clJNI {

    public static native int get_ERRMSG_SIZE();

    public static native int get_HOSTNAME_SIZE();

    public static native int get_CL_ERR();

    public static native int get_CL_ERR_NOERROR();

    public static native int get_CL_ERR_UNKNOWN_HOST();

    public static native int get_CL_ERR_INVALID_SOCKET();

    public static native int get_CL_ERR_CONNECTION_UNAVAIL();

    public static native int get_CL_ERR_UNKNOWN_SERVICE();

    public static native int get_CL_ERR_INIT_FAILED();

    public static native int get_CL_ERR_LIBCLOSE_FAILED();

    public static native int get_CL_ERR_CLOSE_SOCKET();

    public static native int get_CL_ERR_MEMORY_ALLOC();

    public static native int get_CL_ERR_NULL_POINTER();

    public static native int get_CL_ERR_SOCKET_ATTR();

    public static native int get_CL_ERR_SOCKET_BIND();

    public static native int get_CL_ERR_TIMEOUT();

    public static native int get_CL_ERR_SOCKET_BROADCAST();

    public static native int get_CL_ERR_SOCKET_CREATE();

    public static native int get_CL_ERR_ACCEPT();

    public static native int get_CL_ERRX_FORK();

    public static native int get_CL_ERRW_THREAD();

    public static native int get_CL_ERR_SELECT();

    public static native void set_clThreadData_sock(long jarg1, long jarg2);

    public static native long get_clThreadData_sock(long jarg1);

    public static native void set_clThreadData_data(long jarg1, long jarg2);

    public static native long get_clThreadData_data(long jarg1);

    public static native long new_clThreadData();

    public static native void delete_clThreadData(long jarg1);

    public static native void clResetError();

    public static native void clPrintError();

    public static native int clGetErrorCode();

    public static native void clGetErrorMessage(String jarg1);

    public static native void clSetErrorCallback(long jarg1);

    public static native long get_errCallback();

    public static native int clBegin();

    public static native long clConnect(String jarg1, String jarg2, String jarg3);

    public static native long clConnectPort(String jarg1, int jarg2, String jarg3);

    public static native int clAsyncSocket(long jarg1);

    public static native int clSyncSocket(long jarg1);

    public static native int clBytesAvailable(long jarg1);

    public static native long clTcpSyncSocket();

    public static native long clUdpSyncSocket();

    public static native long clTcpAsyncSocket();

    public static native long clUdpAsyncSocket();

    public static native long clBroadcastSocket();

    public static native int clGetPortByService(String jarg1, String jarg2);

    public static native int clDisconnect(long jarg1);

    public static native int clClose(long jarg1);

    public static native int clEnd();

    public static native void clSetSRDelay(int jarg1);

    public static native int clGetSRDelay();

    public static native int clGetRemoteName(long jarg1, String jarg2, String jarg3);

    public static native int clSend(long jarg1, String jarg2, int jarg3);

    public static native int clRecv(long jarg1, String jarg2, int jarg3);

    public static native int clAsyncRecv(long jarg1, String jarg2, int jarg3, int jarg4);

    public static native int clAsyncSend(long jarg1, String jarg2, int jarg3, int jarg4);

    public static native int clSendTo(long jarg1, String jarg2, int jarg3, String jarg4, int jarg5);

    public static native int clRecvFrom(long jarg1, String jarg2, int jarg3, String jarg4, int jarg5, int jarg6);

    public static native int clAsyncRecvFrom(long jarg1, String jarg2, int jarg3, String jarg4, int jarg5, int jarg6, int jarg7);

    public static native int clAsyncSendTo(long jarg1, String jarg2, int jarg3, String jarg4, int jarg5, int jarg6);

    public static native int clBroadcast(long jarg1, String jarg2, int jarg3, int jarg4);

    public static native int clSendAll(long jarg1, String jarg2, int jarg3);

    public static native int clRecvAll(long jarg1, String jarg2, int jarg3);

    public static native long clEstablish(int jarg1, int jarg2);

    public static native long clWaitNewConnection(long jarg1);

    public static native int clServerByPort(int jarg1, int jarg2, long jarg3, long jarg4);

    public static native int clKillParent(int jarg1);

    public static native int clSelect(long jarg1, long jarg2, int jarg3, int jarg4, int jarg5);
}
