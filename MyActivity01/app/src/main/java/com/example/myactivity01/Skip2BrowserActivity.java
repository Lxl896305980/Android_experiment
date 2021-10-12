package com.example.myactivity01;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Skip2BrowserActivity extends AppCompatActivity {

    private static final String TAG = "Skip2BrowserActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip2browser);
    }

    /**
     * 这个方法用于点击按钮时跳转到浏览器
     * @param view 这时被点击的Button
     *
     *             Component = cmp=com.android.browser/com.android.browser/.BrowserActivity
     *             //其实组件的名称，也就是ComponentName = 包名/类的路径名称
     *             当类前面的包名，也就是这个类所在的包个包名是一样的就可以省略
     *             完整：cmp=com.android.browser/com.android.browser/.BrowserActivity
     *             简略：cmp=com.android.browser/.BrowserActivity
     */
    public void skip2BrowserVisible(View view){
        Log.e(TAG,"skip2BrowserVisible");

        Intent intent = new Intent();
        //第一种写法
        intent.setClassName("com.android.browser","com.android.browser.BrowserActivity");

        //intent.setClassName("com.example.recyclerviewdemo","com.example.recyclerviewdemo.MainActivity");

        //第二种写法
//        ComponentName componentName = new ComponentName("com.android.browser","com.android.browser.BrowserActivity");
//        intent.setComponent(componentName);

        startActivity(intent);
    }

    /**
     * 通过隐式意图跳转到浏览器界面
     * 步骤
     * 1.创建Intent对象
     * 2.给Intent对象设置Action，设hi它的category值，如果Android5.1以上系统需要设置包名
     * 3.startActivity来跳转到另一个界面
     * @param view
     */
    public void skip2BrowserInvisible(View view) {
        Log.e(TAG,"skip2BrowserInvisible");

        Intent intent = new Intent();

//        <intent-filter>
//                <action android:name="android.intent.action.SEARCH" />
//                <category android:name="android.intent.category.DEFAULT" />
//            </intent-filter>

        intent.setAction("android.intent.action.SEARCH");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setPackage("com.android.browser");

        //下面代码用于只打开应用不需要跳转到指定页面时
        //intent = getPackageManager().getLaunchIntentForPackage("com.example.recyclerviewdemo");
        startActivity(intent);

    }
}
