package com.example.broadcastdemoforcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mBatteryLevelText;
    private TextView mBatteryPercentText;
    private BatteryLevelReceiver mBatteryLevelReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        registerBatteryReceiver();

    }

    private void initView() {
        mBatteryLevelText = this.findViewById(R.id.battery_level);
        mBatteryPercentText = this.findViewById(R.id.battery_percent);

    }

    private void registerBatteryReceiver() {
        //第二步
        //我们要收听的频道是：电量变化
        //设置过滤器
        IntentFilter intentFilter = new IntentFilter();

        //第三步
        //设置频道(电量)
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        //（充电器是否连接）
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        //第四步
        mBatteryLevelReceiver = new BatteryLevelReceiver();
        //第五步
        //注册广播
        //动态注册
        this.registerReceiver(mBatteryLevelReceiver, intentFilter);
    }

    /**
     * 第一步，创建一个广播接收者
     */
    private class BatteryLevelReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(Intent.ACTION_BATTERY_CHANGED.equals(action)){
                Log.d(TAG, "收到了电量变化的广播  -   action is == " + action);
                int currentLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                Log.d(TAG, "当前电量为： " + currentLevel);
                if(mBatteryLevelText != null){
                    mBatteryLevelText.setText("当前电量为： " + intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0));
                }

                int maxLevel = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);

                //拿到当前电量以后，再除以最大值
                float persent = currentLevel / maxLevel;
                Log.d(TAG, "当前电量百分比为： " + persent );

                if(mBatteryPercentText != null){
                    mBatteryPercentText.setText("当前电量百分比为： " + persent );
                }
            }else if(Intent.ACTION_POWER_CONNECTED.equals(action)){
                Log.d(TAG, "sub线已连接...");
            }else if(Intent.ACTION_POWER_DISCONNECTED.equals(action)){
                Log.d(TAG, "usb线已断开...");
            }


        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消广播注册，否则会导致泄漏
        if (mBatteryLevelReceiver != null) {
            this.unregisterReceiver(mBatteryLevelReceiver);
        }
    }
}