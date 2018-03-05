package com.wsq.library.tools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wsq on 2018/1/11.
 */

public class ToastUtils {

    private static ToastUtils toastUtils;
    private static Context mContext;

    public ToastUtils(){

    }
    public static ToastUtils getInstance(Context context){

        if (toastUtils == null){
            mContext = context;
            toastUtils = new ToastUtils();
        }
        return toastUtils;
    }

    public static void onToast(String msg){

        if (mContext == null){
            return;
        }
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
