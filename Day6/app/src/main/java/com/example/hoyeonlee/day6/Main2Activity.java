package com.example.hoyeonlee.day6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText idInput = (EditText) findViewById(R.id.input_id);
        final EditText pwInput = (EditText) findViewById(R.id.input_pw);
        Button loginButton =  (Button) findViewById(R.id.btn_login);
        Button joinButton =  (Button) findViewById(R.id.btn_join);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, idInput.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, pwInput.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("Hello","world");
        startActivity(intent);
    }
}
