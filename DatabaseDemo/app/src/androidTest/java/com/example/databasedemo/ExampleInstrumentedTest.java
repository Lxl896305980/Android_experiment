package com.example.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.databasedemo", appContext.getPackageName());

    }

    @Test
    public void testCreate(){
        //测试创建数据库
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Dao dao = new Dao(context);

    }

    @Test
    public void testInsert(){
        //测试插入数据
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Dao dao = new Dao(context);
        dao.insert();

    }

    @Test
    public void testDelete(){
        //测试删除数据
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Dao dao = new Dao(context);
        dao.delete();
    }

    @Test
    public void testUpdate(){
        //测试修改数据
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Dao dao = new Dao(context);
        dao.update();
    }

    @Test
    public void testQuery(){
        //测试修改数据
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Dao dao = new Dao(context);
        dao.query();
    }

}