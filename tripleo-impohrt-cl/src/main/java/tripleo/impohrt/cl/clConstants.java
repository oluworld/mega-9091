package tripleo.impohrt.cl;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version: 1.3.21
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public interface clConstants {
  // enums and constants
  public final static int ERRMSG_SIZE = clJNI.get_ERRMSG_SIZE();
  public final static int HOSTNAME_SIZE = clJNI.get_HOSTNAME_SIZE();
  public final static int CL_ERR = clJNI.get_CL_ERR();
  public final static int CL_ERR_NOERROR = clJNI.get_CL_ERR_NOERROR();
  public final static int CL_ERR_UNKNOWN_HOST = clJNI.get_CL_ERR_UNKNOWN_HOST();
  public final static int CL_ERR_INVALID_SOCKET = clJNI.get_CL_ERR_INVALID_SOCKET();
  public final static int CL_ERR_CONNECTION_UNAVAIL = clJNI.get_CL_ERR_CONNECTION_UNAVAIL();
  public final static int CL_ERR_UNKNOWN_SERVICE = clJNI.get_CL_ERR_UNKNOWN_SERVICE();
  public final static int CL_ERR_INIT_FAILED = clJNI.get_CL_ERR_INIT_FAILED();
  public final static int CL_ERR_LIBCLOSE_FAILED = clJNI.get_CL_ERR_LIBCLOSE_FAILED();
  public final static int CL_ERR_CLOSE_SOCKET = clJNI.get_CL_ERR_CLOSE_SOCKET();
  public final static int CL_ERR_MEMORY_ALLOC = clJNI.get_CL_ERR_MEMORY_ALLOC();
  public final static int CL_ERR_NULL_POINTER = clJNI.get_CL_ERR_NULL_POINTER();
  public final static int CL_ERR_SOCKET_ATTR = clJNI.get_CL_ERR_SOCKET_ATTR();
  public final static int CL_ERR_SOCKET_BIND = clJNI.get_CL_ERR_SOCKET_BIND();
  public final static int CL_ERR_TIMEOUT = clJNI.get_CL_ERR_TIMEOUT();
  public final static int CL_ERR_SOCKET_BROADCAST = clJNI.get_CL_ERR_SOCKET_BROADCAST();
  public final static int CL_ERR_SOCKET_CREATE = clJNI.get_CL_ERR_SOCKET_CREATE();
  public final static int CL_ERR_ACCEPT = clJNI.get_CL_ERR_ACCEPT();
  public final static int CL_ERRX_FORK = clJNI.get_CL_ERRX_FORK();
  public final static int CL_ERRW_THREAD = clJNI.get_CL_ERRW_THREAD();
  public final static int CL_ERR_SELECT = clJNI.get_CL_ERR_SELECT();
  public final static SWIGTYPE_p_f_p_char_int__void errCallback = new SWIGTYPE_p_f_p_char_int__void(clJNI.get_errCallback(), false);
}