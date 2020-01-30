package com.example.a1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.mtp.MtpConstants;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String PERMISSION = "edu.uic.cs478.s19.kaboom";
        Button permission_checker;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permission_checker =  findViewById(R.id.permission_btn);

        permission_checker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, PERMISSION) == PackageManager.PERMISSION_GRANTED)
                {
                    registerBroadcast();
                    Toast.makeText(MainActivity.this, "You have already permission Granted", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent();
                    i.setComponent(new ComponentName("com.example.a2","com.example.a2.MainActivity"));
                    startActivity(i);
                }
                else
                {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {PERMISSION}, 0);
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            registerBroadcast();
            Intent i = new Intent();
            i.setComponent(new ComponentName("com.example.a2","com.example.a2.MainActivity"));
            startActivity(i);
        }
        else
        {
            //Permission not granted
        }
    }

    private void registerBroadcast(){
        BroadcastReceiver a = new MyReceiver();
        IntentFilter a1Filter = new IntentFilter("webdata");
        a1Filter.setPriority(10);
        registerReceiver(a, a1Filter);
    }
}
