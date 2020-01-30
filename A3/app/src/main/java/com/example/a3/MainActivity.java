package com.example.a3;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements OnClickListner{
    private String data = "webdata";
    private int index;
    private String[] webpage = {"https://www.apple.com/iphone-11-pro/", "https://www.apple.com/iphone-11/",
            "https://www.apple.com/shop/buy-iphone/iphone-xr", "https://www.samsung.com/global/galaxy/galaxy-fold/",
            "https://www.samsung.com/us/mobile/galaxy-note10/"};

    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar action_bar = (Toolbar) findViewById(R.id.actionbar);
        action_bar.setNavigationIcon(R.mipmap.ic_launcher);
        setSupportActionBar(action_bar);
        manager = getSupportFragmentManager();
        addmobilelist();
    }

    private void addmobilelist()
    {
        transaction = manager.beginTransaction();
        moblielistFrag mlf = new moblielistFrag();
        mlf.setCallbackListner(this);
        transaction.add(R.id.frame_name, mlf);
        transaction.commit();
    }

    private void imagefragment(int index){
        transaction = manager.beginTransaction();
        imagefrag imgf = new imagefrag();
        Bundle b1 = new Bundle();
        b1.putInt("index", index);
        imgf.setArguments(b1);
        transaction.replace(R.id.frame_name, imgf);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.A1A2:
                Intent i = new Intent(data);
                i.putExtra("web", webpage[index]);
                sendBroadcast(i);

                break;
            case R.id.Exit:
                finish();
                break;
            default:

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemSelect(int currindex) {
        index = currindex;
        imagefragment(currindex);
    }

}
