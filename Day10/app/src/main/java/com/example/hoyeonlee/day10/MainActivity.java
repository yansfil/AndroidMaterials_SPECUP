package com.example.hoyeonlee.day10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hoyeonlee.day10.Test.DefaultClass;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_send);
        nextButton = (Button) findViewById(R.id.btn_next);

//        TestClass testClass = new TestClass();
//        testClass.value1 = "20"; //public은 어디서든 접근이 가능하다.
//        DefaultClass defaultClass = new DefaultClass();
//        defaultClass.publicValue = "30"; //public 접근가능,default 불가능

//        TextView tv = (TextView) findViewById(R.id.textview);
//        int a = 10;
//        String b = String.valueOf(a); //b는 String 10이 된다.
//        int c = Integer.parseInt(b); //c에도 10이 들어가는데, 이때 int형
//        tv.setText(b);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //암시적 Intent
                Intent intent = new Intent("com.tistory.tansfil.hoyeon");
                intent.setPackage("com.example.hoyeonlee.day10");
                intent.putExtra("name","Hoyeon");
                sendBroadcast(intent);

                //Uri로 웹사이트 접근하기
//                Uri uri = Uri.parse("http://www.naver.com");
//                Intent intent = new Intent(Intent.ACTION_VIEW,uri); //암시적 인텐트
//                startActivity(intent);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ThreadActivity.class);
                startActivity(intent);
            }
        });

    }
}









