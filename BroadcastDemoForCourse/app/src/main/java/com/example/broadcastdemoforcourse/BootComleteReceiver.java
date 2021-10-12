package com.example.broadcastdemoforcourse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * 静态注册
 * 第一步：创建一个类，并且继承自BroadcastReceiver
 */

public class BootComleteReceiver extends BroadcastReceiver {
    private static final String TAG = "BootComleteReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(TAG, "action is == " + action);
        Log.d(TAG, "开机完成...");
        Toast.makeText(context,"收到开机完成的广播...", Toast.LENGTH_SHORT).show();
    }
}
