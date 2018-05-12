package com.example.hoyeonlee.day21_github;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText idInput;
    EditText nameInput;
    Button loginButton;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idInput = findViewById(R.id.input_id);
        nameInput = findViewById(R.id.input_name);
        loginButton = findViewById(R.id.btn_login);

        /*SharedPreference이용해서 로그인 여부 저장*/

        //info라는 이름의 SharedPreference Database를 하나 만듬!!
        preferences = getSharedPreferences("info", Activity.MODE_PRIVATE);
        //로그인을 했었다면 바로 MainPage로 이동시킨다.
        if(preferences.getBoolean("login",false)){
            Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);
            finish();
        }


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Login 했을 때 Sharedpreference에 login값 true로 저장
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("login",true);
                editor.putString("id",idInput.getText().toString());
                editor.putString("name",nameInput.getText().toString());
                //ID랑 Name을 넣어줘야됩니다.

                editor.commit();
                //다음페이지로
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
                //로그인 후 로그인창을 꺼준다
                finish();
            }
        });
    }
}
