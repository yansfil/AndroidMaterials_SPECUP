package com.example.hoyeonlee.day11;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    Button plusButton;
    Button minusButton;
    Button multiplyButton;
    Button nextButton;
    int result = 0;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        input1 = (EditText)findViewById(R.id.input_first);
        input2 = (EditText)findViewById(R.id.input_second);
        resultText = (TextView) findViewById(R.id.tv_result);
        plusButton = (Button) findViewById(R.id.btn_plus);
        minusButton = (Button) findViewById(R.id.btn_minus);
        multiplyButton = (Button) findViewById(R.id.btn_multiply);
        nextButton = (Button) findViewById(R.id.btn_next);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //비밀번호 8자리 이상 맞는지 확인하는 방법
//                if(input1.getText().toString().length() >= 8){
//
//                }else{
//                    Toast.makeText(Main2Activity.this, "비밀번호 8자이상 입력해주세요", Toast.LENGTH_SHORT).show();
//                }

                if(!input1.getText().toString().equals("") && !input2.getText().toString().equals("")){
                    //플러스버튼을 눌렀을 때 작동하는 코드
                    int num1 = Integer.valueOf(input1.getText().toString());//Editable->String->int으로 바꾼다.
                    int num2 = Integer.valueOf(input2.getText().toString());//Editable->String->int으로 바꾼다.
                    int result = num1 + num2;
                    resultText.setText(result + "");
                }else{
                    Toast.makeText(Main2Activity.this, "숫자를 입력해주세요!!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input1.getText().toString().equals("") && !input2.getText().toString().equals("")){
                    int num1 = Integer.valueOf(input1.getText().toString());//Editable->String->int으로 바꾼다.
                    int num2 = Integer.valueOf(input2.getText().toString());//Editable->String->int으로 바꾼다.
                    int result = num1 - num2;
                    resultText.setText(result+"");
                }else{
                    Toast.makeText(Main2Activity.this, "숫자를 입력해주세요!!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(!input1.getText().toString().equals("") && !input2.getText().toString().equals("")){
                        int num1 = Integer.valueOf(input1.getText().toString());//Editable->String->int으로 바꾼다.
                        int num2 = Integer.valueOf(input2.getText().toString());//Editable->String->int으로 바꾼다.
                        int result = num1 * num2;
                        resultText.setText(result+"");
                    }else{
                        Toast.makeText(Main2Activity.this, "숫자를 입력해주세요!!!!", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                String result = resultText.getText().toString();
                intent.putExtra("value",result);
                startActivity(intent);
            }
        });
    }
}
