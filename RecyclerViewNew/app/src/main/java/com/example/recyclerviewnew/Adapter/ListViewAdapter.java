package com.example.recyclerviewnew.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewnew.Bean.ItemBean;
import com.example.recyclerviewnew.R;

import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {

    /**
     *传入数据
     */
    private final List<ItemBean> mData;
    public ListViewAdapter(List<ItemBean> data){
        this.mData = data;
    }

    @NonNull
    /**
     *这个方法用于创建条目的view
     */
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**传入的这个view其实就是条目的界面
         * 两个步骤
         * 1、拿到view
         * 2、创建InnerHolder
         */
        View view = View.inflate(parent.getContext(), R.layout.item_list_view,null);
        return new InnerHolder(view);
    }
    /**
     * 这个方法用于绑定holder的，一般原来设置数据
     */
    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //在这设置数据
        holder.setData(mData.get(position));
    }

    /**
     *这个方法用于返回条目个数
     */
    @Override
    public int getItemCount() {
        if(mData != null){
            return mData.size();
        }
        return 0;
    }

    public class  InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView mIcon;
        private final TextView mTitle;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            //找到条目控件
            mIcon = (ImageView) itemView.findViewById(R.id.list_view_icon);
            mTitle = (TextView) itemView.findViewById(R.id.list_view_title);
        }

        /**
         * 这个方法用于设置数据
         */
        public void setData(ItemBean itemBean) {
            //开始设置数据
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);

        }
    }
}