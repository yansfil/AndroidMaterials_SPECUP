package com.example.hoyeonlee.day7;

/**
 * Created by hoyeonlee on 2018. 2. 6..
 */

public class Calculator_genius extends Calculator_fool{


    //Overriding
    void add(){
        super.add(); //super는 Calculator_fool(상속해주는 class)
        System.out.println("합은 "+(a+b)+"입니당");
    }
//    void substract(){
//        System.out.println("차는 "+(a-b));
//    }
    void multiply(){
        System.out.println("곱은 "+(a*b));
    }

}
