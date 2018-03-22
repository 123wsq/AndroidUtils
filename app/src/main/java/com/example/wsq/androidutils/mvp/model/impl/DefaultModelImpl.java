package com.example.wsq.androidutils.mvp.model.impl;

import com.example.wsq.androidutils.mvp.callback.Callback;
import com.example.wsq.androidutils.mvp.model.inter.DefaultModelInter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public class DefaultModelImpl implements DefaultModelInter {
    @Override
    public void showData(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("RecycView");
        list.add("水印");
        list.add("索引");
        list.add("城市");
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showTwoData(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("多媒体");
        list.add("数据验证");
        list.add("动画");
        list.add("反射");
        list.add("设计模式");
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showThreeData(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("金额");
        list.add("AlertDialog");
        list.add("输入框");
        list.add("轮播图");
        list.add("数据库");
        list.add("图片加载");
        list.add("刷新");
        list.add("自定义控件");
        list.add("Canvas Bitmap 交集");
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showDialogData(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("单个按钮");
        list.add("求返回值");
        list.add("两个按钮");
        list.add("两返回值");
        list.add("标题颜色");
        list.add("内容颜色");
        list.add("按钮颜色");
        list.add("按钮背景色");
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showMediaData(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("相册");
        list.add("拍照");
        list.add("视频");
        list.add("录像");
        list.add("录音");
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showBannerUrl(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2544901221,691859493&fm=27&gp=0.jpg");
        list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1425206197,1352610685&fm=27&gp=0.jpg");
        list.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4057540460,4253495961&fm=27&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=960958117,1709091495&fm=27&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=2835349020,3131503447&fm=27&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=4143164941,205697488&fm=27&gp=0.jpg");
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showSqlite(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("新增");
        list.add("删除");
        list.add("修改");
        list.add("查看");
        list.add("清空");
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showRefreshData(Callback<List<String>> callback) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("这个是第 " +i+" 个数据");
        }
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showValidateData(Callback<List<String>> callback) {

        List<String> list = new ArrayList<>();
        list.add("数字");
        list.add("身份证号码");
        list.add("银行卡号");
        list.add("邮箱");
        list.add("权限");
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showDesignPatternData(Callback<List<String>> callback) {

        List<String> list = new ArrayList<>();
        list.add("单例模式");
        list.add("抽象工厂模式");
        list.add("工厂模式");
        list.add("原型模式");
        list.add("建造者模式");
        list.add("适配器模式");
        list.add("桥接模式");
        list.add("装饰模式");
        list.add("组合模式");
        list.add("外观模式");
        list.add("享元模式");
        list.add("代理模式");
        list.add("观察者模式");
        list.add("中介者模式");
        list.add("访问者模式");
        list.add("解释器模式");
        list.add("迭代器模式");
        list.add("备忘录模式");
        list.add("责任链模式");
        list.add("状态模式");
        list.add("策略模式");
        list.add("命令模式");
        list.add("模板模式");
        callback.onSuccess(list);
        callback.onComplete();
    }
}
