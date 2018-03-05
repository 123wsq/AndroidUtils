package com.wsq.library.tools;

/**
 * Created by wsq on 2018/1/11.
 */

public enum  MsgContent {

    ERORR("错误",501), SUCCESS("成功",200);

    private String name;

    private int index;

    private  MsgContent(String name, int index){
        this.name = name;

        this.index = index;

    }


    // 普通方法
    public static String getName(int index) {
        for (MsgContent c : MsgContent.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
