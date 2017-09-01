package com.yiran.hanfuquan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

import nucleus.view.NucleusFragment;


/**
 * Created by yiran on 2017/8/28.
 */

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter{
    static public class FragmentInfo{
        public NucleusFragment fragment;
        public String fragmentName;
        public FragmentInfo(NucleusFragment fragment, String fragmentName){
            this.fragment = fragment;
            this.fragmentName = fragmentName;
        }
    }
    private ArrayList<FragmentInfo> fragments = new ArrayList<>();

    public void add(FragmentInfo fragmentInfo){
        fragments.add(fragmentInfo);
    }

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position).fragment;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).fragmentName;
    }
}
