package com.example.hoyeonlee.day16_customlistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hoyeonlee on 2018. 3. 20..
 */

public class ListViewAdapter extends BaseAdapter {
    ArrayList<Item> data;
    ListViewAdapter(ArrayList<Item> data){
        this.data = data;
    }
    //Data의 갯수
    @Override
    public int getCount() {
        return data.size();
    }
    //해당 ListView의 Item의 순서(index)
    @Override
    public long getItemId(int position) {
        return position;
    }
    //해당 ListView의 Item의 data
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    //getCount의 갯수만큼 반복적으로 Template을 이용해 View를 만든다.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview,parent,false);
        }
        TextView nameView = convertView.findViewById(R.id.tv_name);
        TextView ageView = convertView.findViewById(R.id.tv_age);
        Item item = data.get(position);
        nameView.setText(item.name);
        ageView.setText(item.age);
        return convertView;
    }


















}
