package com.example.wsq.androidutils.mvp.model;

import com.orhanobut.logger.Logger;
import com.wsq.library.exception.ErrorCode;
import com.wsq.library.exception.WException;
import com.wsq.library.okhttp.CallBackUtil;
import com.wsq.library.okhttp.OkhttpUtil;
import com.wsq.library.utils.DataFormat;
import com.wsq.library.utils.ParamFormat;
import com.wsq.library.utils.ParamValidate;

import java.util.Map;

import okhttp3.Call;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

public class BaseModelImpl implements BaseModel {

    /***
     * 加载网络数据
     * @param url
     * @param  param
     * @param loadListener
     */
    @Override
    public void loadHttpData(String url, Map<String, String> param, final OnDataLoadListener loadListener) {
        Logger.d("请求地址: " + url + "\n请求参数：" + param);
        try {
            ParamValidate.validate(param, "");
            OkhttpUtil.okHttpGet(url, param, new CallBackUtil.CallBackString() {
                @Override
                public void onFailure(Call call, Exception e) {
                    e.printStackTrace();
                    try {
                        throw new WException(ErrorCode.EX_H0001.getCode(), ErrorCode.EX_H0001.getMsg());
                    } catch (WException e1) {
                        e1.printStackTrace();
                    }
                }

                @Override
                public void onResponse(String response) {
                    Logger.d("返回数据： " + response);
                    try {
                        //将JSON格式转换成map
                        Map<String, Object> map = DataFormat.onAllJsonToMap(response);
                        loadListener.onComplete(map);
                    } catch (Exception e) {
                        loadListener.onLoadError(ErrorCode.EX_H0006.getCode(), ErrorCode.EX_H0006.getMsg());
                        e.printStackTrace();
                    }
                }
            });
        } catch (WException e) {
            loadListener.onLoadError(ErrorCode.EX_H0002.getCode(), ErrorCode.EX_H0002.getMsg());
            e.printStackTrace();
        }
    }
}
