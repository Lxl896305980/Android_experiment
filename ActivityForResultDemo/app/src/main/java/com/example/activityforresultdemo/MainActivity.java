package com.example.activityforresultdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 此案例用于了解:什么时数据回传,怎样实现数据回传
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button mReCharge;
    private TextView mPayResultText;

    private static final int PAY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initListener();
    }

    private void initListener() {
        mReCharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //设置一个点击事件,跳转到第二个界面 进行充值
                Intent intent = new Intent(MainActivity.this, PayActivity.class);
                //startActivity(intent);
                //使用startActivityResult代替原来的startActivity
                startActivityForResult(intent,PAY_REQUEST_CODE);
            }
        });
    }

    private void initView() {
        mReCharge = ((Button) this.findViewById(R.id.recharge_btn));
        mPayResultText = ((TextView) this.findViewById(R.id.pay_result));
    }

    /**
     * 返回的结果在这里回调
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode  == PAY_REQUEST_CODE ){
            String resultContent = null;
            if(resultCode == 2){
                //充值成功
                resultContent = data.getStringExtra("resultContent");
                Log.d(TAG,"payNumber == " + resultContent);
            }else if (resultCode == 3){
                //充值失败
                resultContent = data.getStringExtra("resultContent");
            }
            mPayResultText.setText(resultContent);
        }
    }
}