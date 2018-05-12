package com.example.hoyeonlee.day16_customlistview;

/**
 * Created by hoyeonlee on 2018. 3. 20..
 */

public class Item {
    public String name;
    public String age;
    public Item(String name, String age){
        this.name = name;
        this.age = age;
        run();
    }
    void run(){
        System.out.println("RUNN");
        walk();
    }
    void walk(){
        System.out.println("WALK");
    }

}
