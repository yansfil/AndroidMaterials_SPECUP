package com.example.hoyeonlee.helloworld;

import java.util.Scanner;

/**
 * Created by hoyeonlee on 2018. 1. 23..
 */

public class Day3Class {
    public static void main(String[] args){
        boolean a = true;
        boolean b = !a; //false
        boolean c = a && !b; //true

//        if(!(a || b) || true){
//            System.out.println("오늘은 화요일ㅠ");
//        }
//        System.out.println("너무 행복하다");

//        if(!c){
//            System.out.println("선택된 값은 "+ c +"입니다");
//        }else{ //else부분 실행
//            System.out.println("선택된 값은 "+ !c +"입니다");
//        }

//        int value = 0;
//        if(b){ //false
//            value++;
//        }else if(a){ //true
//            value--;
//        }
//        System.out.println("value값은 "+value);
//        int val = 10;
//        if(val >= 10){
//            //실행됨
//        }else if(val < 10){
//            //실행안됨
//        }

//        if(b){ //false
//            //코드1
//        }else if(!a){ //fase
//            //코드2
//        }else{
//            //코드3
//        }
        //코드3이 출력

//        int value = 50;
//        if(value > 10){
//            if(20 < value && value < 100){
//                System.out.println("value는 "+value);
//            }
//        }

//        Scanner scanner = new Scanner(System.in);
//        int val1 = scanner.nextInt(); //첫번째 입력값
//        int val2 = scanner.nextInt(); //두번째 입력값
//
//        if(val1 > 0){
//            if(0<=val2 && val2 <=20){
//                System.out.println("0~20 사이입니다");
//            }else if(val2 > 20){
//                System.out.println("20 초과입니다");
//            }
//        }else{
//            System.out.println("false");
//        }

        /* 반복문 while */
//        int i = 0;
//        while (i<30){ //30번 출력
//            System.out.println("Fighting!");
//            i++;
//        }
//        int j = 0;
//        while(true){
//            System.out.println("Hello! "+j);
//            j++;
//            if(j > 10){
//                break;
//            }
//        }
        /*continue문*/
//        int k = 0;
//        while(k<10){
//            System.out.println("Hello!");
//            k++;
//            if(k > 5){
//                continue;
//            }
//            System.out.println("Bye");
//        }
        /*for문 */
//        for(int i = 0;i<30;i++){
//            System.out.println((i+1)+"번째 실행중");
//        }
        /*이중 for문*/
//        for(int i = 0;i < 3;i++){
//            for(int j = 0;j<3;j++){
//                System.out.println(i+" 와 "+j);
//            }
//        }
    }
}
