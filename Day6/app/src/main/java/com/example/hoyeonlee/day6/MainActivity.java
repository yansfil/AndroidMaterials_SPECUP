package com.example.hoyeonlee.day6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btn);
        final TextView textView = (TextView) findViewById(R.id.tv);
        ImageView a = new ImageButton(this);
        a.setBackgroundResource(R.mipmap.ic_launcher);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = textView.getText().toString();
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
            }
        });
        Thread

    }
}
