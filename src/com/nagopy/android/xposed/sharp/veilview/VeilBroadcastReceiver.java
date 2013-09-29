
package com.nagopy.android.xposed.sharp.veilview;

import java.lang.reflect.Method;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.nagopy.android.xposed.sharp.veilview.util.Const;
import com.nagopy.android.xposed.sharp.veilview.util.Logger;

public class VeilBroadcastReceiver extends BroadcastReceiver {

    private CopyOfVeilViewButton mCopyOfVeilViewButton;

    public VeilBroadcastReceiver(Object thisObject, Method getVeilViewState, Method doON,
            Method doOFF) {
        mCopyOfVeilViewButton = new CopyOfVeilViewButton(thisObject, getVeilViewState, doON, doOFF);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Const.ACTION_REMOVE_OTHER_RECEIVER)) {
            // 解除アクションがきたら解除して終了する
            context.unregisterReceiver(this);
            return;
        }

        try {
            if (!mCopyOfVeilViewButton.isActive()) {
                // 何かしらなくなっていれば外す
                context.unregisterReceiver(this);
                return;
            }

            String action = intent.getAction();
            if (action.equals(Const.ACTION_REQUEST_VEIL_VIEW_STATE)) {
                // ベールビューの状態を返す
                Boolean isOn = mCopyOfVeilViewButton.getState();
                Intent returnIntent = new Intent(Const.ACTION_RETURN_VEIL_VIEW_STATE);
                returnIntent.putExtra(Const.EXTRA_CURRENT_VEIL_VIEW_STATE, isOn);
                context.sendBroadcast(returnIntent);
            } else if (action.equals(Const.ACTION_SET_VEIL_VIEW_STATE)) {
                // ベールビューをONまたはOFFに設定する
                boolean targetState = intent.getBooleanExtra(Const.EXTRA_TARGET_VEIL_VIEW_STATE,
                        false);
                if (targetState) {
                    mCopyOfVeilViewButton.doON();
                } else {
                    mCopyOfVeilViewButton.doOFF();
                }
            } else if (action.equals(Const.ACTION_SWITCH_VEIL_VIEW_STATE)) {
                // ベールビューの状態を切り替える
                Boolean isOn = mCopyOfVeilViewButton.getState();
                if (isOn) {
                    mCopyOfVeilViewButton.doOFF();
                } else {
                    mCopyOfVeilViewButton.doON();
                }
            } else {
                throw new IllegalArgumentException("unknown broadcast");
            }

            Logger.d("VeilBroadcastReceiver#onReceive", "action:" + intent.getAction(),
                    intent.getExtras(), this.toString());
        } catch (Throwable t) {
            Logger.d("error", t, getClass().getName(), "mCopyOfVeilViewButton = "
                    + mCopyOfVeilViewButton);
        }

    }

}
