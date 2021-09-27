package com.example.componentdatadeliver;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText mUserNameET;
    private EditText mUserPasswordET;
    private Button mRegisterBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        //给按钮设置一个点击监听事件
        initListener();
    }

    private void initListener() {
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //处理注册
                handlerRegister();
            }
        });
    }

    private void handlerRegister(){
        String userNameText = mUserNameET.getText().toString().trim();
        //这个方法有两个判断,判空和字符长度
        if(TextUtils.isEmpty(userNameText)){
            Toast.makeText(this,"用户名为空",Toast.LENGTH_SHORT).show();
        }

        String userPasswordText = mUserPasswordET.getText().toString().trim();
        if(TextUtils.isEmpty(userPasswordText)){
            Toast.makeText(this,"密码为空",Toast.LENGTH_SHORT).show();
        }
        //注册
        Intent intent = new Intent(this,RegisterActivity.class);
        intent.putExtra("userNameKey",userNameText);
        intent.putExtra("userPasswordKey",userPasswordText);
        startActivity(intent);

        //结束当前页面
        this.finish();
    }

    private void initView() {
        mUserNameET = ((EditText) this.findViewById(R.id.user_name_et));
        mUserPasswordET = ((EditText) this.findViewById(R.id.user_password_et));
        mRegisterBtn = ((Button) this.findViewById(R.id.register_btn));
    }

}
