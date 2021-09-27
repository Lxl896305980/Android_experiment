package com.example.componentdatadeliver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


/**
 * 第一个，实现基本数据类型传递
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 这个方法用于跳转到第二个页面
     * @param view
     */
    public void skip2Second(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("intKey" ,100);
        intent.putExtra("booleanKey" ,true);
        startActivity(intent);
    }

    /**
     * 这个方法将一个界面传到另一个界面
     * @param view
     */
    public void deliverObject(View view) {

        /**
         * 步骤:
         * 和前面一样,先实现界面的跳转
         * 创建对象,所创建的对象要实现Parcelable接口
         * 使用putExtra的方式传入数据,并且需要一个key
         * 在第二个界面通过key来获取传递的对象
         */

        Intent intent = new Intent(this,SecondActivity.class);

        User user = new User();
        user.setName("雷");
        user.setAge(21);
        user.setTall(170.0f);

        Bitmap tempBitmap = null;
        intent.putExtra("bitMapKey", tempBitmap);
        intent.putExtra("stringKey", "String Calue");

        intent.putExtra("userKey",user);

        startActivity(intent);
    }

    /**
     * 打电话到10086
     * @param view
     */
    public void call(View view) {

//    <intent-filter>
//        <action android:name="android.intent.action.CALL" />
//        <category android:name="android.intent.category.DEFAULT" />
//    </intent-filter>

//        Intent intent = new Intent();
        //获得授权，拨打电话
        //调用checkSelfPermission检查是否有权限
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
//                == PackageManager.PERMISSION_GRANTED) {
//            intent.setAction("android.intent.action.CALL");
//            intent.addCategory("android.intent.category.DEFAULT");
//
//            Uri uri = Uri.parse("tel:10086");
//            intent.setData(uri);
//
//            startActivity(intent);
//        }else{
//            //无权限则询问开启权限
//            ActivityCompat.requestPermissions(this,new String []{Manifest.permission.
//                    CALL_PHONE},1);
//            intent.setAction("android.intent.action.CALL");
//            intent.addCategory("android.intent.category.DEFAULT");
//
//            Uri uri = Uri.parse("tel:10086");
//            intent.setData(uri);
//
//            startActivity(intent);
//        }
        //简写
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10086"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(intent);

    }

    public void sendMsg(View view) {
        Intent intent = new Intent();

        intent.setAction("com.example.componentdatadeliver.SEND.MSG");
        //intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory(intent.CATEGORY_DEFAULT);

        intent.putExtra("targetNumKey", "10086");
        intent.setData(Uri.parse("msg 帮我查下话费"));
        //scheme:后面的内容...

        startActivity(intent);
    }
}