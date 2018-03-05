package com.wsq.library.utils;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wsq on 2017/12/12.
 */

public class ParamFormat {

    public static Map<String, Object> onJsonToMap(String string){

        Map<String, Object> map = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(string);
            int count = jsonObject.length();

            Iterator<String> iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                Object value = jsonObject.opt(key);
                if (value instanceof JSONArray) {
                    List<Map<String, Object>> list = new ArrayList<>();
                    JSONArray jsona = (JSONArray) value;
                    for (int i = 0; i < jsona.length(); i++) {

                        list.add(onJsonToMap(jsona.get(i).toString()));
                    }
                    map.put(key, list);
                } else {

                    if (TextUtils.isEmpty(value + "") || value.toString().equals("null")) {
                        map.put(key, "");
                    } else {
                        map.put(key, value);
                    }

                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 最新
     * @param string
     * @return
     * @throws Exception
     */
    public static Map<String, Object> onAllJsonToMap(String string){
        Map<String, Object> map = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(string);
            int count = jsonObject.length();

            Iterator<String> iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                Object value = jsonObject.opt(key);
                if (value instanceof JSONArray) {
                    List<Map<String, Object>> list = new ArrayList<>();
                    JSONArray jsona = (JSONArray) value;
                    for (int i = 0; i < jsona.length(); i++) {

                        list.add(onAllJsonToMap(jsona.get(i).toString()));
                    }
                    map.put(key, list);
                } else if (value instanceof JSONObject) {
                    map.put(key, onJsonToMap(value.toString()));
                } else {


                    if (TextUtils.isEmpty(value + "") || value.toString().equals("null")) {
                        map.put(key, "");
                    } else {
                        map.put(key, value);
                    }

                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 判断是否为中文字符
     *
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
}
