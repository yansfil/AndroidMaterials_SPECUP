package com.example.hoyeonlee.helloworld;

/**
 * Created by hoyeonlee on 2018. 1. 25..
 */

public class Day4Class {
    public static void main(String[] args){
        Calculator calculator = new Calculator(5,10);
        System.out.println(calculator.add());
//        System.out.println(calculator.multiply());
        Calculator calculator2 = new Calculator(30,50);
        System.out.println(calculator2.add());
        System.out.println(calculator.add());

    }
}
