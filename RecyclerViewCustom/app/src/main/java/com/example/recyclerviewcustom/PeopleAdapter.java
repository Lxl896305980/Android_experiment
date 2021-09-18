package com.example.recyclerviewcustom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private List<People> mPeopleList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        People people = mPeopleList.get(position);
        holder.peopleImage.setImageResource(people.getImageId());
        holder.peopleName.setText(people.getName());
    }

    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView peopleImage;
        TextView peopleName;

        public ViewHolder(View view){
            super(view);
            peopleImage = (ImageView) view.findViewById(R.id.people_image);
            peopleName = (TextView) view.findViewById(R.id.peoplename);
        }

    }

    public PeopleAdapter(List<People> peopleList){
        mPeopleList = peopleList;
    }
}
