package com.example.qqlogindemo;

import android.os.Bundle;
import android.os.Environment;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.text.Format;

public class SDCardDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SDCardDemoActivity";
    private Button mWriterDataBtn;
    private Button mCheckSdCardBtn;
    private Button mGetFreeSizeBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局
        setContentView(R.layout.activity_sd_card);
        initView();
        //设置监听事件
        initListener();
    }

    protected void initListener(){
        mWriterDataBtn.setOnClickListener(this);
        mCheckSdCardBtn.setOnClickListener(this);
        mGetFreeSizeBtn.setOnClickListener(this);
    }

    private void initView() {
        mWriterDataBtn = this.findViewById(R.id.write_data_2_sd_card_btn);
        mCheckSdCardBtn = this.findViewById(R.id.sd_card_check_btn);
        mGetFreeSizeBtn = this.findViewById(R.id.get_sd_free_size);
    }

    @Override
    public void onClick(View view) {

        //获取SD卡的路径
//        File externalStorageDirectory = Environment.getExternalStorageDirectory();
//        Log.d(TAG,"Ext-FilePath == " + externalStorageDirectory);
        
        if (view == mWriterDataBtn) {
            //写数据到SD卡上
            File filePath = new File("/storage/emulated/0");
            File file = new File(filePath,"info.text");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("ACE:凯德6号".getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(view == mCheckSdCardBtn){
            //点击的是检查是否有SD卡挂载
            String state = Environment.getExternalStorageState();
            if(state.equals(Environment.MEDIA_MOUNTED)){
                Log.d(TAG, "SD卡已经挂载，可用...");
            }else if(state.equals(Environment.MEDIA_REMOVED)){
                Log.d(TAG, "SD卡已经删除，不可以...");
            }
        }else if(view == mGetFreeSizeBtn){
            File exFile = Environment.getExternalStorageDirectory();
            Log.d(TAG, "Ext-FilePath == " + exFile);
            long freeSpace = exFile.getFreeSpace();
            //把long转化成我们直观的空间大小，比如：多少M、多少KB、多少GB
            String sizeText = Formatter.formatFileSize(this, freeSpace);
            Log.d(TAG, "free size == " + sizeText);
        }

    }
}
