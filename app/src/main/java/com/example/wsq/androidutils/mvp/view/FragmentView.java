package com.example.wsq.androidutils.mvp.view;

import java.util.List;
import java.util.Map;

/**
 * Created by wsq on 2018/1/24.
 */

public  interface FragmentView{


    /**
     * 显示进度
     */
    void onShowProgress();

    /**
     * 隐藏进度
     */
    void onHideProgress();

    /**
     * 显示数据
     * @param data
     */
    void showData(List<Map<String, Object>> data);
}
