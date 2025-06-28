package com.trazadera.lens.sdk;

import java.util.Map;

public abstract class Program {

    public Program() {
    }

    public void metric(Map<String,String> tuples) {

    }
    /**
     * This method is called by the Trazadera Lens Agent to run your program.
     * @param context the Context instance for your program, which provides access to the Trazadera Lens Agent context.
     */
    public abstract void run(Context context);

}
