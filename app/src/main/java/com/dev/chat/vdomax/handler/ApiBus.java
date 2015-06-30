package com.dev.chat.vdomax.handler;

import com.squareup.otto.Bus;

/**
 * Created by Adisorn on 14/3/2558.
 */
public class ApiBus extends Bus{

    private static ApiBus singleton;

    public static ApiBus getInstance() {
        if (singleton == null) {
            singleton = new ApiBus();

        }
        return singleton;
    }
}

