package com.yiran.hanfuquan.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yiran.hanfuquan.R;
import com.yiran.hanfuquan.adapter.PaipaiAdapter;
import com.yiran.hanfuquan.view.activity.MainActivity;

import nucleus.view.NucleusFragment;

/**
 * Created by yiran on 2017/9/1.
 * 综合页面
 */

public class SummaryFragment extends NucleusFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_summary, container, false);
        ((View)((MainActivity)getActivity()).getToolbar().getParent()).setElevation(0);  // 设置toolbar的阴影为0
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
