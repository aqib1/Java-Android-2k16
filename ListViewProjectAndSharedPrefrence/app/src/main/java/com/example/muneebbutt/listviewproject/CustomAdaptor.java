package com.example.muneebbutt.listviewproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Muneeb Butt on 8/5/2017.
 */

public class CustomAdaptor extends BaseAdapter {
    private List<Entities> data;
    private Context context;
    public CustomAdaptor(List<Entities> data, Context context){
        this.data=data;
        this.context=context;
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
            if(customView==null) customView=LayoutInflater.from(context).inflate(R.layout.customlistview,null);
            ImageView imageView=(ImageView)customView.findViewById(R.id.icon);
//          imageView.setImageResource(((Entities)this.getItem(i)).getIcon());
            imageView.setImageResource(this.data.get(i).getIcon());
            TextView textView=(TextView)customView.findViewById(R.id.message);
            textView.setText(this.data.get(i).getTitle());
        return customView;
    }
}
