package com.example.a3;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class imagefrag extends Fragment {

    int[] image = {R.drawable.iphone11pro, R.drawable.iphone11, R.drawable.iphonexr, R.drawable.galaxyfold, R.drawable.galaxynote10};
    View view;
    ImageView img;
    int index;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.imagefragment, container, false);
       helper();
       return view;
    }

    public void helper()
    {
        img = view.findViewById(R.id.image_activity2);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
            Bundle b1 = getArguments();
            index = b1.getInt("index");
    }

    @Override
    public void onResume() {
        super.onResume();
        img.setImageResource(image[index]);
    }
}
