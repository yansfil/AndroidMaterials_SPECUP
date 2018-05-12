package com.example.hoyeonlee.forspecuppresentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);

        //데이터를 만든다
        int[] images = {R.drawable.apple,R.drawable.banana,
                R.drawable.orange,R.drawable.watermelon};
        String[] titles = {"사과","바나나","오렌지","수박"};

        //데이터가 담길 Adapter를 만든다.
        MAdapter adapter = new MAdapter(titles,images);
        listView.setAdapter(adapter);

    }
}
