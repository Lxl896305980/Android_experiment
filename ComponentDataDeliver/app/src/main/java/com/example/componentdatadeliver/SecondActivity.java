package com.example.componentdatadeliver;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        if(intent != null){
            int inValue = intent.getIntExtra("intKey", -1);
            boolean booleanValue = intent.getBooleanExtra("booleanKey" , false);
            Log.d(TAG, "int vale == " + inValue);
            Log.d(TAG, "boolean == " + booleanValue);

            User user = intent.getParcelableExtra("userKey");

            if(user != null){
                Log.d(TAG, "userName == " + user.getName());
                Log.d(TAG, "userAge == " + user.getAge());
                Log.d(TAG, "userTall == " + user.getTall());
            }

        }
    }
}
