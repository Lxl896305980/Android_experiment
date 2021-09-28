package com.example.activitylifecircledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String MSG_RECORD = "msg_record";
    private static final String RECORD_KEY = "msg";
    private EditText mContentBox;
    private Button mSendBtn;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
        //恢复数据
        mSharedPreferences = this.getSharedPreferences(MSG_RECORD, MODE_PRIVATE);
        String revord = mSharedPreferences.getString(RECORD_KEY, null);
        if( !TextUtils.isEmpty(revord) ){
            mContentBox.setText(revord);
        }

    }

    private void initListener() {
        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取信息内容
                String content = mContentBox.getText().toString().trim();

                if(TextUtils.isEmpty(content)){
                    Toast.makeText(MainActivity.this,"请输入要发送的内容",Toast.LENGTH_SHORT).show();
                    return;
                }

                Log.d(TAG, "发送信息..." + content);
            }
        });
    }

    private void initView() {
        mContentBox = this.findViewById(R.id.content);
        mSendBtn = this.findViewById(R.id.send);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //把数据保存起来，保存到sharePreference里
        String content = mContentBox.getText().toString().trim();
        Log.d(TAG, "存储信息..." + content);
        if ( !TextUtils.isEmpty(content) ){
            SharedPreferences.Editor editor = mSharedPreferences.edit();
            editor.putString(RECORD_KEY,content);
            editor.commit();
        }

    }
}