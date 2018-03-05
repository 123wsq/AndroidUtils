package com.example.wsq.androidutils.mvp.model;

import com.wsq.library.exception.WException;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

public interface BaseModel {

    void loadHttpData(String url, Map<String, String> param, OnDataLoadListener loadListener);



    /**
     * 内部回调接口
     */
    interface OnDataLoadListener{
        //请求成功回调
        void onComplete(Map<String, Object> map);

        void onLoadError(String errorCode, String errorMsg);
    }
}
