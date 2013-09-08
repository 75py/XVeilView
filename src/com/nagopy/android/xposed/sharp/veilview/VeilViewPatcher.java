
package com.nagopy.android.xposed.sharp.veilview;

import java.lang.reflect.Method;

import android.content.Context;
import android.content.IntentFilter;

import com.nagopy.android.xposed.sharp.veilview.util.Const;
import com.nagopy.android.xposed.sharp.veilview.util.Logger;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

/**
 * ベールビューのショートカットを作成できるようにする
 * 
 * @author 75py <dev.75py@gmail.com>
 */
public class VeilViewPatcher implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.android.systemui")) {
            return;
        }

        try {
            Class<?> veilViewButtonClass = XposedHelpers.findClass(
                    "jp.co.sharp.android.systemui.statusbar.phone.VeilViewButton",
                    lpparam.classLoader);
            final Method getStatus = XposedHelpers.findMethodExact(veilViewButtonClass,
                    "getStatus");
            final Method doON = XposedHelpers.findMethodExact(veilViewButtonClass,
                    "doON");
            final Method doOFF = XposedHelpers.findMethodExact(veilViewButtonClass,
                    "doOFF");
            XposedBridge.hookAllConstructors(veilViewButtonClass, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
                    Context context = (Context) param.args[0];

                    VeilBroadcastReceiver veilBroadcastReceiver = new VeilBroadcastReceiver(
                            param.thisObject, getStatus, doON, doOFF);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(Const.ACTION_REQUEST_VEIL_VIEW_STATE);
                    intentFilter.addAction(Const.ACTION_SET_VEIL_VIEW_STATE);
                    intentFilter.addAction(Const.ACTION_SWITCH_VEIL_VIEW_STATE);

                    context.registerReceiver(veilBroadcastReceiver, intentFilter);
                }
            });
        } catch (Throwable t) {
            Logger.d("error", "Throwable", t);
        }
    }

}
