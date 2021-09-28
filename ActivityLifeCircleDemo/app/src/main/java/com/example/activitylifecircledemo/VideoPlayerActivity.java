package com.example.activitylifecircledemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 以后的工作中需要开发一个视频播放器，以下有这样一种场景
 * 当我们播放电影时来电话
 */

public class VideoPlayerActivity extends AppCompatActivity {
    private static final String TAG = "VideoPlayerActivity";
    private Button mPlayControlBtn;
    private TextView mStatusText;
    //是不是因为生命周期的变化而引发的主动停止
    private boolean isStopAtAmin = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        initView();
        initListener();
    }

    private boolean isPlays = false;
    private void initListener() {
        mPlayControlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlays){
                    //如果当前状态是播放的，将状态变为停止
                    stop();
                } else {
                    //如果当前状态是停止的，将状态变为播放
                    play();
                }
            }
        });
    }

    private void play(){
        Log.d(TAG, "播放电影");
        mStatusText.setText("正在播放电影");
        mPlayControlBtn.setText("暂停");
        isPlays = true;
    }

    private void stop(){
        Log.d(TAG, "停止播放电影");
        mStatusText.setText("电影停止播放");
        mPlayControlBtn.setText("播放");
        isPlays = false;
    }

    private void initView() {
        mStatusText = this.findViewById(R.id.current_player_status);
        mPlayControlBtn = this.findViewById(R.id.player_control);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart...");
        if(isStopAtAmin){
            play();
            isStopAtAmin = false;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop...");
        if(isPlays){
            //如果当前是播放，则停止
            stop();
            isStopAtAmin = true;
        }
    }
}
