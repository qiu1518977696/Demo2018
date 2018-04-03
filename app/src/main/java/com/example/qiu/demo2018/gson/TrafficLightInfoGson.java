package com.example.qiu.demo2018.gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiu on 2018/4/3.
 */

public class TrafficLightInfoGson {
    public String roadNumber;//几号路口
    public String yellowLightTimes;
    public String redLightTimes;
    public String greenLightTimes;
    public static List<TrafficLightInfoGson> getDefaultList(){
        List<TrafficLightInfoGson> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            TrafficLightInfoGson gson = new TrafficLightInfoGson();
            gson.redLightTimes=""+(i+2);
            gson.yellowLightTimes=""+(i+3);
            gson.greenLightTimes=""+(i+4);
            gson.roadNumber=""+(i+1);
            list.add(gson);
        }
        return list;
    }
}
