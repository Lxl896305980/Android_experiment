package com.example.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    /**
     * @param context   上下文
     * name      数据库名称
     * factory   游标工厂
     * version   版本号
     */

    public DatabaseHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.VERSION_CODE);
    }

    /**
     * 第一次创建数据库的时候被调用
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建时的回调方法
        Log.d(TAG, "创建数据库...");
        //创建字段
        //sql: create table table_name(_id integer,name varchar,age integer,salary integer);
        String sql = "create table "+Constants.TABLE_NAME+" (_id integer,name varchar,age integer,salary integer)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //升级数据库时的回调方法
        Log.d(TAG, "升级数据库...");

        String sql;

        switch (i){
            case 1:
                //添加address和这个phone字段
                sql = "alter table " + Constants.TABLE_NAME + " add phone integer ";
                sqLiteDatabase.execSQL(sql);
                sql = "alter table " + Constants.TABLE_NAME + " add address varchar";
                sqLiteDatabase.execSQL(sql);
                break;
            case 2:
                //添加这个address字段
                //sql: alter table table_name add phone integer
                sql = "alter table " + Constants.TABLE_NAME + " add address integer";
                sqLiteDatabase.execSQL(sql);
                break;
            case 3:
                //创建新的数据表
                sql = "create table test (_id integer,name varchar,age integer,salary integer)";
                sqLiteDatabase.execSQL(sql);
                break;
        }

    }
}
