package com.example.a2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String PERMISSION = "edu.uic.cs478.s19.kaboom";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = findViewById(R.id.permission_btn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, PERMISSION) == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
                    String data = "webdata";
                    BroadcastReceiver a2 = new a2receiver();
                    IntentFilter filter = new IntentFilter(data);
                    filter.setPriority(10);
                    registerReceiver(a2, filter);
                    Intent i = new Intent();
                    i.setComponent(new ComponentName("com.example.a3","com.example.a3.MainActivity"));
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
            String data = "webdata";
            BroadcastReceiver a2 = new a2receiver();
            IntentFilter filter = new IntentFilter(data);
            filter.setPriority(10);
            registerReceiver(a2, filter);
            Intent i = new Intent();
            i.setComponent(new ComponentName("com.example.a3","com.example.a3.MainActivity"));
            startActivity(i);
        }
        else
        {
            Toast.makeText(MainActivity.this,"Permission not granted", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
