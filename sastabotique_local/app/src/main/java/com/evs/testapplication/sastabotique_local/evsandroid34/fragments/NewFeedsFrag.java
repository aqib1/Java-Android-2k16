package com.evs.testapplication.sastabotique_local.evsandroid34.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.evs.testapplication.sastabotique_local.R;

/**
 * Created by AQIB JAVED on 12/22/2018.
 */

public class NewFeedsFrag extends Fragment {
    private Button newfeeds;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_feed_activity_layout,container,false);
        initComponents(view);
        return view;
    }

    private void initComponents(View view) {
        newfeeds = view.findViewById(R.id.newFeedLoadBtn);
        
    }
}
