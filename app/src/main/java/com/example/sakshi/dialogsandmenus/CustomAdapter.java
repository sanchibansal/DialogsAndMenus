package com.example.sakshi.dialogsandmenus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by sakshi on 7/26/2017.
 */

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Data> list;
    private LayoutInflater mLayoutInflator;
    //parameterized constructor
    public CustomAdapter(Context context, ArrayList list){
        this.context=context;
        this.list=list;
        //Layout Inflator
        mLayoutInflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        //returns list Size
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        //Returns item
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        //returns position
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflating layout
        convertView = mLayoutInflator.inflate(R.layout.row,null);
        //associating TextViews with their respective ids
        TextView name = (TextView)convertView.findViewById(R.id.name);
        TextView age = (TextView)convertView.findViewById(R.id.agedata);
        TextView dob = (TextView)convertView.findViewById(R.id.dob);
        //setting data in these TextViews
        name.setText(list.get(position).getName());
        age.setText(String.valueOf(list.get(position).getAge()));
        dob.setText(list.get(position).getDate());
        //return view
        return convertView;
        }
}
