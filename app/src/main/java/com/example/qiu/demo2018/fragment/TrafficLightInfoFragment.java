package com.example.qiu.demo2018.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.qiu.demo2018.R;
import com.example.qiu.demo2018.adapter.TrafficLightInfoAdapter;
import com.example.qiu.demo2018.gson.TrafficLightInfoGson;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by qiu on 2018/4/3.
 */

public class TrafficLightInfoFragment extends Fragment {
    private int sortBy = 0;
    private List<TrafficLightInfoGson> mlist;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mlist = TrafficLightInfoGson.getDefaultList();
        final View view = inflater.inflate(R.layout.traffic_light_info_layout, container, false);
        TrafficLightInfoAdapter adapter = new TrafficLightInfoAdapter(getContext(), mlist);
        ((ListView) view.findViewById(R.id.lv_traffic_light_info)).setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item, new String[]{"红灯升序", "绿灯降序", "黄灯升序"});
        ((Spinner) view.findViewById(R.id.sp_traffic_light_sort)).setAdapter(adapter1);
        ((Spinner) view.findViewById(R.id.sp_traffic_light_sort)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sortBy = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        view.findViewById(R.id.btn_selectTrafficLightInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ---->"+sortBy);
                switch (sortBy) {
                    case 0:
                        Collections.sort(mlist, new Comparator<TrafficLightInfoGson>() {
                            @Override
                            public int compare(TrafficLightInfoGson o1, TrafficLightInfoGson o2) {
                                return Integer.compare(Integer.valueOf(o1.redLightTimes),
                                        Integer.valueOf(o2.redLightTimes));
                            }
                        });
                        ((ListView)view.findViewById(R.id.lv_traffic_light_info)).setAdapter(new TrafficLightInfoAdapter(getContext(),mlist));
                        break;
                    case 1:
                        Collections.sort(mlist, new Comparator<TrafficLightInfoGson>() {
                            @Override
                            public int compare(TrafficLightInfoGson o1, TrafficLightInfoGson o2) {
                                return Integer.compare(Integer.valueOf(o2.greenLightTimes),
                                        Integer.valueOf(o1.greenLightTimes));
                            }
                        });
                        ((ListView)view.findViewById(R.id.lv_traffic_light_info)).setAdapter(new TrafficLightInfoAdapter(getContext(),mlist));
                        break;
                    case 2:
                        Collections.sort(mlist, new Comparator<TrafficLightInfoGson>() {
                            @Override
                            public int compare(TrafficLightInfoGson o1, TrafficLightInfoGson o2) {
                                return Integer.compare(Integer.valueOf(o1.yellowLightTimes),
                                        Integer.valueOf(o2.yellowLightTimes));
                            }
                        });
                        ((ListView)view.findViewById(R.id.lv_traffic_light_info)).setAdapter(new TrafficLightInfoAdapter(getContext(),mlist));

                        break;

                }

            }
        });

        return view;
    }
}
