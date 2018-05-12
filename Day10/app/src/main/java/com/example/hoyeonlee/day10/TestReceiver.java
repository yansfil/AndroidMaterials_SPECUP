package com.example.hoyeonlee.day10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by hoyeonlee on 2018. 2. 22..
 */

public class TestReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        //신호를 받았을때 작성한 코드가 실행이 된다.
//        intent.getStringExtra("name")
        Toast.makeText(context, "버튼 클릭!", Toast.LENGTH_SHORT).show();
    }
}
