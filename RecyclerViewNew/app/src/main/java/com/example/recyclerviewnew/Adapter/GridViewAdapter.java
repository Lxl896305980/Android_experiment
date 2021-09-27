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

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.InnerHolder> {

    /**
     *传入数据
     */
    private final List<ItemBean> mData;
    public GridViewAdapter(List<ItemBean> data){
        this.mData = data;
    }

    @NonNull
    /**
     *这个方法用于创建条目的View
     */
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //在这创建条目的UI
        View view = View.inflate(parent.getContext(), R.layout.item_grid_view,null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
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
            mIcon = (ImageView) itemView.findViewById(R.id.grid_view_icon);
            mTitle = (TextView) itemView.findViewById(R.id.grid_view_title);
        }

        public void setData(ItemBean itemBean) {
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);

        }
    }
}