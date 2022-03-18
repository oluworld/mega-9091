CXX     := gcc -c -fpic
JAVA_HOME := /usr/java/jdk1.5.0

EXT     := c

SWIG    := /sw/bin/swig -java #-c++
MODULE  := cl

INCLUDE := -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/linux
DEFINES := -DUNIX

all: lib$(MODULE).so
#	#make -f ../../Makefile $(EXT)SRCS='$(MODULE).$(EXT)' SWIG='../../../swig' \
#	#    SWIGOPT='' TARGET='$(MODULE)' INTERFACE='$(MODULE).i' java_cpp
	true javac *.java
	cp -a lib$(MODULE).so ..
	#cp -a lib$(MODULE).so /sw/lib
	#sudo /sbin/ldconfig

$(MODULE)_wrap.c: $(MODULE).i
	$(SWIG) -package tripleo.impohrt.cl.gen $(MODULE).i
	-mkdir ../gen
	env VERSION_CONTROL=numbered mv *.java ../gen

#cl.i: cl.c cl.h

$(MODULE).o $(MODULE)_wrap.o: $(MODULE)_wrap.c
	$(CXX) $(INCLUDE) $(DEFINES)   $(MODULE).$(EXT) $(MODULE)_wrap.$(EXT)

lib$(MODULE).so: $(MODULE).o $(MODULE)_wrap.o
	g++ -shared   $(MODULE).o $(MODULE)_wrap.o    -o $@ #lib$(MODULE).so

clean:
	echo remove everything except cl.c, h and i (and Makefile ;)

# ------------------------------
