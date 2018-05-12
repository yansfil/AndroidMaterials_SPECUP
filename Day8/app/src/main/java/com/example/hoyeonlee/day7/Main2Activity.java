package com.example.hoyeonlee.day7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button button;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) findViewById(R.id.btn_back);
        textView = (TextView) findViewById(R.id.tv_get);
        imageView = (ImageView) findViewById(R.id.imageView);


        Intent intent = getIntent();
        String value1 = intent.getStringExtra("name1"); //Hello Specup!
        String value2 = intent.getStringExtra("name2"); //Happy Birthday!

        textView.setText(value2);
        imageView.setImageResource(R.drawable.apple);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }
}





















