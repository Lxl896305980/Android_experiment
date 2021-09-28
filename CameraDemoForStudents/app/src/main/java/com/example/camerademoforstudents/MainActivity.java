package com.example.camerademoforstudents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private ImageView mResultContainer;
    private ImageView mTakePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();

    }

    private void initListener() {
        mTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //拍照的按钮被点击以后，要跳转到系统的相机页面
                //startActivityForResult();

                Intent intent = new Intent();

                intent.setAction("android.media.action.IMAGE_CAPTURE");
                intent.addCategory(Intent.CATEGORY_DEFAULT);

                startActivityForResult(intent,REQUEST_CODE);
                
            }
        });
    }

    private void initView() {
        mResultContainer = ((ImageView) this.findViewById(R.id.photo_result_container));
        mTakePhoto = ((ImageView) this.findViewById(R.id.take_photo));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK && data != null){
                //成功返回 
                Bitmap result = data.getParcelableExtra("data");
                if(result != null){
                    mResultContainer.setImageBitmap(result);
                }
            }else if(resultCode == Activity.RESULT_CANCELED){
                //取消返回或返回失败
                Toast.makeText(this,"您取消了拍照" ,Toast.LENGTH_SHORT).show();
            }
        }
    }
}