package com.example.aqibjaved.evsbatch24customlistview;

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

public class ListViewCustomAdaptor extends BaseAdapter {
    private Context context;
    private List<ListEntity> data;

    public ListViewCustomAdaptor(Context context, List<ListEntity> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View customView = view;
        if(customView == null) customView = LayoutInflater.from(context).inflate(R.layout.customlistlayout,null);
        ImageView imageView = (ImageView) customView.findViewById(R.id.icon);
        TextView textView = (TextView) customView.findViewById(R.id.title);
        imageView.setImageResource(this.data.get(i).getImgSrc());
        textView.setText(this.data.get(i).getName());
        return view;
    }
}
