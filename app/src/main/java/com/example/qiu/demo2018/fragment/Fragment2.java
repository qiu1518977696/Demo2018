package com.example.qiu.demo2018.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.qiu.demo2018.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Fragment2 extends Fragment implements View.OnClickListener{
    private View view;
    private RelativeLayout guang_view;//光度
    private RelativeLayout wendu_view;//温度
    private RelativeLayout Co2_view;//二氧化碳
    private TextView textView_guang;
    private TextView textView_co2;
    private TextView textView_wendu;
    private ArrayList<String> list;
    int num_1=0;
    int num_2=0;
    int num_3=0;
    Timer timer;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ArrayList list1= (ArrayList) msg.obj;
            Log.i("sssss:", list1.toString());
            textView_wendu.setText(""+list1.get(0));
            textView_co2.setText(""+list1.get(1));
            textView_guang.setText(""+list1.get(2));
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.layout_fragment_02,null);
        guang_view=(RelativeLayout) view.findViewById(R.id.guang_view);
        wendu_view=(RelativeLayout) view.findViewById(R.id.wendu_view);
        wendu_view.setOnClickListener(this);
        Co2_view=(RelativeLayout) view.findViewById(R.id.Co2_view);
        guang_view.setOnClickListener(this);
        Co2_view.setOnClickListener(this);
        list=new ArrayList<>();
        textView_guang=(TextView) view.findViewById(R.id.textView7);
        textView_co2=(TextView) view.findViewById(R.id.textView8);
        textView_wendu=(TextView) view.findViewById(R.id.textView9);
       new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                while (true){
                    num_1= (int) (Math.random()*45);
                    num_2= (int) (Math.random()*200);
                    num_3= (int) (Math.random()*1000);
                    Toast.makeText(getActivity(), "ashkjhskfj", Toast.LENGTH_SHORT).show();
                    if(!list.isEmpty())
                    {
                        list.clear();
                        list.add(""+num_1);
                        list.add(""+num_2);
                        list.add(""+num_3);
                    }
                    else
                    {
                        list.add(""+num_1);
                        list.add(""+num_2);
                        list.add(""+num_3);
                    }
                    Message message=  handler.obtainMessage();
                    message.obj=list;
                    handler.sendMessage(message);
                    Looper.loop();
                }
            }
        }).start();
        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.wendu_view:
                 getFragmentManager().beginTransaction().replace(R.id.liner_view,new Fragment3()).commit();
                 break;
            case R.id.guang_view:
                getFragmentManager().beginTransaction().replace(R.id.liner_view,new Fragment3()).commit();
                break;
            case R.id.Co2_view:
                getFragmentManager().beginTransaction().replace(R.id.liner_view,new Fragment3()).commit();
                break;
        }
    }
}
