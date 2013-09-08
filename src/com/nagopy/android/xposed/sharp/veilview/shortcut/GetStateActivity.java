
package com.nagopy.android.xposed.sharp.veilview.shortcut;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

import com.nagopy.android.xposed.sharp.veilview.util.Const;

public class GetStateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                show("EXTRA_CURRENT_VEIL_VIEW_STATE："
                        + intent.getBooleanExtra(Const.EXTRA_CURRENT_VEIL_VIEW_STATE, false));
                context.unregisterReceiver(this);
            }
        };
        registerReceiver(receiver, new IntentFilter(Const.ACTION_RETURN_VEIL_VIEW_STATE));
        intent.setAction(Const.ACTION_REQUEST_VEIL_VIEW_STATE);
        sendBroadcast(intent);
        finish();
    }

    private void show(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
