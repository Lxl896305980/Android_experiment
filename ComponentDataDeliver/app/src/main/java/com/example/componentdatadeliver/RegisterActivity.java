package com.example.componentdatadeliver;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView result1 = ((TextView) this.findViewById(R.id.register_result1));
        TextView result2 = ((TextView) this.findViewById(R.id.register_result2));

        Intent intent = getIntent();
        if(intent != null){
            String userName = intent.getStringExtra("userNameKey");
            result1.setText("恭喜: [" + userName + "] 注册成功");
            String userPassword = intent.getStringExtra("userPasswordKey");
            result2.setText("您的密码为: [" + userPassword + "]");
        }
    }
}
