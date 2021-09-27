package com.example.componentdatadeliver;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SendMsgActivity extends AppCompatActivity {

    private static final String TAG = "SendMsgActivity";
    private EditText mReceiverPhoneNumET;
    private EditText mContentET;
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        initView();

        Intent intent = getIntent();
        if (intent != null){
            String targetNumValue = intent.getStringExtra("targetNumKey");
            Log.d(TAG, "number is == " + targetNumValue);
            mReceiverPhoneNumET.setText(targetNumValue);
            Uri data = intent.getData();
            Log.d(TAG,"data is == " + data);
            if(data != null){
                String content = data.toString().replace("msg","");
                mContentET.setText(content);
            }
        }
    }

    private void initView() {
        mReceiverPhoneNumET = ((EditText) this.findViewById(R.id.receiver_phone_number_oi));
        mContentET = ((EditText) this.findViewById(R.id.msg_content_et));
        mButton = ((Button) this.findViewById(R.id.sent_msg_btn));
    }

}
