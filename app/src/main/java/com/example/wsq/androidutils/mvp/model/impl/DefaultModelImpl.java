package com.example.wsq.androidutils.mvp.model.impl;

import com.example.wsq.androidutils.mvp.callback.Callback;
import com.example.wsq.androidutils.mvp.model.inter.DefaultModelInter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public class DefaultModelImpl implements DefaultModelInter {
    @Override
    public void showData(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("RecycView");
        list.add("水印");
        list.add("索引");
        list.add("城市");
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showTwoData(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("多媒体");

        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showThreeData(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("金额");
        list.add("AlertDialog");
        list.add("输入框");

        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showDialogData(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("单个按钮");
        list.add("两个按钮");
        list.add("求返回值");
        list.add("变换颜色");
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showMediaData(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("相册");
        list.add("拍照");
        list.add("视频");
        list.add("录像");
        list.add("录音");
        callback.onSuccess(list);
        callback.onComplete();
    }
}
