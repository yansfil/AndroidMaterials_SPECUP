package com.example.hoyeonlee.day11;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    Thread thread;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_thread);
        textView = (TextView) findViewById(R.id.tv_number);
        thread = new Thread(){
            int number = 0;
            @Override
            public void run() {
                super.run();
                //Thread작업할 것 치면 됨
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    number++;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(number+"");
                        }
                    });
                }
            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread.start();
            }
        });
    }


}








