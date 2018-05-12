package com.example.hoyeonlee.helloworld;

import static android.R.attr.x;
import static android.R.attr.y;

/**
 * Created by hoyeonlee on 2018. 1. 25..
 */

public class Calculator {
    //변수 선언
//    public Calculator(){
//        System.out.println("created");
//    }
    static int a; //선언
    int b; //선언
    //빈 생성자
//    public Calculator(){
//
//    }
    //매개변수가 2개 있는 생성자
    public Calculator(int a, int b){
        this.a = a;
        this.b = b;
    }
    //메소드선언
    int add(){
        return a+b;
    }
    int multiply(){
        return a*b;
    }
    int divide(){
        return a/b;
    }

}
