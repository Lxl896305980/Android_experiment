package com.example.mytoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tb);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("ACE","onClick: toolbar被点击了");
            }
        });

        Toolbar toolbar1 = findViewById(R.id.tb1);

        toolbar1.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar1.setTitle("标题");
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("ACE","onClick: toolbar1被点击了");
            }
        });
    }
}