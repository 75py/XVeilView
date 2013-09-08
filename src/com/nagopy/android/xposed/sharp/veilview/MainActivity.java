
package com.nagopy.android.xposed.sharp.veilview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nagopy.android.xposed.sharp.veilview.shortcut.DoOffActivity;
import com.nagopy.android.xposed.sharp.veilview.shortcut.DoOnActivity;
import com.nagopy.android.xposed.sharp.veilview.shortcut.GetStateActivity;
import com.nagopy.android.xposed.sharp.veilview.shortcut.SwitchActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_on:
                intent.setClass(getApplicationContext(), DoOnActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_off:
                intent.setClass(getApplicationContext(), DoOffActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_switch:
                intent.setClass(getApplicationContext(), SwitchActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_getstate:

                intent.setClass(getApplicationContext(), GetStateActivity.class);
                startActivity(intent);
                break;
        }
    }

}
