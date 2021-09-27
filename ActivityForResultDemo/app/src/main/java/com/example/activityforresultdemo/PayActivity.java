package com.example.activityforresultdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 结构吗:resultCode
 * 结果码的作用:用于区分结果,一般来说,一个结果表示一种结果
 *
 * 下面例子中:
 * 2表示成功,3表示失败
 *
 * Activity里面有一个常量,用于表示成功的是-1
 * 失败是0
 * Standard activity result: operation cancel
 */

/** Standard activity result: operation cancel. */
//public static final int RESULT_CANCELED = 0;

/** Standard activity result: operation succeed. */
//public static final int RESULT_OK = -1;

public class PayActivity extends AppCompatActivity {

    private static final String TAG = "PayActivity";
    private EditText mInputBox;
    private Button mPayBtn;
    private Button mCancleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        initView();

        initListener();

    }

    private void initListener() {

        mCancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlerCancel();
            }
        });

        mPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlerPay();
            }
        });



    }

    private void handlerCancel() {

        Intent intent = new Intent();
        intent.putExtra("resultContent" , "充值失败");
        setResult(3, intent);
        finish();

    }

    private void handlerPay() {
        String payNumber = mInputBox.getText().toString().trim();
        Log.d(TAG,"payNumber == " + payNumber);
        if(TextUtils.isEmpty(payNumber)){
            Toast.makeText(PayActivity.this,"请输入金额!",Toast.LENGTH_SHORT).show();
            return;
        }
        //进行网络访问,进行充值(模拟)

        //setResult方法有两个重载,一个时只有resultCode的,另一个还有Intent
        Intent intent = new Intent();
        intent.putExtra("resultContent" , "充值成功");
        setResult(2,intent);
        finish();
    }

    private void initView() {
        mInputBox = ((EditText) this.findViewById(R.id.pay_input_box));
        mPayBtn = ((Button) this.findViewById(R.id.start_pay_btn));
        mCancleBtn = ((Button) this.findViewById(R.id.cancel_pay_btn));
    }
}