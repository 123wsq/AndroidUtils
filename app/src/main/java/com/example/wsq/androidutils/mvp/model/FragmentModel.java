package com.example.wsq.androidutils.mvp.model;

import java.util.List;
import java.util.Map;

/**
 * Created by wsq on 2018/1/24.
 */

public interface FragmentModel {


    void loadData(FragmentModel.OnDataLoadListener loadListener);


    /**
     * 内部回调接口
     */
    interface OnDataLoadListener{

        void onComplete(List<Map<String, Object>> list);
    }


}
