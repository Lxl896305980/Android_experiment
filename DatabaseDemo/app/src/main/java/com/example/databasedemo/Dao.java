package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * 这个类用于操作数据库的增删改查
 */

public class Dao {

    private static final String TAG = "Dao";
    private final DatabaseHelper mHelper;

    public Dao(Context context){

        //创建数据库
        mHelper = new DatabaseHelper(context);
        mHelper.getWritableDatabase();

    }

    public void insert(){

        SQLiteDatabase db = mHelper.getWritableDatabase();
//        String sql = "insert into " + Constants.TABLE_NAME + "(_id,name,age,salary,phone,address) values (?,?,?,?,?,?)";
//        db.execSQL(sql,new Object[]{1,"BillCates",60,1,110,"USA"});

        ContentValues values = new ContentValues();

        //添加数据
        values.put("_id",1);
        values.put("name","zed");
        values.put("age",30);
        values.put("salary",9);
        values.put("phone",110022);
        values.put("address", "CHA");

        db.insert(Constants.TABLE_NAME, null, values);

        db.close();

    }

    public void delete(){

        SQLiteDatabase db = mHelper.getWritableDatabase();
//        String sql = "delete from " + Constants.TABLE_NAME + " where age = 60";
//        db.execSQL(sql);

        int result = db.delete(Constants.TABLE_NAME, null, null);
        Log.d(TAG,"result="+result);

        db.close();

    }

    public void update(){

        SQLiteDatabase db = mHelper.getWritableDatabase();
//        String sql = "update " + Constants.TABLE_NAME + " set salary = 2 where age = 60";
//        db.execSQL(sql);

        /**
         *  “values”代表相关字段的内容修改成的新数据，
         *  “whereClause” 找到字段名 XXXX=?的信息，
         *  “whereArgs”表中已经存在的一条数据信息，
         *  然后调用update修改。
         */

        ContentValues values = new ContentValues();
        values.put("phone",111111);

        //String whereClause = "_id=1";
        //String[] whereArgs = {""};

        db.update(Constants.TABLE_NAME,values,"_id=1",null);

        db.close();

    }

    public void query(){

        SQLiteDatabase db = mHelper.getWritableDatabase();
//        String sql = "select * from " + Constants.TABLE_NAME;
//        Cursor cursor = db.rawQuery(sql,null);
//
//        while (cursor.moveToNext()) {
//
//            int index = cursor.getColumnIndex("name");
//
//            String name = cursor.getString(index);
//            Log.d(TAG, "name ==" + name);
//
//        }

        Cursor cursor = db.query(Constants.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            Log.d(TAG,"ID="+id+"***"+"name="+name);
        }

        cursor.close();

        db.close();

    }

}
