package com.example.viewpageandfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {

    private List<String> title = new ArrayList<>();
    private List<Integer> colors = new ArrayList<>();

    public ViewPagerAdapter(){
        title.add("HELLO");
        title.add("GOOD");
        title.add("OK");
        title.add("WINDOUS");
        title.add("ANDROID");

        colors.add(R.color.purple_200);
        colors.add(R.color.purple_500);
        colors.add(R.color.purple_700);
        colors.add(R.color.teal_200);
        colors.add(R.color.teal_700);

    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pager,parent,false);
        ViewPagerViewHolder holder = new ViewPagerViewHolder(view);
        return holder;
        //return new ViewPagerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pager,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        holder.mTv.setText(title.get(position));
        holder.mContainer.setBackgroundResource(colors.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewPagerViewHolder extends RecyclerView.ViewHolder {

        TextView mTv;
        RelativeLayout mContainer;

        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            mContainer = itemView.findViewById(R.id.container);
            mTv = itemView.findViewById(R.id.tv_title);
        }
    }
}
