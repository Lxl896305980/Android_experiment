package com.example.qqlogindemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PreferenceDemoActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "PreferenceDemoActivity";
    private Switch mIsAllowUnkownSource;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_demo);
        //找到控件
        mIsAllowUnkownSource = this.findViewById(R.id.is_allow_unknown_apps_sources_switch);
        mIsAllowUnkownSource.setOnCheckedChangeListener(this);
        mSharedPreferences = this.getSharedPreferences("settings_info", MODE_PRIVATE);
        boolean state = mSharedPreferences.getBoolean("state", false);
        mIsAllowUnkownSource.setChecked(state);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        //我们在这里需要对数据进行保存
        Log.d(TAG, "current state == " + b);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean("state", b );
        editor.commit();
    }
}
