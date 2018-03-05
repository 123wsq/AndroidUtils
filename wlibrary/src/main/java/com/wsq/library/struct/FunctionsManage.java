package com.wsq.library.struct;

import android.text.TextUtils;

import com.wsq.library.exception.ErrorCode;
import com.wsq.library.exception.WException;

import java.util.HashMap;

/**
 * Created by wsq on 2018/1/19.
 */

public  class FunctionsManage {

    private static FunctionsManage mFunctionsManage;

    private HashMap<String, FunctionNoParamNoResult> mFunctionNoParamNoResult;
    private HashMap<String, FunctionWithParamOnly> mFunctionWithParamOnly;
    private HashMap<String, FunctionWithResultOnly> mFunctionWithResultOnly;
    private HashMap<String, FunctionWithParamAndResult> mFunctionWithParamAndResult;


    public FunctionsManage(){

        mFunctionNoParamNoResult = new HashMap<>();
        mFunctionWithParamOnly = new HashMap<>();
        mFunctionWithResultOnly = new HashMap<>();
        mFunctionWithParamAndResult = new HashMap<>();
    }

    public static FunctionsManage getInstance(){

        if (mFunctionsManage == null){
            mFunctionsManage = new FunctionsManage();
        }
        return mFunctionsManage;
    }


    /**
     * 添加一个没参数也没有返回值
     * @param function
     * @return
     */
    public FunctionsManage addFunction(FunctionNoParamNoResult function){

        mFunctionNoParamNoResult.put(function.mFunctionName, function);
        return this;
    }

    /**
     * 执行没有返回值没有参数
     * @param functionName
     */
    public void invokeFunction(String functionName){

        if (TextUtils.isEmpty(functionName)){
            try {
                throw  new WException(ErrorCode.EX_F0002.getCode(), ErrorCode.EX_F0002.getMsg()+" : "+functionName);
            } catch (WException e) {
                e.printStackTrace();
            }
            return;
        }
        if (mFunctionNoParamNoResult != null){

            FunctionNoParamNoResult f = mFunctionNoParamNoResult.get(functionName);
            if (f != null){
                f.function();
            }
        }else {
            try {
                throw new WException(ErrorCode.EX_F0001.getCode(), ErrorCode.EX_F0001.getMsg()+": "+functionName);
            } catch (WException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 添加一个只有参数的接口
     * @param function
     * @return
     */
    public FunctionsManage addFunction(FunctionWithParamOnly function){

        mFunctionWithParamOnly.put(function.mFunctionName, function);
        return this;
    }

    /**
     * 执行只有参数的接口
     * @param functionName
     */
    public <Param> void invokeFunction(String functionName, Param param){

        if (TextUtils.isEmpty(functionName)){
            try {
                throw  new WException(ErrorCode.EX_F0002.getCode(), ErrorCode.EX_F0002.getMsg()+" : "+functionName);
            } catch (WException e) {
                e.printStackTrace();
            }
            return;
        }
        if (mFunctionWithParamOnly != null){

            FunctionWithParamOnly f = mFunctionWithParamOnly.get(functionName);
            if (f != null){
                if (param != null){
                    f.function(param);
                }

            }
        }else {
            try {
                throw new WException(ErrorCode.EX_F0001.getCode(), ErrorCode.EX_F0001.getMsg()+": "+functionName);
            } catch (WException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 添加一个只有返回值的接口
     * @param function
     * @return
     */
    public FunctionsManage addFunction(FunctionWithResultOnly function){

        mFunctionWithResultOnly.put(function.mFunctionName, function);
        return this;
    }

    /**
     * 执行只有返回值的接口
     * @param functionName
     */
    public <Result> Result invokeFunction(String functionName, Class<Result> c){

        if (TextUtils.isEmpty(functionName)){
            try {
                throw  new WException(ErrorCode.EX_F0002.getCode(), ErrorCode.EX_F0002.getMsg()+" : "+functionName);
            } catch (WException e) {
                e.printStackTrace();
            }
            return null;
        }
        if (mFunctionWithParamOnly != null){

            FunctionWithResultOnly f = mFunctionWithResultOnly.get(functionName);
            if (f != null){
                if (c != null){
                    return c.cast(f.function());
                }else {
                    return (Result) f.function();
                }
            }else {
                try {
                    throw new WException(ErrorCode.EX_F0001.getCode(), ErrorCode.EX_F0001.getMsg()+": "+functionName);
                } catch (WException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }



    /**
     * 添加一个有参数有返回值的接口
     * @param function
     * @return
     */
    public FunctionsManage addFunction(FunctionWithParamAndResult function){

        mFunctionWithParamAndResult.put(function.mFunctionName, function);
        return this;
    }

    /**
     * 执行有参有返回值的接口
     * @param functionName
     */
    public <Result, Param> Result invokeFunction(String functionName, Param param,  Class<Result> result){

        if (TextUtils.isEmpty(functionName)){
            try {
                throw  new WException(ErrorCode.EX_F0002.getCode(), ErrorCode.EX_F0002.getMsg()+" : "+functionName);
            } catch (WException e) {
                e.printStackTrace();
            }
            return null;
        }
        if (mFunctionWithParamOnly != null){

            FunctionWithParamAndResult f = mFunctionWithParamAndResult.get(functionName);
            if (f != null){
                if (result != null){
                    return result.cast(f.function(param));
                }else {
                    return (Result) f.function(param);
                }
            }else {
                try {
                    throw new WException(ErrorCode.EX_F0001.getCode(), ErrorCode.EX_F0001.getMsg()+": "+functionName);
                } catch (WException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
