package com.wsq.library.tools;



import com.orhanobut.logger.Logger;
import com.wsq.library.okhttp.CallBackUtil;
import com.wsq.library.okhttp.OkhttpUtil;
import com.wsq.library.okhttp.listener.OnBaseHttpResponseListener;
import com.wsq.library.okhttp.listener.OnBaseUpFileHttpResponseListener;
import com.wsq.library.utils.ParamFormat;
import com.wsq.library.utils.UnicodeUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * Http请求封装
 */
public class RequestOkHttp {

    private static final String KEY_ERROR_CODE = "ERROR_CODE";
    private static final String KEY_ERROR_MESSAGE = "ERROR_MESSAGE";
    private static final String ERROR_CODE = "400";
    private static  String ERROR_MESSAGE = "请求失败";


    public static void sendHttpGet(String url, Map<String, String> params, final OnBaseHttpResponseListener callBack){


        OkhttpUtil.okHttpGet("", params, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ERROR_MESSAGE="请求失败";
                Map<String, Object> map = new HashMap<>();
                map.put(KEY_ERROR_CODE, ERROR_CODE);
                map.put(KEY_ERROR_MESSAGE, ERROR_MESSAGE);
                callBack.onFailure(map);
                e.printStackTrace();
            }

            @Override
            public void onResponse(String response) {

                String result = UnicodeUtil.unicodeToString(response);

                Logger.json(result);
                try {

                    Map<String, Object> map = ParamFormat.onAllJsonToMap(result);
                    callBack.onSuccess(map);
                } catch (Exception e) {
                    ERROR_MESSAGE="返回数据异常";
                    Map<String, Object> map = new HashMap<>();
                    map.put(KEY_ERROR_CODE, ERROR_CODE);
                    map.put(KEY_ERROR_MESSAGE, ERROR_MESSAGE);
                    callBack.onFailure(map);
                }

            }
        });
    }


    /**
     *
     * @param url
     * @param params
     * @param callBack
     */
    public static void sendHttpPost(String url, Map<String, String> params, final OnBaseHttpResponseListener callBack){


        OkhttpUtil.okHttpPost("", params, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                ERROR_MESSAGE="请求失败";
                Map<String, Object> map = new HashMap<>();
                map.put(KEY_ERROR_CODE, ERROR_CODE);
                map.put(KEY_ERROR_MESSAGE, ERROR_MESSAGE);
                callBack.onFailure(map);
                e.printStackTrace();
            }

            @Override
            public void onResponse(String response) {

                String result = UnicodeUtil.unicodeToString(response);
                Logger.json(result);
                try {

                    Map<String, Object> map = ParamFormat.onAllJsonToMap(result);

                    callBack.onSuccess(map);
                } catch (Exception e) {
                    ERROR_MESSAGE="返回数据异常";
                    Map<String, Object> map = new HashMap<>();
                    map.put(KEY_ERROR_CODE, ERROR_CODE);
                    map.put(KEY_ERROR_MESSAGE, ERROR_MESSAGE);
                    callBack.onFailure(map);
                }

            }
        });
    }



    /**
     *上传文件 GET请求
     * @param url
     * @param params
     * @param callBack
     */
        public static void onGetUploadFile(String url, Map<String, String> params, List<Map<String, Object>> list, final OnBaseUpFileHttpResponseListener callBack){


        OkhttpUtil.okHttpFileGet("", params, list, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                e.printStackTrace();
                Map<String, Object> map = new HashMap<>();
                map.put(KEY_ERROR_CODE, ERROR_CODE);
                map.put(KEY_ERROR_MESSAGE, ERROR_MESSAGE);
                callBack.onFailure(map);
            }

            @Override
            public void onResponse(String response) {
                String result = UnicodeUtil.unicodeToString(response);
                Logger.json(result);
                try {
                    Map<String, Object> map = ParamFormat.onJsonToMap(result);
                    callBack.onSuccess(map);
                } catch (Exception e) {
                    ERROR_MESSAGE="返回数据异常";
                    Map<String, Object> map = new HashMap<>();
                    map.put(KEY_ERROR_CODE, ERROR_CODE);
                    map.put(KEY_ERROR_MESSAGE, ERROR_MESSAGE);
                    callBack.onFailure(map);
                }
            }


            @Override
            public void onProgress(float progress, long total) {
                super.onProgress(progress, total);

                callBack.onProgress(total, progress);
            }
        });

    }


    /**
     *
     * 文件上传  POST
     * @param url
     * @param params
     * @param callBack
     */
    public static void uploadPostFile(String url, Map<String, String> params, List<Map<String, Object>> list,  final OnBaseUpFileHttpResponseListener callBack){


        OkhttpUtil.okHttpFilePost("", params, list, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                e.printStackTrace();
                Map<String, Object> map = new HashMap<>();
                map.put(KEY_ERROR_CODE, ERROR_CODE);
                map.put(KEY_ERROR_MESSAGE, ERROR_MESSAGE);
                callBack.onFailure(map);
            }

            @Override
            public void onResponse(String response) {

                String result = UnicodeUtil.unicodeToString(response);

                Logger.json(result);
                try {
                    Map<String, Object> map = ParamFormat.onJsonToMap(result);
                    callBack.onSuccess(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onProgress(float progress, long total) {
                super.onProgress(progress, total);
                callBack.onProgress(total, progress);
            }
        });

    }
}
