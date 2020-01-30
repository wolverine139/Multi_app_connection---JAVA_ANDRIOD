package com.example.a1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    private String web;
    @Override
    public void onReceive(Context context, Intent intent) {
        web = intent.getStringExtra("web");
        if(web != "") {
            Intent i = new Intent(context, webpage.class);
            i.putExtra("web1", web);
            context.startActivity(i);
        }
    }
}
