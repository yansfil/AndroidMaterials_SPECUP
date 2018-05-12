package com.example.hoyeonlee.day9;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentsActivity extends AppCompatActivity {

    TextView nameTextView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);
        nameTextView = (TextView) findViewById(R.id.tv_name);
        imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        String value = intent.getStringExtra("name"); //apple버튼을 클릭했으면 apple...

        if(value.equals("apple")){ //String은 equals메소드를 써야 값비교가 가능하다.
            //apple일때 적용되는 코드
            nameTextView.setText("Apple");
            imageView.setImageResource(R.drawable.apple);
        }else{
            //banana일때 적용되는 코드
            nameTextView.setText("Banana");
            imageView.setImageResource(R.drawable.banana);
        }
    }
}
