package com.evs.testapplication.evsandroid31_sdkinstallationproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AQIB JAVED on 10/7/2018.
 */

public class CustomAdaptor extends BaseAdapter{
    private Context context;
    private List<ListEntites> listEntitesList;
    public CustomAdaptor(Context context,List<ListEntites> listEntitesList){
            this.context = context;
            this.listEntitesList = listEntitesList;
    }

    @Override
    public int getCount() {
        return listEntitesList.size();
    }

    @Override
    public Object getItem(int i) {
        return listEntitesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View customView = view;
        if(customView == null) customView = LayoutInflater.from(context).inflate(R.layout.customlistlayout,null);
        ImageView img = customView.findViewById(R.id.icon);
        img.setImageResource(listEntitesList.get(i).getImageSrc());
        TextView tv = customView.findViewById(R.id.title);
        tv.setText(listEntitesList.get(i).getTitle());
        return customView;
    }
}
