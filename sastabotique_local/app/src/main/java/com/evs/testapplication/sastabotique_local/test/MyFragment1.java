package com.evs.testapplication.sastabotique_local.test;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.evs.testapplication.sastabotique_local.R;

/**
 * Created by AQIB JAVED on 11/18/2017.
 */

public class MyFragment1 extends Fragment {
    private Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.frag1,container,false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
        button =(Button)view.findViewById(R.id.ok);
    }

}
