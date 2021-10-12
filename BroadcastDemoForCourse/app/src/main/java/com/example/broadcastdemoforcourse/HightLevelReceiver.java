package com.example.broadcastdemoforcourse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class HightLevelReceiver extends BroadcastReceiver {

    private static final String TAG = "HightLevelReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "hight action is == " + intent.getAction());
        //终止广播
        //abortBroadcast();
        //修改广播内容
        Bundle resultExtras = getResultExtras(true);
        String content = resultExtras.getCharSequence("content").toString();
        Log.d(TAG,"content == " + content);
        resultExtras.putCharSequence("content","我是被修改过的广播内容...");
        setResultExtras(resultExtras);
    }
}
