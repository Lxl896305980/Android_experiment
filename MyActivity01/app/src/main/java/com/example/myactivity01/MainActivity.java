package com.example.myactivity01;

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
 * 实现界面的跳转并且把数据传输到另一个界面
 *
 * 有两种意图来实现页面跳转（显示意图和隐式意图）
 * 显示意图：用于应用内组件跳转
 * 隐式意图：用于应用之间的跳转
 * 第三方应用的跳转
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Mainactivity";
    private EditText mAcount;
    private EditText mPassword;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();

    }

    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //登录按钮被点击
                Log.e(TAG, "Login clicker..");
                handlerLogin();
            }
        });
    }

    private void handlerLogin() {
        String acountText = mAcount.getText().toString().trim();
        if(TextUtils.isEmpty(acountText)){
            Toast.makeText(this,"输入的账号为空",Toast.LENGTH_SHORT).show();
            return;
        }
        String passwordText = mPassword.getText().toString().trim();
        if(TextUtils.isEmpty(passwordText)){
            Toast.makeText(this,"输入的密码为空",Toast.LENGTH_SHORT).show();
            return;
        }

        //获得账号和密码之后，将数据传输到另一个界面
        //首先创建一个意图对象，然后通过StartActivity方法跳转
        //显示意图
        //Intent intent = new Intent(this,SecondActivity.class);//该行为代码为下面4行代码的封装
        Intent intent = new Intent();
        String packageName = this.getPackageName();
        String name = SecondActivity.class.getName();
        intent.setClassName(packageName, name);

        Log.d(TAG,"packgrName" + packageName);
        Log.d(TAG,"name" + name);

        intent.putExtra("acount", acountText);
        intent.putExtra("password" , passwordText);
        startActivity(intent);
        //隐式意图
//        Intent intent = new Intent();
//        intent.setAction("com.example.LONGIN_INFO");
//        //intent.addCategory("android.intent.category.DEFAULT");//该方法为下方代码的另一种写法
//        intent.addCategory(Intent.CATEGORY_DEFAULT);
//        intent.putExtra("acount", acountText);
//        intent.putExtra("password" , passwordText);
//        startActivity(intent);
    }

    private void initView(){
        mAcount = ((EditText) this.findViewById(R.id.acount));
        mPassword = ((EditText) this.findViewById(R.id.password));
        mLogin = this.findViewById(R.id.login);
    }

}