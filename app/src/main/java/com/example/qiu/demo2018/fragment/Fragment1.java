package com.example.qiu.demo2018.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import com.example.qiu.demo2018.R;

import java.io.File;

public class Fragment1 extends Fragment implements View.OnClickListener
{
    private View view;
    private ImageView imageview_1;
    private ImageView imageview_2;
    private ImageView imageview_3;
    private VideoView video_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.layout_fragment_01,null);
        imageview_1=(ImageView) view.findViewById(R.id.imageview_1);
        imageview_1.setOnClickListener(this);
        imageview_2=(ImageView) view.findViewById(R.id.imageview_2);
        imageview_2.setOnClickListener(this);
        imageview_3=(ImageView) view.findViewById(R.id.imageview_3);
        imageview_3.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
         getActivity().onBackPressed();
    }
    AlertDialog.Builder builder;
    @Override
    public void onClick(View v) {
              builder=new AlertDialog.Builder(getActivity());
              View view=LayoutInflater.from(getActivity()).inflate(R.layout.layout_vide,null);
              MediaController mediaController;
              builder.setView(view);
              video_view=(VideoView) view.findViewById(R.id.video_view);
        switch (v.getId())
        {
            case R.id.imageview_1:
                video_view.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.s1));
                 mediaController=new MediaController(getActivity());
                video_view.setMediaController(mediaController);
                mediaController.setMediaPlayer(video_view);
                video_view.start();
                builder.create().show();
                break;
            case R.id.imageview_2:
                video_view.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.s2));
                 mediaController=new MediaController(getActivity());
                video_view.setMediaController(mediaController);
                mediaController.setMediaPlayer(video_view);
                video_view.start();
                builder.create().show();
                break;
            case R.id.imageview_3:
                video_view.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.s3));
                 mediaController=new MediaController(getActivity());
                video_view.setMediaController(mediaController);
                mediaController.setMediaPlayer(video_view);
                video_view.start();
                builder.create().show();
                break;
        }
    }
}
