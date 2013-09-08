
package com.nagopy.android.xposed.sharp.veilview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import com.nagopy.android.xposed.sharp.veilview.shortcut.DoOffActivity;
import com.nagopy.android.xposed.sharp.veilview.shortcut.DoOnActivity;
import com.nagopy.android.xposed.sharp.veilview.shortcut.GetStateActivity;
import com.nagopy.android.xposed.sharp.veilview.shortcut.SwitchActivity;

public class CreateShortcutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        CharSequence text = ((TextView) view).getText();
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_on:
                intent.setClass(getApplicationContext(), DoOnActivity.class);
                setShortcutResultAndFinish(intent, text);
                break;
            case R.id.btn_off:
                intent.setClass(getApplicationContext(), DoOffActivity.class);
                setShortcutResultAndFinish(intent, text);
                break;
            case R.id.btn_switch:
                intent.setClass(getApplicationContext(), SwitchActivity.class);
                setShortcutResultAndFinish(intent, text);
                break;
            case R.id.btn_getstate:

                intent.setClass(getApplicationContext(), GetStateActivity.class);
                setShortcutResultAndFinish(intent, text);
                break;
        }
    }

    private void setShortcutResultAndFinish(Intent shortcutIntent, CharSequence title) {
        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        Parcelable iconResource = Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                R.drawable.ic_launcher);
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);

        setResult(RESULT_OK, intent);
        finish();
    }

}
