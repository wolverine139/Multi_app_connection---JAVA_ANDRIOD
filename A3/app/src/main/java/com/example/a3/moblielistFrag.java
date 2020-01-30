package com.example.a3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class moblielistFrag  extends Fragment {
    private String[] devicename = {"iPhone 11 Pro", "iPhone 11", "iPhone XR",
            "Samsung Galaxy Fold", "Samsung Galaxy Note10"};
    View view;
    ListView lv;
    Context context;
    ArrayAdapter<String> devicenameAdapter;
    OnClickListner lis;

    public void setCallbackListner(OnClickListner lis)
    {
        this.lis = lis;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.moblielist_frag,container,false);
        helper();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void helper(){
        context = getContext();
        lv = view.findViewById(R.id.list_name);
        devicenameAdapter = new ArrayAdapter<String>(context, R.layout.list_tv, devicename);
        lv.setAdapter(devicenameAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(lis != null)
                {
                    lis.onItemSelect(i);
                }
            }
        });

    }
}
