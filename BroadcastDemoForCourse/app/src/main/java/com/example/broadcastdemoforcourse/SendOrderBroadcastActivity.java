package com.example.broadcastdemoforcourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SendOrderBroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_order_broadcast);
    }

    /**
     * 这个表示我们的发送按钮被点击了
     * @param view
     */
    public void sendOrderBroadcast(View view){

        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_ORDER_BROADCAST_TEST);
        Bundle bundle = new Bundle();
        bundle.putCharSequence("content","我是广播");
        //发送者权限(发送者定义哪个接收者可以接收到自己信息)
//        sendOrderedBroadcast(intent, Manifest.permission.ORDER_PERMISSION,null,null, Activity.RESULT_OK,null,bundle);
        //接收者权限（接收者定义哪个发送者的信息可以被自己接收）
        sendOrderedBroadcast(intent, null,null,null, Activity.RESULT_OK,null,bundle);

    }
}
