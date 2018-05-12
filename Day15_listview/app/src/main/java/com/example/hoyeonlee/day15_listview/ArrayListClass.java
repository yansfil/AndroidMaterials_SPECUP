package com.example.hoyeonlee.day15_listview;

import java.util.ArrayList;

/**
 * Created by hoyeonlee on 2018. 3. 15..
 */

public class ArrayListClass {
    public static void main(String[] args){
        String[] specupAd = {"specup","weport","cashwork"}; //크기가 3인 배열을 정해줬다.
        String[] names = new String[10]; //크기가 10인 빈 배열을 만들어줬다
        int[] numbers = {1,2,3,4}; //크기가 4인 int형 배열이 만들어졌다

        for(int i = 0; i<specupAd.length;i++){ //3번 반복되서 값에 접근한다.
            System.out.println(specupAd[i]);
        }
        for(int i = 0; i < names.length; i++){
            names[i] = "회원"+i;
        }
        //클래스에 대한 배열 만들기
        Person[] people = new Person[3];
        Person hoyeon = new Person();
        hoyeon.name = "hoyeon";
        Person hoyeon2 = new Person();
        hoyeon.name = "hoyeon2";
        Person hoyeon3 = new Person();
        hoyeon.name = "hoyeon3";
        people[0] = hoyeon;
        people[1] = hoyeon2;
        people[2] = hoyeon3;

        //ArrayList 만들기
        ArrayList<String> shoes = new ArrayList<>();
        shoes.add("nike");
        shoes.add("adidas");
        shoes.add("asics");
        System.out.println(shoes.get(0)); //nike출력
        System.out.println(shoes.get(1)); //adidas출력
    }
}
