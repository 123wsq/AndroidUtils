package com.wsq.library.bean;

/**
 * Created by Administrator on 2018/3/7 0007.
 */

public class CityInfoBean {

    int Id;

    /**
     * 与上一级关联
     */
    int parent_id;


    /**
     * 名称
     */
    String name;

    /**
     * 与下一级关联
     */
    String  priority;

    /**
     * 拼音
     */
    String spell;

    /**
     * 简拼
     */
    String logogram;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getLogogram() {
        return logogram;
    }

    public void setLogogram(String logogram) {
        this.logogram = logogram;
    }


    @Override
    public String toString() {
        return "CityInfoBean: [ Id="+Id+", parent_id= "+parent_id+", name="+name+"," +
                " priority="+priority+", spell="+spell+", logogram="+logogram+"]";
    }
}
