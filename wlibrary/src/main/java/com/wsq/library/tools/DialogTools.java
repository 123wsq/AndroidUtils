package com.wsq.library.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

import com.wsq.library.views.alertdialog.CustomDefaultDialog;
import com.wsq.library.views.alertdialog.OnDialogClickListener;

/**
 * Created by Administrator on 2018/3/15 0015.
 */

public class DialogTools {

    private DialogTools(){

    }


    /**
     * 显示一个按钮的对话框
     * @param context
     * @param okStr
     * @param title
     * @param msg
     * @param okListener
     * @return
     */
    public static CustomDefaultDialog showDialog(Context context, String okStr, String title, String msg,
                                                 DialogInterface.OnClickListener okListener){

        return  showDialog(context, okStr, "", title, msg,okListener, null);
    }
    /**
     * 显示两个按钮的对话框
     * @param context
     * @param okStr
     * @param cancelStr
     * @param title
     * @param msg
     * @param okListener
     * @param cancelListener
     * @return
     */
    public static CustomDefaultDialog showDialog(Context context, String okStr, String cancelStr, String title, String msg,
                                                 DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener){

        return showDialog(context, okStr, cancelStr, title,  msg, "", "","", "", "", "", "", "",
                "", true, false, false, okListener, cancelListener, null);
    }

    /**
     *  显示一个带输入框的dialog
     * @param context
     * @param okStr
     * @param title
     * @param msg
     * @param isShowMsg
     * @return
     */
    public static CustomDefaultDialog showDialog(Context context, String okStr, String title, String msg, boolean isShowMsg,
                                                 OnDialogClickListener listener){

        return showDialog(context, okStr, "", title, msg, isShowMsg, listener, null);
    }

    /**
     * 带两个按钮的输入框
     * @param context
     * @param okStr
     * @param cancelStr
     * @param title
     * @param msg
     * @param isShowMsg
     * @param listener
     * @param cancelListener
     * @return
     */
    public static CustomDefaultDialog showDialog(Context context, String okStr, String cancelStr, String title, String msg, boolean isShowMsg,
                                                 OnDialogClickListener listener, DialogInterface.OnClickListener cancelListener){

        return showDialog(context, okStr, cancelStr, title,  msg, "", "","", "", "", "", "", "",
                "", isShowMsg, true, false, null, cancelListener, listener);
    }


    /**
     * 修改标题颜色，只是显示一个按钮
     * @param context
     * @param okStr
     * @param title
     * @param msg
     * @param titleColor
     * @param listener
     * @return
     */
    public static CustomDefaultDialog showDialog(Context context, String okStr, String title, String msg, String titleColor,
                                                 DialogInterface.OnClickListener listener){

        return showDialog(context, okStr , title,  msg, titleColor, "", listener);
    }


    /**
     * 修改标题内容颜色
     * @param context
     * @param okStr
     * @param title
     * @param msg
     * @param titleColor
     * @param msgColor
     * @param listener
     * @return
     */
    public static CustomDefaultDialog showDialog(Context context, String okStr,  String title, String msg, String titleColor,
                                                 String msgColor,
                                                 DialogInterface.OnClickListener listener){

        return showDialog(context, okStr, title,  msg, titleColor, msgColor, "", "", listener);
    }

    /**
     * 修改标题 内容 按钮字体颜色
     * @param context
     * @param okStr
     * @param title
     * @param msg
     * @param titleColor
     * @param msgColor
     * @param okColor
     * @param cancelColor
     * @param listener
     * @return
     */
    public static CustomDefaultDialog showDialog(Context context, String okStr, String title, String msg, String titleColor,
                                                 String msgColor,String okColor, String cancelColor,
                                                 DialogInterface.OnClickListener listener){

        return showDialog(context, okStr, title,  msg, titleColor, msgColor,okColor, cancelColor,"", "",  listener);
    }

    /**
     * 修改标题 内容 按钮字体颜色和按钮背景色
     * @param context
     * @param okStr
     * @param title
     * @param msg
     * @param titleColor
     * @param msgColor
     * @param okColor
     * @param cancelColor
     * @param okBackgroundColor
     * @param cancelBackgroundColor
     * @param listener
     * @return
     */
    public static CustomDefaultDialog showDialog(Context context, String okStr,   String title, String msg, String titleColor,
                                                 String msgColor,String okColor, String cancelColor,String okBackgroundColor, String cancelBackgroundColor,
                                                 DialogInterface.OnClickListener listener){

        return showDialog(context, okStr, "", title,  msg, titleColor, msgColor,okColor, cancelColor, okBackgroundColor, cancelBackgroundColor,  "", "", "", listener);
    }


    /**
     * 两个按钮
     * @param context
     * @param okStr
     * @param cancelStr
     * @param title
     * @param msg
     * @param titleColor
     * @param msgColor
     * @param okColor
     * @param cancelColor
     * @param okBackgroundColor
     * @param cancelBackgroundColor
     * @param OkListener
     * @param cancelListener
     * @return
     */
    public static CustomDefaultDialog showDialog(Context context, String okStr, String cancelStr, String title, String msg,
                                                 String titleColor, String msgColor, String okColor, String cancelColor, String okBackgroundColor, String cancelBackgroundColor,
                                                 DialogInterface.OnClickListener OkListener, DialogInterface.OnClickListener cancelListener){

        return showDialog(context, okStr, cancelStr, title,  msg, titleColor, msgColor,okColor, cancelColor, okBackgroundColor, cancelBackgroundColor, "", "",
                "", true, false, false, OkListener, cancelListener, null);
    }

    /**
     * 修改所有字体颜色
     * @param context
     * @param okStr
     * @param cancelStr
     * @param title
     * @param msg
     * @param titleColor
     * @param msgColor
     * @param okColor
     * @param cancelColor
     * @param okBackgroundColor
     * @param cancelBackgroundColor
     * @param hintMsg
     * @param hintColor
     * @param inputMsg
     * @param listener
     * @return
     */
    public static CustomDefaultDialog showDialog(Context context, String okStr, String cancelStr, String title, String msg,
                                                 String titleColor, String msgColor, String okColor, String cancelColor, String okBackgroundColor, String cancelBackgroundColor,
                                                 String hintMsg, String hintColor, String inputMsg,
                                                 DialogInterface.OnClickListener listener){

        return showDialog(context, okStr, "", title,  msg, titleColor, msgColor,okColor, cancelColor, okBackgroundColor, cancelBackgroundColor, hintMsg, hintColor,
                inputMsg, true, false, false, listener, null, null);
    }
    /**
     *
     * @param context
     * @param okStr                         确定按钮
     * @param cancelStr                     取消按钮
     * @param title                         标题
     * @param msg                           内容
     * @param titleColor                    标题颜色
     * @param msgColor                      内容颜色
     * @param okBtnFontColor                确定按钮字体颜色
     * @param cancelBtnFontColor            取消按钮字体颜色
     * @param okBtnBackgroundColor          确定按钮背景色
     * @param cancelBtnBackgroundColor      取消按钮背景色
     * @param hintMsg                       输入框提示
     * @param hintColor                     输入框提示颜色
     * @param inputMsg                      输入框内容
     * @param isShowMsg                     是否显示内容， 默认是 true
     * @param isInputShow                   是否显示输入框 默认是 false
     * @param isShowColse                   是否显示关闭按钮 默认是 false
     * @param okListener                    确定按钮事件监听
     * @param cancelListener                取消按钮的事件监听
     * @param resultListener                返回值监听
     * @return
     */
    public static CustomDefaultDialog showDialog(Context context, String okStr, String cancelStr, String title, String msg, String titleColor, String msgColor,
                                                 String okBtnFontColor, String cancelBtnFontColor, String okBtnBackgroundColor, String cancelBtnBackgroundColor,
                                                 String hintMsg, String hintColor, String inputMsg, boolean isShowMsg, boolean isInputShow, boolean isShowColse,
                                                 DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener, OnDialogClickListener resultListener){
        CustomDefaultDialog.Builder builder = new CustomDefaultDialog.Builder(context);
        if (!TextUtils.isEmpty(okStr) && okListener != null){
            builder.setOkBtn(okStr, okListener);
        }
        if (!TextUtils.isEmpty(cancelStr) && cancelListener != null){
            builder.setCancelBtn(cancelStr, cancelListener);
        }
        if (!TextUtils.isEmpty(okStr) && resultListener != null){
            builder.setOkBtn(okStr, resultListener);
        }
        builder.setIsShowInput(isInputShow);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setShowMessage(isShowMsg);
        builder.setShowCloseDialog(isShowColse);
        if (!TextUtils.isEmpty(titleColor)) builder.setTitleColor(titleColor);
        if (!TextUtils.isEmpty(msgColor)) builder.setMessageColor(msgColor);
        if (!TextUtils.isEmpty(hintColor)) builder.setInputHintColor(hintColor);
        if (!TextUtils.isEmpty(hintMsg)) builder.setHintMsg(hintMsg);
        if (!TextUtils.isEmpty(inputMsg)) builder.setHintMsg(inputMsg);
        if (!TextUtils.isEmpty(okBtnFontColor)) builder.setOkBtnColor(okBtnFontColor);
        if (!TextUtils.isEmpty(cancelBtnFontColor)) builder.setCancelBtnColor(cancelBtnFontColor);
        if (!TextUtils.isEmpty(okBtnBackgroundColor)) builder.setOkBtnBackgroundColor(okBtnBackgroundColor);
        if (!TextUtils.isEmpty(cancelBtnBackgroundColor)) builder.setCancelBtnbackgroundColor(cancelBtnBackgroundColor);


        CustomDefaultDialog defaultDialog = builder.create();
        defaultDialog.show();
        return defaultDialog;
    }
}
