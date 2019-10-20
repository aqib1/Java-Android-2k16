package com.evs.testapplication.sastabotique_local.topics;

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

public class CustomAdaptor extends BaseAdapter {
    private List<ListEntityBean> list;
    private Context context;
    public CustomAdaptor(List<ListEntityBean> list,Context context){
        this.list = list;
        this.context= context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
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
        ImageView imageView = customView.findViewById(R.id.icon);
        imageView.setImageResource(list.get(i).getImagesrc());
        TextView textView = customView.findViewById(R.id.message);
        textView.setText(list.get(i).getTitle());
        return customView;
    }
}
