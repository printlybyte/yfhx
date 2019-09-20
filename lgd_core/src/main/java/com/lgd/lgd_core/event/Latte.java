package com.lgd.lgd_core.event;

import android.content.Context;

public class Latte {
    private static Context mcontext;


    public static void init(Context context) {
        mcontext = context;
    }

    public static Context getApplicationContext() {
        return mcontext;
    }


}
