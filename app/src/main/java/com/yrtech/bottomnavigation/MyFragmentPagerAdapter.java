package com.yrtech.bottomnavigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    List<String> stringList;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.fragmentList = list;
    }

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list, List<String> stringList) {
        super(fm);
        this.fragmentList = list;
        this.stringList = stringList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (stringList == null) {
            return position + "";
        } else {
            return stringList.get(position);
        }
    }
}
