package com.example.hoyeonlee.day9;

/**
 * Created by hoyeonlee on 2018. 2. 20..
 */

public class TestClass {
    public static void main(String[] args){
        Calculator a = new Calculator(); //객체 a 선언
        Calculator b = new Calculator(); //객체 b 선언
        a.pi = 10; //b.pi는 10으로 변경
//        Calculator.pi접근이 가능함.
        System.out.println(b.pi);
//        System.out.println(a.getCircumstance(10)); //반지름 10인 원의 둘레를 구한다.
    }
}
