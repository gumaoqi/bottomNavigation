package com.yrtech.bottomnavigation;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_back_tv)
    TextView activityMainBackTv;
    @BindView(R.id.activity_main_title_tv)
    TextView activityMainTitleTv;
    @BindView(R.id.activity_main_menu_tv)
    TextView activityMainMenuTv;
    @BindView(R.id.activity_main_fragment_vp)
    ViewPager activityMainFragmentVp;
    @BindView(R.id.activity_main_bottom_navigation_tl)
    TabLayout activityMainBottomNavigationTl;


    List<Fragment> fragmentList;
    List<String> stringList;
    MyFragmentPagerAdapter myFragmentPagerAdapter;

    void inidata() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new MyFragment());
        fragmentList.add(new MyFragment());
        fragmentList.add(new MyFragment());
        fragmentList.add(new MyFragment());
        fragmentList.add(new MyFragment());
        stringList = new ArrayList<>();
        stringList.add("苹果");
        stringList.add("香蕉");
        stringList.add("菠萝");
        stringList.add("葡萄");
        stringList.add("西瓜");
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList, stringList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        inidata();
        //设置viewpager和tablayout
        activityMainFragmentVp.setAdapter(myFragmentPagerAdapter);
        activityMainFragmentVp.setOffscreenPageLimit(5);
        activityMainBottomNavigationTl.setupWithViewPager(activityMainFragmentVp);
        for (int i = 0; i < activityMainBottomNavigationTl.getTabCount(); i++) {
            activityMainBottomNavigationTl.getTabAt(i).setIcon(R.mipmap.ic_launcher_round);
        }
        activityMainBottomNavigationTl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        activityMainTitleTv.setText("苹果");
                        break;
                    case 1:
                        activityMainTitleTv.setText("香蕉");
                        break;
                    case 2:
                        activityMainTitleTv.setText("菠萝");
                        break;
                    case 3:
                        activityMainTitleTv.setText("葡萄");
                        break;
                    case 4:
                        activityMainTitleTv.setText("西瓜");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
