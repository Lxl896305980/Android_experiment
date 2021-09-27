package com.example.myactivity01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextView info = ((TextView) this.findViewById(R.id.info));

        Intent intent = getIntent();
        String acount = intent.getStringExtra("acount");
        String password = intent.getStringExtra("password");

        Log.e(TAG,"acount == " + acount);
        Log.e(TAG, "password == " + password);

        info.setText("账号：" + acount + "  " + "密码：" + password);

    }
}
