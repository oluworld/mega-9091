TD         = .
#~/Desktop/linuxtuples-0.04/
TOP        = .
SWIG       = /sw/bin/swig

SRCS       = $(TD)/tuple.c
TARGET     = tuple
INTERFACE  = tuple.i
SWIGOPT    =

all: default extras

default: tuple.i tuple.h
	$(SWIG) -java -package tripleo.linuxtuples.gen $(INTERFACE)
	gcc -c -fpic $(SRCS) $(TARGET)_wrap.c  -I/usr/java/jdk1.5.0/include -I/usr/java/jdk1.5.0/include/linux
	gcc -shared tuple.o  $(TARGET)_wrap.o   -o lib$(TARGET).so
	VERSION_CONTROL=numbered mv *.java ../gen
	cp -a lib$(TARGET).so /local/system/lib/java/

extras: extras.i
	-mkdir extras
	$(SWIG) -java -package tripleo.linuxtuples.gen.extras -outdir extras extras.i
	cp -a extras_wrap.c extras/
	gcc -c -fpic  extras/extras_wrap.c  -I/usr/java/jdk1.5.0/include -I/usr/java/jdk1.5.0/include/linux
	gcc -shared   extras_wrap.o   -o liblinuxtuplesextras.so
	VERSION_CONTROL=numbered mv extras/*.java ../gen/extras
	cp -a liblinuxtuplesextras.so /local/system/lib/java/
	rm -rf extras

check: all

clean:
	-rm extras_wrap.[co] tuple_wrap.[co]
	-rm ../gen/*.java ../gen/extras/*.java
	