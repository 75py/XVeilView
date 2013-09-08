
package com.nagopy.android.xposed.sharp.veilview.shortcut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.nagopy.android.xposed.sharp.veilview.util.Const;

public class SwitchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        intent.setAction(Const.ACTION_SWITCH_VEIL_VIEW_STATE);
        sendBroadcast(intent);
        finish();
    }

}
