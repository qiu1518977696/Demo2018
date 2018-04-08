package com.example.qiu.demo2018.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.example.qiu.demo2018.R;
import com.example.qiu.demo2018.fragment.*;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private NavigationView NavigationView_01;
    private DrawerLayout drawlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.set1);
        setSupportActionBar(toolbar);
        drawlayout=(DrawerLayout) findViewById(R.id.drawlayout);
        NavigationView_01=(NavigationView) findViewById(R.id.NavigationView_01);
        //添加toolbar点击滑动侧边栏事件
        ActionBarDrawerToggle barDrawerToggle=new ActionBarDrawerToggle(this,drawlayout,toolbar,0,0);
        barDrawerToggle.syncState();
        drawlayout.addDrawerListener(barDrawerToggle);
        NavigationView_01.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        if (drawlayout.isDrawerOpen(GravityCompat.START)) {
            drawlayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.fragment1:
                getFragmentManager().beginTransaction().replace(R.id.liner_view,new Fragment1()).addToBackStack(null).commit();
                break;
            case R.id.fragment2:
                getFragmentManager().beginTransaction().replace(R.id.liner_view,new Fragment2()).addToBackStack(null).commit();
                break;
            case R.id.fragment3:
                getFragmentManager().beginTransaction().replace(R.id.liner_view,new Fragment3()).addToBackStack(null).commit();
                break;
            case R.id.fragment4:
                getFragmentManager().beginTransaction().replace(R.id.liner_view,new TrafficLightInfoFragment()).addToBackStack(null).commit();

                break;
            case R.id.fragment5:
                getFragmentManager().beginTransaction().replace(R.id.liner_view,new Fragment5()).addToBackStack(null).commit();
                break;


        }
        drawlayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
