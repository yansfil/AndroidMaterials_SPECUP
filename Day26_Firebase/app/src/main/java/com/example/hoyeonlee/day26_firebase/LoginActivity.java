package com.example.hoyeonlee.day26_firebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button joinButton;
    Button loginButton;
    EditText emailInput;
    EditText passwordInput;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        joinButton = findViewById(R.id.btn_join);
        loginButton = findViewById(R.id.btn_login);
        emailInput = findViewById(R.id.input_email);
        passwordInput = findViewById(R.id.input_password);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("잠시만 기다려주세요");
        firebaseAuth = FirebaseAuth.getInstance();

        //로그인을 했으면 바로 MainActivity로 넘어간다
        if (firebaseAuth.getCurrentUser() != null) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                join();
            }
        });
    }

    //회원가입 메소드
    void join(){
        progressDialog.show();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        //email password 유효성검사
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        //회원가입 코드
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //성공
                    Toast.makeText(LoginActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                }else{
                    //실패
                    Toast.makeText(LoginActivity.this, "회원가입 실패", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                }
            }
        });

    }
    //로그인 메소드
    void login(){
        progressDialog.show();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        //email password 유효성검사
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //성공
                    Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                    progressDialog.hide();
                }else{
                    //실패
                    Toast.makeText(LoginActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                    progressDialog.hide();
                }
            }
        });
    }



}
