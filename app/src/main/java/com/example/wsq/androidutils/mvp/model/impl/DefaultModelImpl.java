package com.example.wsq.androidutils.mvp.model.impl;

import com.example.wsq.androidutils.mvp.callback.Callback;
import com.example.wsq.androidutils.mvp.model.inter.DefaultModelInter;
import com.wsq.library.bean.CityInfoBean;
import com.wsq.library.utils.PinyinUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public class DefaultModelImpl implements DefaultModelInter {
    @Override
    public void showData(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("瀑布流");
        list.add("水印");
        list.add("索引");
        list.add("城市");
        list.add("Utils验证");
        list.add("万能接口");
        list.add("水纹");
        list.add("夜间模式切换");
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
        list.add("PopupWindow");
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

    @Override
    public void showUtilsClass(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("金额");
        list.add("app");
        list.add("银行卡");
        list.add("状态栏");
        list.add("缓存");
        list.add("转换");
        list.add("单位转换");
        list.add("设备信息");
        list.add("编码");
        list.add("加密");
        list.add("文件流");
        list.add("文件大小");
        list.add("文件");
        list.add("身份证");
        list.add("image");
        list.add("Intent");
        list.add("键盘");
        list.add("网络");
        list.add("对象");
        list.add("参数验证");
        list.add("strFormat Map");
        list.add("权限");
        list.add("手机");
        list.add("进程");
        list.add("反射");
        list.add("正则");
        list.add("屏幕大小");
        list.add("SD卡");
        list.add("服务");
        list.add("shell");
        list.add("字符串");
        list.add("时间");
        list.add("Unicode");
        list.add("Shared");
        list.add("zip");
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void showAppManagerValidate(Callback<List<String>> callback) {
        List<String> list = new ArrayList<>();
        list.add("应用版本号");
        list.add("应用名称");
        list.add("启动activity");
        list.add("启动Fragment");
        list.add("读取 assets 文件内容");
        list.add("判断 App 是否安装");
        list.add("安装 App(支持 8.0)");
        list.add("静默安装 App");
        list.add("卸载 App");
        list.add("静默卸载 App");
        list.add("App 是否有 root 权限");
        list.add("打开 App");
        list.add("关闭 App");
        list.add("获取 App 包名");
        list.add("获取 App 具体设置");
        list.add(" 获取 App 名称");
        list.add("获取 App 图标");
        list.add(" 获取 App 路径");
        list.add("获取 App 版本号");
        list.add("获取 App 版本码");
        list.add("判断 App 是否是系统应用");
        list.add("判断 App 是否是 Debug 版本");
        list.add("获取 App 签名");
        list.add("获取应用签名的的 SHA1 值");
        list.add("判断 App 是否处于前台");
        list.add("获取 App 信息");
        list.add("获取所有已安装 App 信息");
        list.add("清除 App 所有数据");
        list.add("获取缓存大小");
        list.add("清空所有缓存");
        list.add("获取文件");

        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void onShowIndexBar(Callback<List<CityInfoBean>> callback) {
        String[] str = {"裘","豆","李","莎","动","力","火","车","伍","佰","蔡","依","林","戚","薇","齐","期","浩","二","天","大","圣","品","冠","吴","克","群","贲","素","琴","缪","丝","成","龙","汪","峰"};
        List<CityInfoBean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            int index  = random.nextInt(str.length);
            int index2 = random.nextInt(str.length);
            int index3 = random.nextInt(str.length);
            CityInfoBean bean = new CityInfoBean();
            String city_name = str[index] + str[index2] + str[index3];
            //汉字转换成拼音
            String pinyin = PinyinUtils.getPingYin(city_name);

            String sortString = pinyin.substring(0, 1).toUpperCase();



            list.add(bean);
        }
        callback.onSuccess(list);
        callback.onComplete();
    }

    @Override
    public void onWaterFallData(Callback<List<Map<String, Object>>> callback) {

        List<Map<String, Object>> data = new ArrayList<>();

        for (int i = 0; i < 50; i++) {

            Map<String, Object> map = new HashMap<>();
            map.put("title","百度图片使用世界前沿的人工智能技术,为用户甄选海量的高清美图,用更流畅、更快捷、更精准的搜索体验,带你去发现多彩的世界。");
            map.put("url", "http://www.taopic.com/uploads/allimg/140320/235013-14032020515270.jpg");
            data.add(map);
        }

        callback.onSuccess(data);
        callback.onComplete();

    }


}
