package com.yiran.hanfuquan.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.yiran.hanfuquan.R;
import com.yiran.hanfuquan.adapter.FragmentPagerAdapter;
import com.yiran.hanfuquan.view.activity.MainActivity;


import nucleus.view.NucleusFragment;


/**
 * Created by yiran on 2017/9/1.
 * 首页，其包含综合页面、拍拍页面、活动页面和交易页面
 */

public class HomeFragment extends Fragment {



    private NucleusFragment fragmentAty = new AtyFragment();
    private NucleusFragment fragmentDeal = new DealFragment();
    private NucleusFragment fragmentPaiai = new PaipaiFragment();
    private NucleusFragment fragmentSummary = new SummaryFragment();
    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private PagerSlidingTabStrip tabs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);
        ((View)((MainActivity)getActivity()).getToolbar().getParent()).setElevation(0);  // 设置toolbar的阴影为0
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentPagerInit(view);  // 初始化fragmentPager,实现左右滑动fragment
    }

    private void fragmentPagerInit(View view){
        fragmentPagerAdapter = new FragmentPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager = (ViewPager) view.findViewById(R.id.view_pager_fragment);
        fragmentPagerAdapter.add(new FragmentPagerAdapter.FragmentInfo(fragmentSummary, "综合"));
        fragmentPagerAdapter.add(new FragmentPagerAdapter.FragmentInfo(fragmentPaiai, "拍拍"));
        fragmentPagerAdapter.add(new FragmentPagerAdapter.FragmentInfo(fragmentAty, "活动"));
        fragmentPagerAdapter.add(new FragmentPagerAdapter.FragmentInfo(fragmentDeal, "交易"));
        viewPager.setAdapter(fragmentPagerAdapter);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs_fragment);
        tabs.setIndicatorHeight(8);
        tabs.setIndicatorColor(0xFFFFFFFF);
        tabs.setUnderlineHeight(0);
        tabs.setDividerColor(0);
        tabs.setTextSize(36);
        tabs.setTabPaddingLeftRight(120);
        tabs.setTextColor(0xFFFFFFFF);
        tabs.setViewPager(viewPager);
    }

}
