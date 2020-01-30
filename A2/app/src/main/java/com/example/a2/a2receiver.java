package com.example.a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class a2receiver extends BroadcastReceiver {

    private String web = "";
    @Override
    public void onReceive(Context context, Intent intent) {
       web = intent.getStringExtra("web");
       if(web != null)
        Toast.makeText(context, web, Toast.LENGTH_SHORT).show();
    }
}
