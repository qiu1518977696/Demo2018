package com.example.qiu.demo2018.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.qiu.demo2018.R;

public class Fragment8  extends Fragment{
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view=inflater.inflate(R.layout.layout_fragment_08,null);

        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().onBackPressed();
    }
}
