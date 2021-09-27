package com.example.recyclerviewdemo.Adapter;

import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewdemo.Bean.ItemBean;
import com.example.recyclerviewdemo.R;

import java.util.List;

public class StaggerViewAdapter extends RecyclerViewBaseAdapter{
    public StaggerViewAdapter(List<ItemBean> data) {
        super(data);
    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_stagger_view, null);
        return view;
    }
}
