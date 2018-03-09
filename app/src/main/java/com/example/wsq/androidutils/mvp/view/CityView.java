package com.example.wsq.androidutils.mvp.view;

import com.wsq.library.bean.CityInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public interface CityView extends BaseView{

    void showAllCity(List<CityInfoBean> list);
}
