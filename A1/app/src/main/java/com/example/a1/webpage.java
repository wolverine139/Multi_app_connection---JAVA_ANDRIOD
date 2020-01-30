package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class webpage extends AppCompatActivity {

    private String web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webpage);

        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null)
        {
            web = mBundle.getString("web1");
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setPackage("com.android.chrome");
            try
            {
                startActivity(i);
            }
            catch(ActivityNotFoundException e)
            {
                i.setPackage(null);
                startActivity(i);
            }
        }
    }
}
