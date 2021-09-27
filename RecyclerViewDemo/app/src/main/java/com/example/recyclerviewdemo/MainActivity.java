package com.example.recyclerviewdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.recyclerviewdemo.Adapter.GridViewAdapter;
import com.example.recyclerviewdemo.Adapter.ListViewAdapter;
import com.example.recyclerviewdemo.Adapter.RecyclerViewBaseAdapter;
import com.example.recyclerviewdemo.Adapter.StaggerViewAdapter;
import com.example.recyclerviewdemo.Bean.Datas;
import com.example.recyclerviewdemo.Bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 总结
 * 1、需要要在build中导入RecyclerView依赖包，才能在布局中使用RecycleView控件
 * 2、使用findViewById方法找到控件
 * 3、准备好数据
 * 4、设置布局管理器
 * 5、创建适配器
 * 6、设置适配器
 * 7、显示数据
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ACE";
    private RecyclerView mlist;
    private List<ItemBean> mData;
    private RecyclerViewBaseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        mlist = (RecyclerView)this.findViewById(R.id.recycler_view);
        /**准备数据
         *准备数据，一般来说，在现实开发中，数据是从网络中获取，这只时只是演示
         * 所以我们知识模拟数据，在现实开发中也需要模拟数据，比如说在后台数据没有准备时
         */
        initData();
        //设置默认的显示的样式为ListView
        showList(true,false);

    }

    private void initListener() {


            mAdapter.setOnItemClickListener(new RecyclerViewBaseAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    //这里处理条目的点击事件
                    Log.e(TAG,"onRecyclerItemClick: " + position);
                    Toast.makeText(MainActivity.this,"您点击的是第：" + position + "个条目",Toast.LENGTH_SHORT).show();
                }
            });
    }


    //这个方法用于模拟数据
    private void initData(){
        /**
         * List<DataBean>------>Adapter------>setAdapter------>显示数据
         * 创建数据集合
         */
        mData = new ArrayList<>();

         //创建模拟数据
        for(int i = 0; i< Datas.icons.length; i++){

             //创建数据对象
            ItemBean data = new ItemBean();
            data.icon=Datas.icons[i];
            data.title="我是第 " + i + "个条目";

            //添加到集合里
            mData.add(data);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId){

            /**
             * ListView效果
             */
            case R.id.list_view_vertical_stander:
                Log.e(TAG,"点击ListView中的垂直标准");
                showList(true,false);
                break;
            case R.id.list_view_vertical_reverse:
                Log.e(TAG,"点击ListView中的反向垂直");
                showList(true,true);
                break;
            case R.id.list_view_horizontal_stander:
                Log.e(TAG,"点击ListView中的水平标准");
                showList(false,false);
                break;
            case R.id.list_view_horizontal_reverse:
                Log.e(TAG,"点击ListView中的反向水平");
                showList(false,true);
                break;

            /**
             * GridView效果
             */
            case R.id.grid_view_vertical_stander:
                Log.e(TAG,"点击GridView中的垂直标准");
                showGrid(true,false);
                break;
            case R.id.grid_view_vertical_reverse:
                Log.e(TAG,"点击GridView中的垂反向垂直");
                showGrid(true,true);
                break;
            case R.id.grid_view_horizontal_stander:
                Log.e(TAG,"点击GridView中的水平标准");
                showGrid(false,false);
                break;
            case R.id.grid_view_horizontal_reverse:
                Log.e(TAG,"点击GridView中的反向水平");
                showGrid(false,true);
                break;

            /**
             * 瀑布流效果
             */
            case R.id.stagger_view_vertical_stander:
                Log.e(TAG,"点击StaggerView中的垂直标准");
                showStagger(true,false);
                break;
            case R.id.stagger_view_vertical_reverse:
                Log.e(TAG,"点击StaggerView中的反向垂直");
                showStagger(true,true);
                break;
            case R.id.stagger_view_horizontal_stander:
                Log.e(TAG,"点击StaggerView中的水平标准");
                showStagger(false,false);
                break;
            case R.id.stagger_view_horizontal_reverse:
                Log.e(TAG,"点击StaggerView中的反向水平");
                showStagger(false,true);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 这个方法用于实现瀑布流一样的效果
     */
    private void showStagger(boolean isVertical, boolean isReverse) {
        //准备布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,isVertical?
                StaggeredGridLayoutManager.VERTICAL:StaggeredGridLayoutManager.HORIZONTAL);
        //设置方向
        layoutManager.setReverseLayout(isReverse);
        //设置布局管理器到RecyclerView里
        mlist.setLayoutManager(layoutManager);
        //创建适配器
        mAdapter = new StaggerViewAdapter(mData);
        mlist.setAdapter(mAdapter);

        //初始化事件
        initListener();
    }

    /**
     * 这个方法用于实现GridView一样的效果
     */
    private void showGrid(boolean isVertical,boolean isReverse) {

        //创建布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        //设置水平还是垂直
        layoutManager.setOrientation(isVertical? LinearLayoutManager.VERTICAL:LinearLayoutManager.HORIZONTAL);
        //设置标准（正向）还是反向
        layoutManager.setReverseLayout(isReverse);
        mlist.setLayoutManager(layoutManager);

        /**
         * 创建适配器
         */
        mAdapter = new GridViewAdapter(mData);
        //设置到RecycleView里
        mlist.setAdapter(mAdapter);

        //初始化事件
        initListener();
    }

    /**
     * 这个方法用于实现ListView一样的效果
     */
    private void showList(boolean isVertical,boolean isReverse) {
        /**
         * RecyclerView需要设置样式，其实就是设置布局管理器
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器来控制
        //设置水平还是垂直
        layoutManager.setOrientation(isVertical? GridLayoutManager.VERTICAL:GridLayoutManager.HORIZONTAL);
        //设置标准（正向）还是反向
        layoutManager.setReverseLayout(isReverse);
        mlist.setLayoutManager(layoutManager);

        /**
         * 创建适配器
         */
        mAdapter = new ListViewAdapter(mData);
        //设置到RecycleView里
        mlist.setAdapter(mAdapter);

        //初始化事件
        initListener();
    }
}