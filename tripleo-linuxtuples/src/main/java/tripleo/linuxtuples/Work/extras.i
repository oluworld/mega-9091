//%javapackage linuxtuples.extras

%module extra

%include "carrays.i"
%array_class(int, intArray);
%array_class(double, doubleArray);

// add Buffers...