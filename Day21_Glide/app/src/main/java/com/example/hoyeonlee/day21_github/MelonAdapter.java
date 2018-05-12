package com.example.hoyeonlee.day21_github;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hoyeonlee on 2018. 4. 19..
 */

public class MelonAdapter extends BaseAdapter {

    Context context;
    JSONArray data;
    MelonAdapter(Context context, JSONArray data){
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length();
    }

    @Override
    public Object getItem(int position) {
        try {
            return data.get(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Glide.with(context)
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.melon_item,parent,false);
        }
        ImageView albumView = convertView.findViewById(R.id.iv_album);
        TextView titleView = convertView.findViewById(R.id.tv_title);
        TextView artistView = convertView.findViewById(R.id.tv_artist);

        try {
            JSONObject item = data.getJSONObject(position);
            Glide.with(context).load(item.getString("image")).into(albumView);
            titleView.setText(item.getString("title"));
            artistView.setText(item.getString("artist"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return convertView;
    }
}
