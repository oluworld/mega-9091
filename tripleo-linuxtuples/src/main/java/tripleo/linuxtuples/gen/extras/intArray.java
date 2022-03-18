/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version: 1.3.21
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package tripleo.linuxtuples.gen.extras;


public class intArray {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected intArray(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected intArray() {
    this(0, false);
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      extraJNI.delete_intArray(swigCPtr);
    }
    swigCPtr = 0;
  }

  protected static long getCPtr(intArray obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  public intArray(int nelements) {
    this(extraJNI.new_intArray(nelements), true);
  }

  public int getitem(int index) {
    return extraJNI.intArray_getitem(swigCPtr, index);
  }

  public void setitem(int index, int value) {
    extraJNI.intArray_setitem(swigCPtr, index, value);
  }

  public SWIGTYPE_p_int cast() {
    long cPtr = extraJNI.intArray_cast(swigCPtr);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public static intArray frompointer(SWIGTYPE_p_int t) {
    long cPtr = extraJNI.intArray_frompointer(SWIGTYPE_p_int.getCPtr(t));
    return (cPtr == 0) ? null : new intArray(cPtr, false);
  }

}