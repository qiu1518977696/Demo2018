package com.example.qiu.demo2018.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.qiu.demo2018.R;
import com.example.qiu.demo2018.gson.TrafficLightInfoGson;

import java.util.List;

/**
 * Created by qiu on 2018/4/3.
 */

public class TrafficLightInfoAdapter extends BaseAdapter {
    private List<TrafficLightInfoGson> mList;
    private Context mContext;
    public TrafficLightInfoAdapter(Context context,List<TrafficLightInfoGson> infoList){
        this.mList = infoList;
        mContext = context;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.traffic_light_info_item,parent,false);
        ((TextView)view.findViewById(R.id.tv_road_number)).setText(mList.get(position).roadNumber+"号路口");
        ((TextView)view.findViewById(R.id.tv_red_light_info)).setText(mList.get(position).redLightTimes);
        ((TextView)view.findViewById(R.id.tv_green_light_times)).setText(mList.get(position).greenLightTimes);
        ((TextView)view.findViewById(R.id.tv_yellow_light_times)).setText(mList.get(position).yellowLightTimes);
        return view;
    }
}
