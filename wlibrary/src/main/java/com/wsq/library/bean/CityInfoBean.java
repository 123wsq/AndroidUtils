package com.wsq.library.bean;

/**
 * Created by Administrator on 2018/3/7 0007.
 */

public class CityInfoBean {

    /**
     * 省份名称
     */
    String province_name;

    /**
     * 省份拼音
     */
    String province_spell;

    /**
     * 省份简拼
     */
    String province_logogram;

    /**
     * 省份ID
     */
    int province_id;

    /**
     * 城市名称
     */
    String city_name;

    /**
     * 城市拼音
     */
    String city_spell;

    /**
     * 城市简拼
     */
    String  city_logogram;

    /**
     * 城市ID
     */
    int city_id;

    /**
     * 县，区名称
     */
    String county_name;

    /**
     * 县 区 拼音
     */
    String county_spell;

    /**
     * 县 区简拼
     */
    String county_logogram;

    /**
     * 搜索匹配  1 表示按照城市匹配  2表示按照 县区
     */
    int searchMatch;


    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getProvince_spell() {
        return province_spell;
    }

    public void setProvince_spell(String province_spell) {
        this.province_spell = province_spell;
    }

    public String getProvince_logogram() {
        return province_logogram;
    }

    public void setProvince_logogram(String province_logogram) {
        this.province_logogram = province_logogram;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_spell() {
        return city_spell;
    }

    public void setCity_spell(String city_spell) {
        this.city_spell = city_spell;
    }

    public String getCity_logogram() {
        return city_logogram;
    }

    public void setCity_logogram(String city_logogram) {
        this.city_logogram = city_logogram;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCounty_name() {
        return county_name;
    }

    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    public String getCounty_spell() {
        return county_spell;
    }

    public void setCounty_spell(String county_spell) {
        this.county_spell = county_spell;
    }

    public String getCounty_logogram() {
        return county_logogram;
    }

    public void setCounty_logogram(String county_logogram) {
        this.county_logogram = county_logogram;
    }

    public int getSearchMatch() {
        return searchMatch;
    }

    public void setSearchMatch(int searchMatch) {
        this.searchMatch = searchMatch;
    }
}
