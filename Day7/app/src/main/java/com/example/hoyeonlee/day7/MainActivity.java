package com.example.hoyeonlee.day7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String a = "Hello World!"; //전역변수
    String b;
    Button button; //버튼을 전역화시킨다.
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//AppCompatActivity의 onCreate() 사용
        setContentView(R.layout.activity_main);

        //정의부
        b = "Hello Specup!"; //전역변수 값 변경
        button = (Button) findViewById(R.id.button);
        nextButton = (Button) findViewById(R.id.btn_next); //nextButton 정의
//        final Intent intent = new Intent(this,Main2Activity.class);
        sayHello();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면전환되는 코드
                //MainActivity에서 Main2Activity로 넘어가는 명령이 명시적 intent에 담겨져있다.
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("key",b);
                intent.putExtra("key2",10);
                startActivity(intent);
            }
        });
    }

    void sayHello(){
//        a = "Hello Hoyeon!"; //a의 값을 바꾸겠다.
//        String a = "Hello Hello!"; //지역변수 a 선언
//        Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
        //우선순위는 지역변수가 우선됩니다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "클릭했니?", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
