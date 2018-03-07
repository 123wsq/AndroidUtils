package com.example.wsq.androidutils.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;


import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
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

        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE,"");
        /**
         * 设置组件化的Log开关
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        UMConfigure.setLogEnabled(true);
        /**
         * 设置日志加密
         * 参数：boolean 默认为false（不加密）
         */
        UMConfigure.setEncryptEnabled(true);
        MobclickAgent.setCatchUncaughtExceptions(true);
    }
}
