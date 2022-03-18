/*****************************************************************
 *
 * LinuxTuples - an open-source tuple space for Linux clusters
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



// Do a little unit testing to make sure the new count feature is
// working correctly.


package tripleo.linuxtuples.example;

import tripleo.linuxtuples.gen.*;
import tripleo.linuxtuples.gen.extras.doubleArray;
import tripleo.linuxtuples.TupleFactory;

import java.io.IOException;

class tuple_client {
	static final int PARALLEL = 4;
	static final int N = 8 * 1024;
	private int sizeof_double=8 ; //TODO: impl in swig

	{System.loadLibrary("tuple");}

	public static void main(String[] args) throws IOException {
		new tuple_client().r(args);
	}

	void r(String[] args) throws IOException {
		context ctx= new context();
		if (tuples.get_server_portnumber(ctx) > 0) {
			if (args.length < 2) {
				/* help message */
				System.err.println(
					"Usage: tuple_client <server> <portnumber>"); // was arg[0]
				System.exit(1);
			}
			ctx.setServername(args[0]);
			ctx.setPortnumber(int_of_string(args, args[1]));
		}

		x1(ctx);
		x2(ctx);
	}

	private int int_of_string(String[] args, String string) throws NumberFormatException {
		return (new Integer( string)).intValue();
	}

	/**
	 * Put out requests to have FFT operations done, and measure how
	 * long it takes to get the results back.
	 */
	private void x2(context aCtx) {
		{System.loadLibrary("linuxtuplesextras");}

		tuple s,t,u=null;
		int i, j, iters = 0;

		int[] r1=new int[PARALLEL], r2=new int[PARALLEL], r3=new int[PARALLEL];
		double mult;

		doubleArray x = new doubleArray(N);
		doubleArray y = new doubleArray(N);
		SWIGTYPE_p_timeval T0=tuples.new_timeval();
		SWIGTYPE_p_timeval T1=tuples.new_timeval();

//		FileInputStream rndsock = new FileInputStream("/dev/urandom");
		mult = 1.0 / Math.pow(2.0, 31);
		for (i = 0; i < N; i++) {
			x.setitem(i, mult * tuples.random_int());
			y.setitem(i, mult * tuples.random_int());
		}

		//
		//
		//

		s = tuples.create_tuple(6);
		tuples.tuple_set_str(s, 0, "fft", 3);
		tuples.tuple_set_int(s, 1, 0);
		tuples.tuple_set_int(s, 2, 0);
		tuples.tuple_set_int(s, 3, 0);
		tuples.tuple_set_buf(s, 4, new SWIGTYPE_p_void(x.getCPtr(x),false), N * (sizeof_double)); //TODO: fix this part in swig
		tuples.tuple_set_buf(s, 5, new SWIGTYPE_p_void(y.getCPtr(y),false), N * (sizeof_double));


		t = tuples.create_tuple(6);
		tuples.tuple_set_str(t, 0, "fft done", 8);
		tuples.tuple_set_int(t, 1, 0);
		tuples.tuple_set_int(t, 2, 0);
		tuples.tuple_set_int(t, 3, 0);
		tuples.tuple_set_nil(t, 4);
		tuples.tuple_set_nil(t, 5);

		tuple tt=TupleFactory.make(new Object[]{"fft done",0,0,0,null,null});
		assert tuples.tuples_match(t,t)==0;
		assert tuples.tuples_match(t,tt)==0;

		tuples.gettimeofday(T0, null);

		try{while (true) {

			for (j = 0; j < PARALLEL; j++) {
				r1[j] = (int) tuples.random_int();
				r2[j] = (int) tuples.random_int();
				r3[j] = (int) tuples.random_int();
				tuples.tuple_set_int(s, 1, r1[j]);
				tuples.tuple_set_int(s, 2, r2[j]);
				tuples.tuple_set_int(s, 3, r3[j]);
				if (tuples.put_tuple(s, aCtx) == 1) {
					perror("put_tuple failed");
					System.exit(1);
				}
			}
			for (j = 0; j < PARALLEL; j++) {
				tuples.tuple_set_int(t, 1, r1[j]);
				tuples.tuple_set_int(t, 2, r2[j]);
				tuples.tuple_set_int(t, 3, r3[j]);
				u = tuples.get_tuple(t, aCtx);
				if (u == null) {
					perror("get_tuple failed");
					System.exit(1);
				}
			}

			tuples.gettimeofday(T1, null);
			iters += PARALLEL;
			System.out.println(tuples.GET_TIMEVAL_DIFF(T0, T1) / iters);
		}

//		rndsock.close();
		}finally{tuples.destroy_tuple(s);
		tuples.destroy_tuple(t);
		tuples.destroy_tuple(u);}
	}

/*
	private float TIMEVAL_DIFF(timeval_t aT0, timeval_t aT1) {
		// TODO: implement me
		Assert.not_implemented();
		return 0;
	}
*/

	private void x1(context aCtx) {
		tuple s;
		tuple t;
		tuple u;
		s=tuples.create_tuple(2);
		tuples.tuple_set_int(s, 0, 1);
		tuples.tuple_set_int(s, 1, 15);

		if (tuples.put_tuple(s, aCtx) == 1) { // TODO: exceptions in swig
			perror("put_tuple failed");
			System.exit(1);
		}

		t=tuples.create_tuple(2);
		tuples.tuple_set_int(t, 0, 1);
		tuples.tuple_set_nil(t, 1);
		tuples.print_tuple(t);
		System.out.println(tuples.getLogbuf());
		u = tuples.get_tuple(t, aCtx);
		if (u == null) {
			perror("get_tuple failed");
			System.exit(1);
		}
		tuples.print_tuple(u);
		System.out.println(tuples.getLogbuf());

//java.nio.ByteBuffer a;
	}

	private void perror(String s) {	}

/*
	private timeval_t gettimeofday(timeval_t aT1) {
		//To change body of created methods use File | Settings | File Templates.
		// TODO: implement me
		Assert.not_implemented();
		return null;
	}

	class timeval_t {}
*/
}
