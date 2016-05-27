package com.bridge.gcmapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by sec on 2016-05-25.
 */
public class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getAction();

        if(name.equals("arabiannight.tistory.com.sendreciver.gogogo")){
            Toast.makeText
                    (context, "정상적으로 값을 받았습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
