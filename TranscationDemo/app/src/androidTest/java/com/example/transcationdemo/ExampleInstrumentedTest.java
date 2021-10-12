package com.example.transcationdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private static final String TAG = "Test";

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.transcationdemo", appContext.getPackageName());
    }

    @Test
    public void testDatabase(){
        //测试创建数据库
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DatabaseHelper helper = new DatabaseHelper(appContext);
        helper.getReadableDatabase();

    }

    @Test
    public void testInsert(){
        //测试添加数据
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DatabaseHelper helper = new DatabaseHelper(appContext);
        SQLiteDatabase db = helper.getReadableDatabase();

        long start = System.currentTimeMillis();

        db.beginTransaction();

        db.execSQL("insert into account values(1,'company',1000000)");
        db.execSQL("insert into account values(2,'my_count',0)");

        db.endTransaction();

        Log.d(TAG, "运行时间为 == " + start);

        db.close();

    }

    @Test
    public void testUpdate(){
        //测试添加数据表
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DatabaseHelper helper = new DatabaseHelper(appContext);
        SQLiteDatabase db = helper.getReadableDatabase();

        db.beginTransaction();

        try {

            db.execSQL("update account set money = 1000000-12000 where name = 'company'");

            //发生异常
            //int i = 10/0;

            db.execSQL("update account set money = 0+12000 where name = 'my_count'");

            db.setTransactionSuccessful();

        }catch (Exception e){
            //处理异常
            throw new RuntimeException("停电了...");
        }finally {
            db.endTransaction();
            db.close();
        }

    }

    @Test
    public void testAddtable(){
        //测试添加数据表
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DatabaseHelper helper = new DatabaseHelper(appContext);
        SQLiteDatabase db = helper.getReadableDatabase();

        helper.onUpgrade(db,1,2);

        db.close();

    }

    @Test
    public void testAddtable2(){
        //测试添加数据表
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        DatabaseHelper helper = new DatabaseHelper(appContext);
        SQLiteDatabase db = helper.getReadableDatabase();

        db.execSQL("create table account2 (_id integer, name varchar ,money integer)");

        db.close();

    }

}