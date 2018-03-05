package com.example.wsq.androidutils.mvp.presenter;


import com.orhanobut.logger.Logger;

import java.lang.ref.WeakReference;

/**
 * Created by wsq on 2018/1/17.
 */

public class BasePresenter<T> {

    protected WeakReference<T> weakReference;

    //绑定
    public void attachView(T view){

        weakReference =new WeakReference<T>(view);
    }
    //解绑

    public void deachView(){
        weakReference.clear();

    }

}
