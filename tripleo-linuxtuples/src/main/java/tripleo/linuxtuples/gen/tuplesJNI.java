package tripleo.linuxtuples.gen;

/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version: 1.3.21
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


class tuplesJNI {
  public static native long new_timeval();
  public static native void delete_timeval(long jarg1);
  public static native int gettimeofday(long jarg1, long jarg2);
  public static native double GET_TIMEVAL_DIFF(long jarg1, long jarg2);
  public static native void set_element_tag(long jarg1, int jarg2);
  public static native int get_element_tag(long jarg1);
  public static native long get_element_data(long jarg1);
  public static native long new_element();
  public static native void delete_element(long jarg1);
  public static native void set_element_data_i(long jarg1, int jarg2);
  public static native int get_element_data_i(long jarg1);
  public static native void set_element_data_d(long jarg1, double jarg2);
  public static native double get_element_data_d(long jarg1);
  public static native long new_element_data();
  public static native void delete_element_data(long jarg1);
  public static native void set_tuple_num_elts(long jarg1, int jarg2);
  public static native int get_tuple_num_elts(long jarg1);
  public static native void set_tuple_string_length(long jarg1, int jarg2);
  public static native int get_tuple_string_length(long jarg1);
  public static native void set_tuple_elements(long jarg1, long jarg2);
  public static native long get_tuple_elements(long jarg1);
  public static native void set_tuple_string_space(long jarg1, String jarg2);
  public static native String get_tuple_string_space(long jarg1);
  public static native long new_tuple();
  public static native void delete_tuple(long jarg1);
  public static native void set_tuple_list_next(long jarg1, long jarg2);
  public static native long get_tuple_list_next(long jarg1);
  public static native void set_tuple_list_tup(long jarg1, long jarg2);
  public static native long get_tuple_list_tup(long jarg1);
  public static native long new_tuple_list();
  public static native void delete_tuple_list(long jarg1);
  public static native void set_context_servername(long jarg1, String jarg2);
  public static native String get_context_servername(long jarg1);
  public static native void set_context_portnumber(long jarg1, int jarg2);
  public static native int get_context_portnumber(long jarg1);
  public static native void set_context_sock(long jarg1, int jarg2);
  public static native int get_context_sock(long jarg1);
  public static native void set_context_thr(long jarg1, long jarg2);
  public static native long get_context_thr(long jarg1);
  public static native long new_context();
  public static native void delete_context(long jarg1);
  public static native void set_i_am_server(int jarg1);
  public static native int get_i_am_server();
  public static native void set_logbuf(String jarg1);
  public static native String get_logbuf();
  public static native void set_logptr(int jarg1);
  public static native int get_logptr();
  public static native int get_server_portnumber(long jarg1);
  public static native void print_element(long jarg1);
  public static native void print_tuple(long jarg1);
  public static native void destroy_tuple(long jarg1);
  public static native int tuples_match(long jarg1, long jarg2);
  public static native long random_int();
  public static native int send_chunk(long jarg1, String jarg2, int jarg3);
  public static native int send_tuple(long jarg1, long jarg2);
  public static native int recv_chunk(long jarg1, String jarg2, int jarg3);
  public static native long recv_tuple(long jarg1);
  public static native int put_tuple(long jarg1, long jarg2);
  public static native long get_tuple(long jarg1, long jarg2);
  public static native long read_tuple(long jarg1, long jarg2);
  public static native long get_nb_tuple(long jarg1, long jarg2);
  public static native long read_nb_tuple(long jarg1, long jarg2);
  public static native long dump_tuple_space(long jarg1, long jarg2);
  public static native int count_tuple_space(long jarg1, long jarg2, long jarg3);
  public static native int tuple_server_log(long jarg1, long jarg2);
  public static native int tuple_int_field(long jarg1, int jarg2);
  public static native double tuple_double_field(long jarg1, int jarg2);
  public static native String tuple_string_field(long jarg1, long jarg2, int jarg3);
  public static native long create_tuple(int jarg1);
  public static native void tuple_set_int(long jarg1, int jarg2, int jarg3);
  public static native void tuple_set_double(long jarg1, int jarg2, double jarg3);
  public static native void tuple_set_str(long jarg1, int jarg2, String jarg3, int jarg4);
  public static native void tuple_set_buf(long jarg1, int jarg2, long jarg3, int jarg4);
  public static native int tuple_get_int(long jarg1, int jarg2);
  public static native double tuple_get_double(long jarg1, int jarg2);
  public static native String tuple_get_str(long jarg1, int jarg2);
  public static native void tuple_set_nil(long jarg1, int jarg2);
}
