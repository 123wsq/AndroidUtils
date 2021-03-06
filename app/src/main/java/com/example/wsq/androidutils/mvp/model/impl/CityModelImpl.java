package com.example.wsq.androidutils.mvp.model.impl;

import android.content.Context;

import com.example.wsq.androidutils.mvp.callback.Callback;
import com.example.wsq.androidutils.mvp.model.inter.CityModelinter;
import com.wsq.library.bean.CityInfoBean;
import com.wsq.library.dao.CityDao;
import com.wsq.library.utils.AppManager;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public class CityModelImpl implements CityModelinter{


    public CityModelImpl(){

    }
    @Override
    public void loadAllCity(Context context, Callback<List<CityInfoBean>> callback) {
        CityDao cityDao = new CityDao(context, AppManager.getAppPackageName());
        List<CityInfoBean> list = cityDao.getData(-1);
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void searchCity(Context context, String like, Callback<List<CityInfoBean>> callback) {
        CityDao cityDao = new CityDao(context, AppManager.getAppPackageName());
        List<CityInfoBean> list = cityDao.getData(-1);
        callback.onSuccess(list);
        callback.onComplete();
    }
}
