package com.evs.testapplication.sastabotique_local.evsandroid34.baseadaopters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.evs.testapplication.sastabotique_local.R;
import com.evs.testapplication.sastabotique_local.evsandroid34.activities.authentication.beans.SettingsBean;

import java.util.List;

/**
 * Created by AQIB JAVED on 12/8/2018.
 */

public class SettingsBaseAdaptor extends BaseAdapter {
    private Context context;
    private List<SettingsBean> data;
    public SettingsBaseAdaptor(Context context,List<SettingsBean> data){
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
        if(customView == null) view = LayoutInflater.from(context).inflate(R.layout.customview_listview_34,null);
        TextView title = view.findViewById(R.id.title);
        title.setText(this.data.get(i).getTitle());
        TextView subTitle = view.findViewById(R.id.subTitle);
        subTitle.setText(this.data.get(i).getSubTitle());
        ImageView imageView = view.findViewById(R.id.texticon);
        imageView.setImageResource(this.data.get(i).getImagePath());
        return view;
    }
}
