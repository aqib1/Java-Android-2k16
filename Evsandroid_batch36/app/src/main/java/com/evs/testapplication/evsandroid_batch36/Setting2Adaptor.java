package com.evs.testapplication.evsandroid_batch36;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AQIB JAVED on 12/9/2018.
 */

public class Setting2Adaptor extends BaseAdapter {
    private Context context;
    private List<SettingBean> settingBeens = null;

    public Setting2Adaptor (Context context, List<SettingBean> settingBeens){
        this.context = context;
        this.settingBeens = settingBeens;
    }

    @Override
    public int getCount() {
        return this.settingBeens.size();
    }

    @Override
    public Object getItem(int i) {
        return this.settingBeens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View customView = view;
        if(null == customView){
            customView = LayoutInflater.from(context).inflate(R.layout.setting_activity_custom_list_layout,null);
        }
        ImageView settingIcon = customView.findViewById(R.id.icon_settings);
        TextView title = customView.findViewById(R.id.title);
        TextView subTitle = customView.findViewById(R.id.subtitle);

        settingIcon.setImageResource(this.settingBeens.get(i).getImageSrc());
        title.setText(this.settingBeens.get(i).getTitle());
        subTitle.setText(this.settingBeens.get(i).getSubTitle());
        return customView;
    }
}
