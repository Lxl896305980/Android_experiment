package com.example.activitylauchmode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toFirst(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }

    public void toSecond(View view) {
        startActivity(new Intent(this,SecondActivity.class));
    }
}