package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 100; i++){
            Bean bean = new Bean();
            bean.setName("学习"+i);
            data.add(bean);
        }

        ListView listView = findViewById(R.id.lv);
        listView.setAdapter(new MyAdapter(data,this));

    }
}