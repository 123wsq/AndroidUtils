package com.wsq.library.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.orhanobut.logger.Logger;
import com.wsq.library.bean.CityInfoBean;
import com.wsq.library.constant.CityKey;
import com.wsq.library.db.DBHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/8 0008.
 */

public class CityDao {
    private DBHelper myDbHelper;

    public CityDao(Context context, String pkg){

        myDbHelper = new DBHelper(context, pkg);
        try {
            myDbHelper.createDataBase();
            myDbHelper.openDataBase();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有的省份
     * @return
     */
    public List<CityInfoBean> getAllProvince(){
        List<CityInfoBean> listCity = new ArrayList<>();

        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor c = db.query(CityKey.TABLE_PROVINCE, null, null, null, null, null, CityKey.PROVINCE_SPELL);
        while (c.moveToNext()){
            CityInfoBean bean = new CityInfoBean();
            bean.setProvince_id(c.getInt(c.getColumnIndex(CityKey.PROVINCE_ID)));
            bean.setProvince_name(c.getString(c.getColumnIndex(CityKey.PROVINCE_NAME)));
            bean.setProvince_spell(c.getString(c.getColumnIndex(CityKey.PROVINCE_SPELL)));
            bean.setProvince_logogram(c.getString(c.getColumnIndex(CityKey.PROVINCE_LOGOGRAM)));
            listCity.add(bean);
        }
        return  listCity;
    }

    /**
     * 获取所有的城市列表并且按照城市的拼音排序
     * @return
     */
    public List<CityInfoBean> getAllCity(){
        List<CityInfoBean> listCity = new ArrayList<>();
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Cursor c = db.query(CityKey.TABLE_CITY, null, null, null, null, null, CityKey.CITY_SPELL);
        while (c.moveToNext()){
            CityInfoBean bean = new CityInfoBean();
            bean.setCity_id(c.getInt(c.getColumnIndex(CityKey.CITY_ID)));
            bean.setCity_name(c.getString(c.getColumnIndex(CityKey.CITY_NAME)));
            bean.setCity_spell(c.getString(c.getColumnIndex(CityKey.CITY_SPELL)));
            bean.setCity_logogram(c.getString(c.getColumnIndex(CityKey.CITY_LOGOGRAM)));
            bean.setProvince_id(c.getInt(c.getColumnIndex(CityKey.PROVINCE_ID)));
            listCity.add(bean);
        }

        return listCity;
    }


    /**
     * 模糊查询
     * @param flag
     * @return
     */
    public List<CityInfoBean> selectLike(String flag){

        List<CityInfoBean> list= new ArrayList<>();

        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        String sql1 = "SELECT " +
                "p.province_name, p.province_id, c.city_id, c.city_name " +
                "FROM " +
                CityKey.TABLE_PROVINCE+" AS p" +
                " LEFT JOIN city AS c" +
                " on p.province_id = c.province_id " +
                "where c.city_name like '%"+flag+"%' " +
                "or c.city_spell like '%"+flag+"%' " +
                "or c.city_logogram like '%"+flag+"%' " +
                "ORDER BY c.city_spell";
        Cursor c = db.rawQuery(sql1, null);
        List<CityInfoBean> list1 = new ArrayList<>();
        while (c.moveToNext()){
            CityInfoBean bean = new CityInfoBean();
            bean.setProvince_id(c.getInt(c.getColumnIndex("province_id")));
            bean.setProvince_name(c.getString(c.getColumnIndex("province_name")));
            bean.setCity_name(c.getString(c.getColumnIndex("city_name")));
            bean.setCity_id(c.getInt(c.getColumnIndex("city_id")));
            bean.setSearchMatch(1);
            list1.add(bean);
        }

        String sql2 = "select " +
                "a.city_name, a.city_id,b.county_name " +
                "from " +
                "city as a " +
                "LEFT join county as b " +
                "on a.city_id= b.city_id " +
                "where b.county_name like '%"+flag+"%' " +
                "or b.county_spell like '%"+flag+"%' " +
                "or b.county_logogram like '%"+flag+"%' " +
                "order by b.county_spell";
        Cursor c2 = db.rawQuery(sql2, null);
        List<CityInfoBean> list2 = new ArrayList<>();
        while (c2.moveToNext()){
            CityInfoBean bean = new CityInfoBean();
            bean.setCity_name(c2.getString(c2.getColumnIndex(CityKey.CITY_NAME)));
            bean.setCity_id(c2.getInt(c2.getColumnIndex(CityKey.CITY_ID)));
            bean.setCounty_name(c2.getString(c2.getColumnIndex(CityKey.COUNTY_NAME)));
            bean.setSearchMatch(2);
            list2.add(bean);
        }

        list.addAll(list1);
        list.addAll(list2);
        return list;

    }
}
