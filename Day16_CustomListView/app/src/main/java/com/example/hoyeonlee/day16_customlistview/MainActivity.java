package com.example.hoyeonlee.day16_customlistview;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button toastButton;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toastButton = findViewById(R.id.btn_toast);
        nextButton = findViewById(R.id.btn_next);
        //Array로 크기가 4인 배열 만들기
        final String[] fruits = new String[4];
        fruits[0] = "melon";
        fruits[1] = "strawberry";
        fruits[2] = "korean melon";
        fruits[3] = "orange";
        //ArrayList 만들기
        final ArrayList<String> names = new ArrayList<>();
        names.add("호연");
        names.add("재학");
        names.add("동준");
        names.remove(2); //동준 String 형이 지워진다.
        names.remove("재학");
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.format("names의 크기는 %d입니다",names.size()), Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, Arrays.toString(fruits), Toast.LENGTH_SHORT).show();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListviewActivity.class);
                startActivity(intent);
            }
        });
    }
}
