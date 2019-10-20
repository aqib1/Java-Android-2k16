package com.example.aqibjaved.evs_batch27_customlistview_mediaplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AQIB JAVED on 3/24/2018.
 */

public class CustumListAdaptor extends BaseAdapter {
    private List<ListEntity> list;
    private Context context;
    public CustumListAdaptor(List<ListEntity> list, Context context){
        this.list=list;
        this.context=context;
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
        View customView=view;
        if(customView==null) customView = LayoutInflater.from(context).inflate(R.layout.customlistview,null);
        ImageView imageView = customView.findViewById(R.id.icon);
        imageView.setImageResource(list.get(i).getId());
        TextView textView = customView.findViewById(R.id.title);
        textView.setText(list.get(i).getTitle());
        return customView;
    }
}
