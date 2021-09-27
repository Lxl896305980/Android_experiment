package com.example.recyclerviewnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.recyclerviewnew.Adapter.GridViewAdapter;
import com.example.recyclerviewnew.Adapter.ListViewAdapter;
import com.example.recyclerviewnew.Bean.Datas;
import com.example.recyclerviewnew.Bean.ItemBean;

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
                break;
            case R.id.stagger_view_vertical_reverse:
                Log.e(TAG,"点击StaggerView中的反向垂直");
                break;
            case R.id.stagger_view_horizontal_stander:
                Log.e(TAG,"点击StaggerView中的水平标准");
                break;
            case R.id.stagger_view_horizontal_reverse:
                Log.e(TAG,"点击StaggerView中的反向水平");
                break;

        }

        return super.onOptionsItemSelected(item);
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
        GridViewAdapter adapter = new GridViewAdapter(mData);
        //设置到RecycleView里
        mlist.setAdapter(adapter);
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
        layoutManager.setOrientation(isVertical? LinearLayoutManager.VERTICAL:LinearLayoutManager.HORIZONTAL);
        //设置标准（正向）还是反向
        layoutManager.setReverseLayout(isReverse);
        mlist.setLayoutManager(layoutManager);

        /**
         * 创建适配器
         */
        ListViewAdapter adapter = new ListViewAdapter(mData);
        //设置到RecycleView里
        mlist.setAdapter(adapter);
    }
}