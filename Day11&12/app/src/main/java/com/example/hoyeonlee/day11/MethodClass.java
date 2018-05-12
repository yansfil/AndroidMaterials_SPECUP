package com.example.hoyeonlee.day11;

/**
 * Created by hoyeonlee on 2018. 3. 6..
 */

public class MethodClass {
    public static void main(String[] args){
        //main메소드 실행이됩니다]
        study(); //수업을 합니다가 출력을 한다.
        String name = eat(); //밥이 좋아요가 출력되고 "밥을 먹습니다"가 return된다.
    }

    static void study(){
        System.out.println("수업을 합니다");
    }

    static String eat(){
        System.out.println("밥이 좋아요");
        return "밥을 먹습니다";
    }
}
