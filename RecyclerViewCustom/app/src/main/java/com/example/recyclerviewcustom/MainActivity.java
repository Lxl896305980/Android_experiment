package com.example.recyclerviewcustom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<People> peopleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPeoples();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        PeopleAdapter adapter = new PeopleAdapter(peopleList);
        recyclerView.setAdapter(adapter);
    }

    private void initPeoples(){
        for (int i = 0 ; i<2 ; i++){
            People people1 = new People("people1",R.drawable.sky01);
            peopleList.add(people1);
            People people2 = new People("people2",R.drawable.sky02);
            peopleList.add(people2);
            People people3 = new People("people3",R.drawable.sky03);
            peopleList.add(people3);
            People people4 = new People("people4",R.drawable.sky04);
            peopleList.add(people4);
            People people5 = new People("people5",R.drawable.sky05);
            peopleList.add(people5);
            People people6 = new People("people6",R.drawable.sky06);
            peopleList.add(people6);
            People people7 = new People("people7",R.drawable.sky07);
            peopleList.add(people7);
            People people8 = new People("people8",R.drawable.sky08);
            peopleList.add(people8);
            People people9 = new People("people9",R.drawable.sky09);
            peopleList.add(people9);
            People people10 = new People("people10",R.drawable.sky10);
            peopleList.add(people10);
        }

    }
}