package com.wsq.library.views.listener;

import com.wsq.library.bean.CityInfoBean;

public interface OnCityResultCallBack {

    void onCallBack(CityInfoBean province, CityInfoBean city, CityInfoBean county);
}
