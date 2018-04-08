package com.example.qiu.demo2018.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qiu.demo2018.R;

import java.util.Date;
import java.util.Random;

public class Fragment5 extends Fragment {
    private View view;
    private TextView tv_wd;
    private TextView tv_pm;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(final Message msg) {
            if(msg.what==1){
                tv_pm.setText(""+msg.arg1);
                tv_wd.setText(msg.arg1+"℃");
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        int pm2=random.nextInt(30);
                        int wd = random.nextInt(20);
                        Message message = new Message();
                        message.arg1=pm2;
                        message.arg2=wd;
                        message.what=1;
                        sendMessage(message);
                    }
                },1000*5);
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment5,null);
        tv_pm = (TextView)view.findViewById(R.id.tv_pm);
        tv_wd = (TextView)view.findViewById(R.id.tv_wd);
        Message message = new Message();
        message.what=1;
        message.arg1=10;
        message.arg2=5;
        mHandler.sendMessage(message);
        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().onBackPressed();
    }
}
