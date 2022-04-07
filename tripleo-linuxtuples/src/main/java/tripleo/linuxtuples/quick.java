package tripleo.linuxtuples;

import tripleo.linuxtuples.gen.*;

/**
 * Date: Jun 29, 2005 Time: 10:02:47 AM
 * <p/>
 * $Id: quick.java,v 1.1.1.1 2005/07/14 06:03:03 olu Exp $
 */
public class quick {

    {
        System.loadLibrary("tuple");
        System.loadLibrary("linuxtuplesextras");
    }

    private context mctx;

    public void connect(String ahost, int aport) {
        context ctx = new context();
        ctx.setServername(ahost);
        ctx.setPortnumber(aport);
//		tuples. // TODO: no explicit open or connect
        mctx = ctx;
//		return this;
    }

    public void connect() {
        context ctx = new context();
        tuples.get_server_portnumber(ctx);
        mctx = ctx;
//		return this;
    }

    /*
		puts a tuple into the tuple space
     */
    public void put(tuple atuple) {
        tuples.put_tuple(atuple, mctx);
    }

    /*
		gets a tuple from the tuple space, which must match
		the template, where null values are wildcards; blocks
		until a matching tuple is found
     */
    public tuple get(tuple atemplate) {
        return tuples.get_tuple(atemplate, mctx);
    }

    /*
		reads a tuple from tuple space without removing it,
		blocks until a matching tuple is found
     */
    tuple read(tuple atemplate) {
        return tuples.read_tuple(atemplate, mctx);
    }

    /*
	non-blocking version of get(), returns null if no
		matching tuple is found
     */
    public tuple get_nonblocking(tuple atemplate) {
        return tuples.get_nb_tuple(atemplate, mctx);
    }

    /*
		non-blocking version of read(), returns null if no
		matching tuple is found
     */
    tuple read_nonblocking(tuple atemplate) {
        return tuples.read_nb_tuple(atemplate, mctx);
    }

    /*
		return the contents of the tuple space; if given a
		list of templates, return only those tuples that
		match at least one template
     */
    void dump() {
        tuples.dump_tuple_space(null, mctx);
    }

    void dump(tuple_list alist) {
        tuples.dump_tuple_space(alist, mctx);
    }

    /*
		print a running log of tuple server activity to
		stdout; use this in a "while 1:" loop
     */
    void log() {
//		tuples.tuple_server_log(linuxtuples.extras.fdopen(linuxtuples.extras.STDOUT_FILENO()), mctx);
    }
}
