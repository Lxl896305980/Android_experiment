package com.example.mydialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ACE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ACECilck(View view) {

        View dialogView = getLayoutInflater().inflate(R.layout.dialog_view, null);

       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setIcon(R.mipmap.ic_launcher)
               .setTitle("乌鸦")
               .setMessage("ACE 凯德")
               .setView(dialogView)
               .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       Log.e(TAG, "onClick: 点击了确定");
                   }
               })
               .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       Log.e(TAG, "onClick: 点击了取消");
                   }
               })
               .setNeutralButton("中间", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       Log.e(TAG, "onClick: 点击了中间");
                   }
               })
               .create()
               .show();
    }
}