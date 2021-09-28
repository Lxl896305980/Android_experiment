package com.example.activitylauchmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void toFirst(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }

    public void toSecond(View view) {
        startActivity(new Intent(this,SecondActivity.class));
    }
}
