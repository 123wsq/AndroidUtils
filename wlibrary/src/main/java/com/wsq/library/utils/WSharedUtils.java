package com.wsq.library.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.wsq.library.exception.ErrorCode;
import com.wsq.library.exception.WException;


/**
 * Created by wsq on 2018/1/18.
 */

public class WSharedUtils {

    private  static WSharedUtils sharedUtils;
    private static SharedPreferences sharedPreferences;

    private static final String SHARED_NAME = "WSharedUtils";

    private WSharedUtils(){

    }

    public  static void getInstance(Context context){

        if (sharedUtils == null){
            sharedUtils = new WSharedUtils();
            sharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        }

    }


    /**
     * 添加值
     * @param key
     * @param o
     */
    public static void onPut(String key, Object o)throws WException {
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (o instanceof Integer){
                editor.putInt(key, (int)o );
            }else if(o instanceof Float){
                editor.putFloat(key, (float)o );
            }else if(o instanceof Double){
                editor.putFloat(key, (Float) o );
            }else if(o instanceof Boolean){
                editor.putBoolean(key, (boolean) o );
            }else if(o instanceof Long){
                editor.putLong(key, (long) o );
            }else if(o instanceof String){
                editor.putString(key,  o +"");
            }
            editor.commit();
        }else {
            throw new WException(ErrorCode.EX_S0001.getCode(), ErrorCode.EX_S0001.getMsg());
        }
    }

    /**
     * 获取Boolean类型
     * @param key
     * @return
     * @throws WException
     */
    public static boolean onGetBooleanVaule(String key)throws WException {

        if (sharedPreferences == null){
            throw new WException(ErrorCode.EX_S0001.getCode(), ErrorCode.EX_S0001.getMsg());
        }

        return sharedPreferences.getBoolean(key, false);
    }

    /**
     * 获取int类型
     * @param key
     * @return
     * @throws WException
     */
    public static int onGetIntVaule(String key)throws WException {

        if (sharedPreferences == null){
            throw new WException(ErrorCode.EX_S0001.getCode(), ErrorCode.EX_S0001.getMsg());
        }

        return sharedPreferences.getInt(key, 0);
    }

    /**
     * 获取字符串
     * @param key
     * @return
     * @throws WException
     */
    public static String onGetStringVaule(String key)throws WException {

        if (sharedPreferences == null){
            throw new WException(ErrorCode.EX_S0001.getCode(), ErrorCode.EX_S0001.getMsg());
        }

        return sharedPreferences.getString(key, "");
    }

    /**
     * 获取长整形
     * @param key
     * @return
     * @throws WException
     */
    public static long onGetLongVaule(String key)throws WException {

        if (sharedPreferences == null){
            throw new WException(ErrorCode.EX_S0001.getCode(), ErrorCode.EX_S0001.getMsg());
        }

        return sharedPreferences.getLong(key, 0);
    }

    /**
     * 获取小数
     * @param key
     * @return
     * @throws WException
     */
    public static float onGetFloatVaule(String key)throws WException {

        if (sharedPreferences == null){
            throw new WException(ErrorCode.EX_S0001.getCode(), ErrorCode.EX_S0001.getMsg());
        }

        return sharedPreferences.getFloat(key, 0);
    }
}
