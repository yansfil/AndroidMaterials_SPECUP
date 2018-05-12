package com.example.hoyeonlee.day21_github;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Main2Activity extends AppCompatActivity {
    Button logoutButton;
    Button httpButton;
    Button melonButton;
    TextView idText;
    TextView nametext;
    TextView tempText;
    TextView humidityText;
    ImageView glideImageView; //Glide 라이브러리를 사용할 ImageView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        logoutButton = findViewById(R.id.btn_logout);
        melonButton = findViewById(R.id.btn_melon);
        httpButton = findViewById(R.id.btn_http);
        idText = findViewById(R.id.tv_id);
        nametext = findViewById(R.id.tv_name);
        tempText = findViewById(R.id.tv_temp);
        humidityText = findViewById(R.id.tv_humidity);
        glideImageView = findViewById(R.id.iv_glide);

        //Retrofit 객체 생성 및 ApiService 만들기
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiService.URL).build();
        final ApiService apiService = retrofit.create(ApiService.class);

        SharedPreferences preferences = getSharedPreferences("info", Activity.MODE_PRIVATE);

        //SharedPreference의 값을 TextView에 씌워준다.
        idText.setText(preferences.getString("id",""));
        nametext.setText(preferences.getString("name",""));
        //Glide사용
        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTU1Au6nldt2zjNbc6pN_TwrMTd1q60-MAM_yZLZVTg7x8_HWYwOQ").into(glideImageView);

        //EVENT LISTENER 정리
        melonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MelonActivity.class);
                startActivity(intent);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login값을 바꾼다.
                SharedPreferences preferences = getSharedPreferences("info", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor =  preferences.edit();//Editor로 login 값을 수정한다.
                editor.putBoolean("login",false);
                editor.commit();
                //Login페이지로 넘어간다.
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //클릭시 HTTP 통신 시작
        httpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getMusics HTTP 통신

                Call<ResponseBody> getMusics = apiService.getMusics();
                getMusics.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            //받은 String을 JSONArray로 형변환해준다.
                            JSONArray array = new JSONArray(response.body().string());
                            //Array의 3번째 Object의 title 값을 가져온다.
                            String title = array.getJSONObject(2).getString("title");
                            Toast.makeText(Main2Activity.this, title, Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(Main2Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                //쿼리가 2개인 Request로 http://api.openweathermap.org/data/2.5/weather?q=Seoul&APPID=5670abf89638ec6659b4ced50fc29780

//                Call<ResponseBody> getWeather = apiService.getWeather("SEOUL","5670abf89638ec6659b4ced50fc29780");
//                getWeather.enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        try {
//                            //string을 JSONObject로 바꿔줘서 값 탐색을 쉽게 해준다.
//                            JSONObject jsonObject = new JSONObject(response.body().string());
//                            tempText.setText("오늘의 온도 : "+jsonObject.getJSONObject("main").getString("temp")); //전체 json에서 main이라는 jsonObject로 이동후 temp라는 값을 받는다
//                            humidityText.setText("오늘의 습도 : "+jsonObject.getJSONObject("main").getString("humidity")); //전체 json에서 main이라는 jsonObject로 이동후 humidity라는 값을 받는다
////                            Toast.makeText(Main2Activity.this, response.body().string(), Toast.LENGTH_SHORT).show();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        } catch (JSONException e){
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Toast.makeText(Main2Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });

                //기본 HelloTaling HTTP 통신

//                Call<ResponseBody> helloTaling = apiService.helloTaling();
//                helloTaling.enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        //통신에 성공했을 때 작동하는 코드
//                        //response.body.string()은 서버에서 보내는 핵심 데이터만 가져온다.
//                        try {
//                            Toast.makeText(Main2Activity.this, response.body().string(), Toast.LENGTH_SHORT).show();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        //통신에 실패했을 때 작동하는 코드
//                        Toast.makeText(Main2Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
        });
    }
}
















