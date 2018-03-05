package com.example.wsq.androidutils.mvp.model;

import java.util.List;
import java.util.Map;

/**
 * 用来加载数据网络以及数据库本地
 * Created by wsq on 2018/1/17.
 */

public interface IModel {


    void loadData(OnDataLoadListener loadListener);


    /**
     * 内部回调接口
     */
    interface OnDataLoadListener{

        void onComplete(List<Map<String, Object>> list);
    }


}
