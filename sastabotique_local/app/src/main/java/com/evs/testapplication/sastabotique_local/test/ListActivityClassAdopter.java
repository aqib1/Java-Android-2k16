package com.evs.testapplication.sastabotique_local.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.evs.testapplication.sastabotique_local.R;

import java.util.List;

/**
 * Created by AQIB JAVED on 9/15/2018.
 */

public class ListActivityClassAdopter extends BaseAdapter {
    private List<ListActivityEntityClass> data;
    private Context context;

    public ListActivityClassAdopter(List<ListActivityEntityClass> data,Context context){
        this.data = data;
        this.context = context;
    }


    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int i) {
        return this.data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View customView = view;
        if(customView == null)
            customView = LayoutInflater.from(context).inflate(R.layout.customlistview,null);
        ImageView image = customView.findViewById(R.id.icon);
        image.setImageResource(this.data.get(i).getImageSrc());
        TextView textView = customView.findViewById(R.id.message);
        textView.setText(this.data.get(i).getTitle());
        return customView;
    }
}
