package com.example.wsq.androidutils.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;


import com.wsq.library.tools.ToastUtils;

import butterknife.ButterKnife;

/**
 * Created by wsq on 2018/1/6.
 */

public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.getInstance(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
