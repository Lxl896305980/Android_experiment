package com.example.mypopupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ACE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ACECilck(View view) {
        View popupView = getLayoutInflater().inflate(R.layout.popup_view, null);

        View btn1 = popupView.findViewById(R.id.bt1);
        View btn2 = popupView.findViewById(R.id.bt2);

        //getLayoutInflater动态加载布局文件，实现弹窗效
        PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,true);

        //getResources用户获取存在的系统资源
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.sky1));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG,"上海");
                //Intent i = new Intent(MainActivity.this , TextActivity.class);
                //startActivity(i);
                popupWindow.setOutsideTouchable(true);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG,"北京");
                popupWindow.dismiss();
            }
        });

        popupWindow.showAsDropDown(view);
        //实现偏移
        //popupWindow.showAsDropDown(view,view.getWidth(),-view.getHeight());
    }
}


