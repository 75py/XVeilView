
package com.nagopy.android.xposed.sharp.veilview.shortcut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.nagopy.android.xposed.sharp.veilview.util.Const;

public class DoOffActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        intent.setAction(Const.ACTION_SET_VEIL_VIEW_STATE);
        intent.putExtra(Const.EXTRA_TARGET_VEIL_VIEW_STATE, false);
        sendBroadcast(intent);
        finish();
    }

}
