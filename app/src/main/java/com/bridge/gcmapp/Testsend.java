package com.bridge.gcmapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by sec on 2016-05-25.
 */
public class Testsend extends Activity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);

        Button btn = (Button) findViewById(R.id.btn_send);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sendBroadcast(new Intent("gogogo"));
    }
}
