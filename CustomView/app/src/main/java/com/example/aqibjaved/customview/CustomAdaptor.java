package com.example.aqibjaved.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AQIB JAVED on 11/4/2017.
 */

public class CustomAdaptor extends BaseAdapter{
    private Context context;
    private List<ListEntity> entities;

    public CustomAdaptor(Context context, List<ListEntity> entities) {
        this.context = context;
        this.entities = entities;
    }

    @Override
    public int getCount() {
        return entities.size();
    }

    @Override
    public Object getItem(int i) {
        return entities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View customView = view;
        if(customView == null) customView= LayoutInflater.from(context).inflate(R.layout.customlistview,null);
        ImageView image= (ImageView) customView.findViewById(R.id.image);
        image.setImageResource(this.entities.get(i).getIcon());
        TextView textView=(TextView)customView.findViewById(R.id.title);
        textView.setText(this.entities.get(i).getTitle());
        return customView;
    }
}
