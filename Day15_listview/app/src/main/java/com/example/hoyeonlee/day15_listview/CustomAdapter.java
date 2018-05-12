package com.example.hoyeonlee.day15_listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hoyeonlee on 2018. 3. 15..
 */

public class CustomAdapter extends BaseAdapter {
    ArrayList<Data_Music> data;

    public CustomAdapter(ArrayList<Data_Music> data){
        this.data = data;
    }
    //데이터의 갯수를 넣어준다
    @Override
    public int getCount() {
        return data.size();
    }
    //데이터를 넣어준다.
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
    //각 뷰들의 순서를 나타낸다.
    @Override
    public long getItemId(int position) {
        return position;
    }
    //뷰에 데이터를 넣는다.
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main,viewGroup,false);
        }
        TextView titleView = view.findViewById(R.id.tv_title);
        TextView artistView = view.findViewById(R.id.tv_artist);
        ImageView imageView = view.findViewById(R.id.imageview);

        titleView.setText(data.get(i).title);
        artistView.setText(data.get(i).artist);
        imageView.setImageResource(data.get(i).picture);

        return view;
    }
}
