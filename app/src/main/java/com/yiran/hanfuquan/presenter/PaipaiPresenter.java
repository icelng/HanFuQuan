package com.yiran.hanfuquan.presenter;

import android.os.Bundle;

import com.yiran.hanfuquan.bean.FuliPictureResData;
import com.yiran.hanfuquan.bean.Result;
import com.yiran.hanfuquan.network.ServerHTTPAPI;
import com.yiran.hanfuquan.view.fragment.PaipaiFragment;

import java.util.List;

import nucleus.presenter.RxPresenter;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.schedulers.Schedulers;


/**
 * Created by yiran on 2017/9/1.
 */

public class PaipaiPresenter extends RxPresenter<PaipaiFragment> {

    private static final int RESTART_REQUEST_REMOTE = 1;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        restartableReplay(RESTART_REQUEST_REMOTE, new Func0<Observable<Result<List<FuliPictureResData>>>>() {
            @Override
            public Observable<Result<List<FuliPictureResData>>> call() {
                return ServerHTTPAPI.getGankAPI().getFuliPicture(1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        }, new Action2<PaipaiFragment, Result<List<FuliPictureResData>>>() {
            @Override
            public void call(PaipaiFragment paipaiFragment, Result<List<FuliPictureResData>> listResult) {
                System.out.println("重新请求了");
                List<FuliPictureResData> dataList = listResult.data;
                for (int i = 0; i < dataList.size(); i++) {
                    paipaiFragment.getPaipaiAdapter().add(dataList.get(i).getWho(), dataList.get(i).getImgUrl());
                }
                paipaiFragment.getPaipaiAdapter().notifyDataSetChanged();
            }
        }, new Action2<PaipaiFragment, Throwable>() {
            @Override
            public void call(PaipaiFragment paipaiFragment, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        // 如果是第一次打开fragment则调用开始需要的请求
        if (savedState == null){
            start(RESTART_REQUEST_REMOTE);
        }
    }
}
