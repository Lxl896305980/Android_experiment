package com.example.componentdatadeliver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 第一个，实现基本数据类型传递
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 这个方法用于跳转到第二个页面
     * @param view
     */
    public void skip2Second(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("intKey" ,100);
        intent.putExtra("booleanKey" ,true);
        startActivity(intent);
    }
}