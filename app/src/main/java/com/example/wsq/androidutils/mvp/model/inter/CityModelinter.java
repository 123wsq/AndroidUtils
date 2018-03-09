package com.example.wsq.androidutils.mvp.model.inter;

import android.content.Context;

import com.example.wsq.androidutils.mvp.callback.Callback;
import com.wsq.library.bean.CityInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public interface CityModelinter {

    void loadAllCity(Context context, Callback<List<CityInfoBean>> callback) throws Exception;

    void searchCity(Context context, String like, Callback<List<CityInfoBean>> callback)throws Exception;
}
