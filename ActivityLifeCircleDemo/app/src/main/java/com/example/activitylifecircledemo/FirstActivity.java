package com.example.activitylifecircledemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.d(TAG, "onCreate...");
    }

    /**
     * onStart以已经可见了，并且获得焦点，也就是说没有获取焦点就不可以进行操作
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart...");
    }

    /**
     * 可见，并且获得焦点，也就是说可以进行操作，可以进行交互
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume...");
    }

    /**
     * onPause其实是暂停的意思，这个方法其实是失去了焦点，不可以操作
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause...");
    }

    /**
     * onStop已经不可见了
     */
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

    public void skip2SecondActivity(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
