package com.example.transcationdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context,"Testbase.db" ,null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table account (_id integer, name varchar ,money integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String sql;

        switch (i) {
            case 1:
                sql = "create table account1 (_id integer, name varchar ,money integer)";
                db.execSQL(sql);
                break;
            case 2:
                sql = "create table account2 (_id integer, name varchar ,money integer)";
                db.execSQL(sql);
                break;
            case 3:
                break;
        }

    }
}
