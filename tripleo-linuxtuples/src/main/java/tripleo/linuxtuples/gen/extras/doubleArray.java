/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version: 1.3.21
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */
package tripleo.linuxtuples.gen.extras;

public class doubleArray {

    private long swigCPtr;
    protected boolean swigCMemOwn;

    protected doubleArray(long cPtr, boolean cMemoryOwn) {
        swigCMemOwn = cMemoryOwn;
        swigCPtr = cPtr;
    }

    protected doubleArray() {
        this(0, false);
    }

    protected void finalize() {
        delete();
    }

    public void delete() {
        if (swigCPtr != 0 && swigCMemOwn) {
            swigCMemOwn = false;
            extraJNI.delete_doubleArray(swigCPtr);
        }
        swigCPtr = 0;
    }

    public static long getCPtr(doubleArray obj) {
        return (obj == null) ? 0 : obj.swigCPtr;
    }

    public doubleArray(int nelements) {
        this(extraJNI.new_doubleArray(nelements), true);
    }

    public double getitem(int index) {
        return extraJNI.doubleArray_getitem(swigCPtr, index);
    }

    public void setitem(int index, double value) {
        extraJNI.doubleArray_setitem(swigCPtr, index, value);
    }

    public SWIGTYPE_p_double cast() {
        long cPtr = extraJNI.doubleArray_cast(swigCPtr);
        return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
    }

    public static doubleArray frompointer(SWIGTYPE_p_double t) {
        long cPtr = extraJNI.doubleArray_frompointer(SWIGTYPE_p_double.getCPtr(t));
        return (cPtr == 0) ? null : new doubleArray(cPtr, false);
    }

}
