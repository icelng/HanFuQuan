package com.yiran.hanfuquan.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by yiran on 2017/9/2.
 */

public class Result<T> {
    @SerializedName("error")
    public boolean error;
    @SerializedName("results")
    public T data;
}
