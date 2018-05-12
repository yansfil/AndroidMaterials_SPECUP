package com.example.hoyeonlee.day7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button closeButton;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent(); //MainActivity에서 선언한 intent 불러오기
        String value = intent.getStringExtra("key"); //Hello Specup!이 담긴다
        int intValue = intent.getIntExtra("key2",1000); //10이 담긴다
        closeButton = (Button) findViewById(R.id.btn_close);
        textView = (TextView) findViewById(R.id.tv);
        textView.setText(value); //value 변수의 값을 textView에 띄운다.
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면닫기 기능
                finish();
            }
        });
    }
}
