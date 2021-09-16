package com.example.listviewcustom;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PeopleAdapter extends ArrayAdapter<People> {

    private int resourceId;

    public PeopleAdapter(Context context, int textViewResourceId, List<People> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        People people = getItem(position);//获取当前项的People实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView peopleImage = (ImageView) view.findViewById(R.id.people_image);
        TextView peopleName = (TextView) view.findViewById(R.id.peoplename);
        peopleImage.setImageResource(people.getImageId());
        peopleName.setText(people.getName());

        Log.e("ACE","getview" + position);

        return view;
    }

}
