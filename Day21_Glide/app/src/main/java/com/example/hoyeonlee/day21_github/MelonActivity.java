package com.example.hoyeonlee.day21_github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MelonActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_melon);
        listView = findViewById(R.id.listview);

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        //Retrofit 객체 생성 및 ApiService 만들기
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiService.URL).build();
        final ApiService apiService = retrofit.create(ApiService.class);

        //Network 통신 -> Adapter이용해서 ListView만들기
        Call<ResponseBody> getMusics = apiService.getMusics();
        getMusics.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    //받은 String을 JSONArray로 형변환해준다.
                    JSONArray array = new JSONArray(response.body().string());
                    //Array의 3번째 Object의 title 값을 가져온다.
                    MelonAdapter adapter = new MelonAdapter(MelonActivity.this,array);
                    listView.setAdapter(adapter);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MelonActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        //listView.setAdapter(adapter)

    }
}
