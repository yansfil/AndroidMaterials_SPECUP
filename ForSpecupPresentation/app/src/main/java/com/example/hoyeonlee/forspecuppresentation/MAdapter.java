package com.example.hoyeonlee.forspecuppresentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hoyeonlee on 2018. 3. 13..
 */

public class MAdapter extends BaseAdapter {
    String[] titles;
    int[] images;

    //이 것은 생성자이며 Activity에서 데이터를 넣어주는 통로역할을 한다.
    public MAdapter(String[] titles,int[] images){
        this.titles = titles;
        this.images = images;
    }

    //몇 개의 data가 들어갈지 넣어준다.
    @Override
    public int getCount() {
        return titles.length;
    }
    //안쓰임
    @Override
    public Object getItem(int position) {
        return null;
    }
    //그냥 각 리스트의 index를 가져올 때 사용됨.
    @Override
    public long getItemId(int position) {
        return position;
    }
    //데이터의 갯수 만큼 불려진다. 즉 이 getView를 통해 listview의 아이템들이 보여진다.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_listview,null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        textView.setText(titles[position]);
        imageView.setImageResource(images[position]);

        return convertView;
    }
}
