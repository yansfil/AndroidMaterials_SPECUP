package com.example.hoyeonlee.day16_customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = findViewById(R.id.listView);
        //Data를 만들어주는 작업
        Item item1 = new Item("호연1","25");
        Item item2 = new Item("호연2","26");
        Item item3 = new Item("호연3","27");
        Item item4 = new Item("호연4","28");
        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        //Adapter 만들어주는 작업
        ListViewAdapter adapter = new ListViewAdapter(items);
        //listview에 Adapter 적용
        listView.setAdapter(adapter);





    }
}
