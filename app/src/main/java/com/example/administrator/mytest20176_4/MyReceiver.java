package com.example.administrator.mytest20176_4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by LCT
 * Time:2016/4/7 15:36.
 * Annotation：
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String actiion=intent.getAction();
        if (actiion.equals(MainActivity.ACTION_STATIC_NAME)) {
            Bundle bundle=intent.getExtras();
            String data=bundle.getString("yaner");
            Toast.makeText(ApplicationContext.context,data,Toast.LENGTH_SHORT);
        }

    }
}
