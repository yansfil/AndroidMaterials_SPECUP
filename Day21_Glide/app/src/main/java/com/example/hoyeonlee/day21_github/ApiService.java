package com.example.hoyeonlee.day21_github;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hoyeonlee on 2018. 4. 17..
 */

public interface ApiService {
    public static final String URL = "https://tomorrances.azurewebsites.net/client/";
//    public static final String URL = "http://api.openweathermap.org/data/2.5/";


    //https://tomorrances.azurewebsites.net/client/helloTaling  요청을 한다.
    @GET("helloTaling")
    Call<ResponseBody> helloTaling();

    //https://tomorrances.azurewebsites.net/client/getMusics 요청을 한다
    @GET("getMusics")
    Call<ResponseBody> getMusics();

    @GET("weather")
    Call<ResponseBody> getWeather(@Query("q") String q,@Query("APPID") String appId);
}

//{"coord":{"lon":126.98,"lat":37.57},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"base":"stations","main":{"temp":287,"pressure":1018,"humidity":28,"temp_min":284.15,"temp_max":291.15},"visibility":10000,"wind":{"speed":2.1,"deg":270},"clouds":{"all":0},"dt":1523959200,"sys":{"type":1,"id":7676,"message":0.0521,"country":"KR","sunrise":1523912076,"sunset":1523959756},"id":1835848,"name":"Seoul","cod":200}