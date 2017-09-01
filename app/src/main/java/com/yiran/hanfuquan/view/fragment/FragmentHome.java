package com.yiran.hanfuquan.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.astuetz.PagerSlidingTabStrip;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.yiran.hanfuquan.R;
import com.yiran.hanfuquan.adapter.FragmentPagerAdapter;
import com.yiran.hanfuquan.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;

import nucleus.view.NucleusFragment;


/**
 * Created by yiran on 2017/9/1.
 */

public class FragmentHome extends Fragment {

    private static final int STANDARD_ZONG = 2;
    private static final int STANDARD_HAN = 1;
    private static final int STANDARD_MING = 0;
    private static final int STANDARD_SONG = 3;
    private static final int STANDARD_TANG = 4;


    private NucleusFragment fragmentAty = new FragmentAty();
    private NucleusFragment fragmentDeal = new FragmentDeal();
    private NucleusFragment fragmentPaiai = new FragmentPaiai();
    private NucleusFragment fragmentSummary = new FragmentSummary();
    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private PagerSlidingTabStrip tabs;
    private BoomMenuButton bmb;
    private HashMap<Integer, Integer> bmbButtonImages;

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

        bmbInit(view);  // 初始化bmb,用来选择制式
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

    private void bmbInit(View view){
        final ImageView ivBMBMenu;
        bmb = (BoomMenuButton) view.findViewById(R.id.bmb_standard);
        ivBMBMenu = (ImageView) view.findViewById(R.id.bmb_standard_img);
        bmb.setButtonEnum(ButtonEnum.SimpleCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_5_3);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_5_4);
        bmbButtonImages = new HashMap<Integer, Integer>();
        bmbButtonImages.put(STANDARD_HAN, R.drawable.c_han);
        bmbButtonImages.put(STANDARD_MING, R.drawable.c_ming);
        bmbButtonImages.put(STANDARD_ZONG, R.drawable.c_zong);
        bmbButtonImages.put(STANDARD_SONG, R.drawable.c_song);
        bmbButtonImages.put(STANDARD_TANG, R.drawable.c_tang);
        for(int i = 0; i < bmb.getButtonPlaceEnum().buttonNumber(); i++){
            SimpleCircleButton.Builder builder = new SimpleCircleButton.Builder();
            builder.normalImageRes(bmbButtonImages.get(i));
            builder.listener(new OnBMClickListener() {
                @Override
                public void onBoomButtonClick(int index) {
                    ivBMBMenu.setImageResource(bmbButtonImages.get(index));
                }
            });
            bmb.addBuilder(builder);
        }
    }
}
