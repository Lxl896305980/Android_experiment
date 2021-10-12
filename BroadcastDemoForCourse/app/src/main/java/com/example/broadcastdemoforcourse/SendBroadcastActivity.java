package com.example.broadcastdemoforcourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SendBroadcastActivity extends AppCompatActivity {

    private EditText mInputBox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        mInputBox = (EditText) this.findViewById(R.id.be_send_msg_input_box);
    }

    /**
     * 当我们点击完发送广播后，该方法将被调用
     * @param view
     */
    public void sendBroadcastMsg(View view){
        //被调用以后，实现发送
        String content = mInputBox.getText().toString();
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_SEND_MSG);
        intent.putExtra(Constants.KEY_CONTENT,content);
        //发射广播
        sendBroadcast(intent);

    }

}
