package com.example.hoyeonlee.day9;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bananaButton;
    Button appleButton;
    Button startServiceButton;
    Button stopServiceButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button 정의
        bananaButton = (Button) findViewById(R.id.btn_banana);
        appleButton = (Button) findViewById(R.id.btn_apple);
        startServiceButton = (Button) findViewById(R.id.btn_service_start);
        stopServiceButton = (Button) findViewById(R.id.btn_service_stop);

        bananaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //banana버튼 클릭했을 때 동작
                Intent intent = new Intent(getApplicationContext(),ContentsActivity.class);
                intent.putExtra("name","banana");
                startActivity(intent);
            }
        });
        appleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //apple버튼 클릭했을 때 동작
                Intent intent = new Intent(getApplicationContext(),ContentsActivity.class);
                intent.putExtra("name","apple");
                startActivity(intent);
            }
        });

        TestService service = new TestService();
        final Intent intent = new Intent(getApplicationContext(),TestService.class);
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });
        stopServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });
    }
}
