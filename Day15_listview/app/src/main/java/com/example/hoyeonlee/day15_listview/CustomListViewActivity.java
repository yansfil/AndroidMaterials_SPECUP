
package com.example.hoyeonlee.day15_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        listView = (ListView) findViewById(R.id.listview_custom);

        //데이터 셋 만들어주기
        ArrayList<Data_Music> datas = new ArrayList<>();
        Data_Music music1 = new Data_Music("우주론","빅뱅",R.drawable.bigbang);
        Data_Music music2 = new Data_Music("스몰파더","빅마마",R.drawable.bigmama);
        Data_Music music3 = new Data_Music("없음","여자친구",R.drawable.girlfrient);
        Data_Music music4 = new Data_Music("사랑을 했다","아이콘",R.drawable.ikon);
        Data_Music music5 = new Data_Music("스물다섯 스물하나","자우림",R.drawable.jaurim);
        Data_Music music6 = new Data_Music("그대를 만나","이선희",R.drawable.seonhee);
        Data_Music music7 = new Data_Music("가시나","선미",R.drawable.seonmi);
        datas.add(music1);
        datas.add(music2);
        datas.add(music3);
        datas.add(music4);
        datas.add(music5);
        datas.add(music6);
        datas.add(music7);
        //Adapter 선언 후에 데이터 넣기
        CustomAdapter customAdapter = new CustomAdapter(datas);
        listView.setAdapter(customAdapter);
    }
}
