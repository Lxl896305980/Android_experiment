package com.example.activitylandscapelifecricle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

/**
 * Activity在横竖屏切换的时候，生命周期变化
 *
 * onCreate...
 * onResume...
 * onPause...
 * onStop...
 * onDestroy...
 * onCeate...
 * onStart...
 * onResume...
 *
 * 进行横竖屏切换是Activity会被销毁，并且重新创建
 *
 * 在实际的开发中，我们遇到横竖屏切换有哪些场景
 * 1、游戏开发
 * 2、视频播放器
 * 3、其他使用场景
 *
 * 横竖屏切换，Activity生命周期的变化，会对我们开发带来什么结果
 *
 * 解决问题：
 * 1、禁止旋转，指定屏幕方向
 * 2、对配置不敏感
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SeekBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate...");

        initView();
    }

    private void initView() {
        mProgress = this.findViewById(R.id.progress);
        Log.d(TAG,"mProgress == " + mProgress.toString());
        //设置初始化数据
        mProgress.setMax(100);
        mProgress.post(new Runnable() {
            @Override
            public void run() {
                mProgress.setProgress(0);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy...");
    }
}