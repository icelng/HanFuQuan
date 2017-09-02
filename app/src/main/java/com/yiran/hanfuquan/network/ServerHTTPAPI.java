package com.yiran.hanfuquan.network;

import com.yiran.hanfuquan.bean.FuliPictureResData;
import com.yiran.hanfuquan.bean.Result;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yiran on 2017/9/2.
 * 该类负责封装好各个服务器的HTTP的API,使用Retrofit调用API
 */

public class ServerHTTPAPI {

    private static GankAPI gankAPI = null;

    public static  GankAPI getGankAPI(){
        if(gankAPI == null){
            gankAPI = new Retrofit
                    .Builder()
                    .baseUrl("http://gank.io/api/")
                    .addConverterFactory(GsonConverterFactory.create())  // 把请求的结果转换成JSON
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())  // 使用RxJava
                    .build()
                    .create(GankAPI.class);
        }
        return gankAPI;
    }

    public interface GankAPI{
        @GET("data/福利/20/{id}")
        Observable<Result<List<FuliPictureResData>>> getFuliPicture(@Path("id") int id);
    }
}
