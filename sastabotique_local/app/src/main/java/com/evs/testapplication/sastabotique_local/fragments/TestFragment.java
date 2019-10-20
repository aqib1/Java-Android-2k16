package com.evs.testapplication.sastabotique_local.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.evs.testapplication.sastabotique_local.R;

/**
 * Created by AQIB JAVED on 11/18/2018.
 */

public class TestFragment extends Fragment {
    private Button btn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.frag1,container,false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
     btn = view.findViewById(R.id.ok);
    }
}
