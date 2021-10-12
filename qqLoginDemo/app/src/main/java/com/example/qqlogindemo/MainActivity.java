package com.example.qqlogindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 *当我们直接写一个文件名的时候，去写文件，会报出的异常是read-only
 * 在Android系统中，每一个应用就是一个用户，每个用户它的权限是特定的，不可以操作其他应用的1内容
 *
 * 以"/"未根目录的，它不是跟Windows一样
 * 当我们看到我们当前应用的数据保存目录下创建了这个文件“info.text”，说明我们可以保存数据了
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText mAccount;
    private EditText mPassword;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第一步，找到控件
        initView();
        //第二步，给登录按钮设置点击事件
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        File filesDir = this.getFilesDir();
//        File saveFile = new File(filesDir, "info.text");

        try {
            FileInputStream fileInputStream = this.openFileInput("info.text");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String info = bufferedReader.readLine();
            //fos.write((accountText+"***"+passwordText).getBytes());
            //上面一行代码是我们之前保存的数据形式，我需要对数据进行切割
            String[] splits = info.split("\\*\\*\\*");
            String account = splits[0];
            String password = splits[1];
            //回显数据
            mAccount.setText(account);
            mPassword.setText(password);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 给按钮设置点击的监听
     */
    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlerLoginEvent(view);
            }
        });

    }

    /**
     * 处理登录事件
     * @param view
     */
    private void handlerLoginEvent(View view) {

        //第三步，拿到登录界面上的内容，包括：账号和密码
        //账号
        String accountText = mAccount.getText().toString();
        //密码
        String passwordText = mPassword.getText().toString();

        //对账号进行检查/在实际开发中，我们需要对用户的账号进行合法性检查，比如说账号的长度，账号有没有敏感词
        //密码的检查也一样，一般来说是对密码的复杂度错检查

        //这里我只对这个密码和账号进行判空
//        if(accountText.length() == 0){
//            //账号长度为空
//            Toast.makeText(this,"账号不可以未空...",Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if(passwordText.length() == 0){
//            //密码长度为空
//            Toast.makeText(this,"密码不可以未空...",Toast.LENGTH_SHORT).show();
//            return;
//        }
        if (TextUtils.isEmpty(accountText)) {
            //账号为空
            Toast.makeText(this,"账号不可以未空...",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(passwordText)) {
            //密码为空
            Toast.makeText(this,"密码不可以未空...",Toast.LENGTH_SHORT).show();
            return;
        }

        //保存账号和密码：

        saveUserInfo(accountText, passwordText);

        //数据置空
        mAccount.setText(null);
        mPassword.setText(null);

    }

    private void saveUserInfo(String accountText, String passwordText) {
        Log.d(TAG,"保存用户信息...");

        /**
         * 怎么获得文件的存储路径? data/data/com.example.qqlogindemo/files
         * 输出结果：files dir == data/data/com.example.qqlogindemo/files
         * 也就是说，这个getFilesDir()这个方法它拿到的路径是/data/user/0/包名/files这个路径
         */

        /**
         * cache dir == /data/user/0/com.example.qqlogindemo/cache
         * 上面这个路径是一个缓存路径，用于保存缓存文件，这个目录下的文件，会由系统根据存储情况进行清理
         * 如果不够用了，就会清理
         * files dir == data/data/com.example.qqlogindemo/files
         * 下面这个路径是我们用于保存文件的，我们可以有代码清理，，也可以通过设置里的应用列表里的选项进行清理
         */

        //获取缓存文件存储的路径
        File cacheDir = this.getCacheDir();
        Log.d(TAG,"cache dir == " + cacheDir.toString());

        File filesDir = this.getFilesDir();
        File saveFile = new File(filesDir, "info.text");
        Log.d(TAG,"files dir == " + filesDir.toString());

        try {
            //File file = new File("data/data/com.example.qqlogindemo/info.text");
            if (!saveFile.exists()){
                saveFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(saveFile);
            //以特定的方式来存储
            //我们的账号***我们的密码
            fos.write((accountText+"***"+passwordText).getBytes());

            fos.close();

            Toast.makeText(this,"数据保存成功...",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initView() {
        mAccount = this.findViewById(R.id.et_account);
        mPassword = this.findViewById(R.id.et_password);
        mLogin = this.findViewById(R.id.bt_login);
    }

}