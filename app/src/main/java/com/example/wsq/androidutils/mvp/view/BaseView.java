package com.example.wsq.androidutils.mvp.view;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

public interface BaseView {



    void showLoadding();

    void dismissLoadding();


    void showData(Map<String, Object> result);

    void loadFail(String errorMsg);
}
