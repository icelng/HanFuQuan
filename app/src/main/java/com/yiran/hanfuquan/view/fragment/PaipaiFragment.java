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
import com.yiran.hanfuquan.presenter.PaipaiPresenter;
import com.yiran.hanfuquan.view.activity.MainActivity;

import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusFragment;


/**
 * Created by yiran on 2017/9/1.
 * 拍拍页面
 */

@RequiresPresenter(PaipaiPresenter.class)
public class PaipaiFragment extends NucleusFragment<PaipaiPresenter> {

    private PaipaiAdapter paipaiAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("我就是看一下，onCreate方法有么有正常执行");
//        if (savedInstanceState == null){
//            getPresenter();
//        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_paipai, container, false);
        ((View)((MainActivity)getActivity()).getToolbar().getParent()).setElevation(0);  // 设置toolbar的阴影为0
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.ryc_paipai);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        paipaiAdapter = new PaipaiAdapter(getContext());
//        paipaiAdapter.add("青青子衿", R.drawable.img20);
//        paipaiAdapter.add("悠悠我心", R.drawable.img21);
//        paipaiAdapter.add("但为君故", R.drawable.img22);
//        paipaiAdapter.add("沉吟至今", R.drawable.img23);
//        paipaiAdapter.add("青青子佩", R.drawable.img25);
//        paipaiAdapter.add("悠悠我思", R.drawable.img24);
//        paipaiAdapter.add("纵我不往", R.drawable.img19);
//        paipaiAdapter.add("子宁不来", R.drawable.img26);
        recyclerView.setAdapter(paipaiAdapter);

    }

    public PaipaiAdapter getPaipaiAdapter(){
        return this.paipaiAdapter;
    }
}
