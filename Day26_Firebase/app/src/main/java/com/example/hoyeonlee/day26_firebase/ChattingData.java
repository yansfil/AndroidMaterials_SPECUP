package com.example.hoyeonlee.day26_firebase;

/**
 * Created by hoyeonlee on 2018. 5. 10..
 */

public class ChattingData {

    String email;
    String message;
    ChattingData(){
        
    }
    ChattingData(String email,String message){
        this.email = email;
        this.message = message;
    }
}
