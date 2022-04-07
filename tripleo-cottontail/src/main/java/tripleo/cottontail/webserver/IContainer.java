package tripleo.cottontail.webserver;

import tripleo.histore.*;

public interface IContainer {

    HiStoreEntry alloc(String aS) throws AllocationFailure, ConsistencyFailure;
}
