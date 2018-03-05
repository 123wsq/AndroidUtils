package com.wsq.library.exception;

/**
 * Created by wsq on 2018/1/18.
 */

public enum ErrorCode {


    EX_90000("EX_90000","系统内部异常", 1),
    EX_S0001( "EX_S0001", "SharedPrefrece 没有初始化", 2),
    EX_F0001( "EX_F0001", "Function为空", 3),
    EX_F0002( "EX_F0002", "函数名称为空", 4),
    EX_H0001( "EX_H0001", "请求失败", 5),
    EX_H0002( "EX_H0002", "参数异常", 6),
    EX_H0003( "EX_H0003", "账号不存在", 7),
    EX_H0004( "EX_H0004", "账号或密码错误", 8),
    EX_H0005( "EX_H0005", "账号已注销", 9),
    EX_H0006( "EX_H0006", "返回参数格式异常", 10);




    private String code;
    private String msg;
    private int index;


    private ErrorCode(String code, String msg, int index){
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
