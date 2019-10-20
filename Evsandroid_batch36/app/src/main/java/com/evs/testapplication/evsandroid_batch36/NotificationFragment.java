package com.evs.testapplication.evsandroid_batch36;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by AQIB JAVED on 12/29/2018.
 */

public class NotificationFragment extends Fragment {
    private Button ok_btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.notificationfragment_layout,container,false);
        initComponents(v);
        settingUpListeners();
        return v;
    }

    private void settingUpListeners() {
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    private void initComponents(View v) {
        ok_btn = v.findViewById(R.id.frag_ok_btn);
    }
}
