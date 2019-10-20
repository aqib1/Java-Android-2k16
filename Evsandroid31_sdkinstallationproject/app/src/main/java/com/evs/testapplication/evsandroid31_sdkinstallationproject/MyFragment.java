package com.evs.testapplication.evsandroid31_sdkinstallationproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by AQIB JAVED on 10/13/2018.
 */

public class MyFragment extends Fragment {
    private Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_myfrag1,container,false);
        initComponents(v);
        return v;
    }

    private void initComponents(View v) {
     btn = v.findViewById(R.id.b1);
    }
}
