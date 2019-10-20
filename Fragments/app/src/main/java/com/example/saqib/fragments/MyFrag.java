package com.example.saqib.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by SaQib on 5/6/2017.
 */
public class MyFrag extends Fragment{
    private TextView tview;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.myfrag,container,false);
        initComponents();
        return view;
    }

    private void initComponents() {
        tview=(TextView)view.findViewById(R.id.textView);

    }
}
