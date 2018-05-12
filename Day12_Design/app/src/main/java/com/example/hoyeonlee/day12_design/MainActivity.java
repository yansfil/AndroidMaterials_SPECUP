package com.example.hoyeonlee.day12_design;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] names = new String[3]; //크기만 정해주고 나중에 값 넣기
        int[] numbers = {1,2,3,4}; //미리 정의기
        names[0] = "호연";
        names[1] = "재학";
        names[2] = "동준";
//      names[3] = "1"; 여기부터는 크기 초과로 Error가 난다.

        ArrayList<String> lists = new ArrayList<>(); //String을 담는 ArrayList이라고 선언해준다.
        lists.add("1");
        lists.add("2");
        lists.add("3"); //add메소드로 값을 넣을 수 있다. 크기가 제한되지 않음.
        //lists.add(4); String이 아닌 다른 자료형는 넣을 수 없다.

        lists.get(0); //1번째 값인 "1"이 반환된다.
        lists.get(2); //3번째 값인 "3"이 반환된다.

        ArrayList<Home> homes = new ArrayList<>();
        Home home1 = new Home("영미","철수");
        Home home2 = new Home("영자","철순");
        homes.add(home1); //1번째 index에 home1을 넣는다
        homes.add(home2); //2번째 index에 home1을 넣는다

        String name = homes.get(0).mom; //1번째 index에 들어간 home1의 mom인 "영미"가 반환됨

    }
}
