package com.example.wsq.androidutils.mvp.view;

import java.util.List;
import java.util.Map;

/**
 * 定义出所有的UI逻辑
 * Created by wsq on 2018/1/17.
 */

public interface IView {

    /**
     * 显示进度条
     */
    void showLoadding();

    /**
     * 关闭进度
     */
    void dimissLodding();

    /**
     * 显示数据
     */
    void  showData(List<Map<String, Object>> data);
}
