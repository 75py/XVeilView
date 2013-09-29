
package com.nagopy.android.xposed.sharp.veilview.util;

public class Const {

    private Const() {
    }

    public static final String ACTION_REQUEST_VEIL_VIEW_STATE = "com.nagopy.android.xposed.sharp.veilview.action.REQUEST_VEIL_VIEW_STATE";
    public static final String ACTION_RETURN_VEIL_VIEW_STATE = "com.nagopy.android.xposed.sharp.veilview.action.RETURN_VEIL_VIEW_STATE";
    public static final String ACTION_SWITCH_VEIL_VIEW_STATE = "com.nagopy.android.xposed.sharp.veilview.action.SWITCH_VEIL_VIEW_STATE";
    public static final String ACTION_SET_VEIL_VIEW_STATE = "com.nagopy.android.xposed.sharp.veilview.action.SET_VEIL_VIEW_STATE";

    public static final String EXTRA_CURRENT_VEIL_VIEW_STATE = "com.nagopy.android.xposed.sharp.veilview.extra.CURRENT_VEIL_VIEW_STATE";
    public static final String EXTRA_TARGET_VEIL_VIEW_STATE = "com.nagopy.android.xposed.sharp.veilview.extra.TARGET_VEIL_VIEW_STATE";

    public static final String ACTION_REMOVE_OTHER_RECEIVER = "com.nagopy.android.xposed.sharp.veilview.action.REMOVE_OTHER_RECEIVER";
}
