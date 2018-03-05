package com.example.wsq.androidutils.constance;

/**
 * Created by wsq on 2018/1/18.
 */

public enum  ErrorCode {


    EX_90000("EX_90000","系统内部异常", 1),
    EX_S0001( "EX_S0001", "SharedPrefrece 没有初始化", 2);




    private String code;
    private String msg;
    private int index;


    private  ErrorCode(String code, String msg, int index){
        this.msg = msg;
        this.code = code;
        this.index = index;

    }


    // 获取msg
    public static String getName(int index) {
        for (ErrorCode c : ErrorCode.values()) {
            if (c.getIndex() == index) {
                return c.msg;
            }
        }
        return null;
    }

    // 获取msg
    public static String getCode(int index) {
        for (ErrorCode c : ErrorCode.values()) {
            if (c.getIndex() == index) {
                return c.code;
            }
        }
        return null;
    }

    /**
     * 通过index获取对象
     * @param index
     * @return
     */
    public static ErrorCode getType(int index){
        for (ErrorCode c : ErrorCode.values()) {
            if (c.getIndex() == index) {
                return c;
            }
        }
        return null;
    }

    // get set 方法
    public String getCode() {
        return code;
    }
    // get set 方法
    public String getMsg() {
        return msg;
    }
    public void setName(String msg) {
        this.msg = msg;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
