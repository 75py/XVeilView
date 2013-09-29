
package com.nagopy.android.xposed.sharp.veilview.util;

import android.util.Log;

public class Logger {

    private static final String TAG = "VeilViewPatch";

    private Logger() {
    }

    public static void d(String msg, Object... targets) {
        StringBuilder sb = new StringBuilder(msg);
        sb.append(", ");
        for (Object obj : targets) {
            sb.append(obj);
            sb.append(", ");
        }
        Log.d(TAG, sb.toString());
    }
}
