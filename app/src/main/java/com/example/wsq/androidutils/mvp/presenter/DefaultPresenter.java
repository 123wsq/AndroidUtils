package com.example.wsq.androidutils.mvp.presenter;

import com.example.wsq.androidutils.mvp.callback.Callback;
import com.example.wsq.androidutils.mvp.model.impl.CityModelImpl;
import com.example.wsq.androidutils.mvp.model.impl.DefaultModelImpl;
import com.example.wsq.androidutils.mvp.model.inter.CityModelinter;
import com.example.wsq.androidutils.mvp.model.inter.DefaultModelInter;
import com.example.wsq.androidutils.mvp.view.BaseView;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.example.wsq.androidutils.mvp.view.WaveIndexView;
import com.wsq.library.bean.CityInfoBean;
import com.wsq.library.tools.ToastUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public class DefaultPresenter<T extends BaseView> extends BasePresenter<T> {

    private DefaultModelInter defaultModel;
    public DefaultPresenter() {
        defaultModel = new DefaultModelImpl();
    }

    public void showData(){
        final DefaultView view = (DefaultView) getView();
        if (view!=null){
            defaultModel.showData(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {

                }

                @Override
                public void onError() {

                }

                @Override
                public void onComplete() {

                }
            });
        }
    }

    /**
     * Fragment2 显示数据
     */
    public void showTwoData(){
        final DefaultView view = (DefaultView) getView();
        if (view!=null){
            defaultModel.showTwoData(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {

                }

                @Override
                public void onError() {

                }

                @Override
                public void onComplete() {

                }
            });
        }
    }

    /**
     * Fragment3 显示数据
     */
    public void showthreeData(){
        final DefaultView view = (DefaultView) getView();
        if (view!=null){
            defaultModel.showThreeData(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {

                }

                @Override
                public void onError() {

                }

                @Override
                public void onComplete() {

                }
            });
        }
    }

    /**
     * Dialog数据
     */
    public void showDialogData(){
        final DefaultView view = (DefaultView) getView();
        if (view!=null){
            defaultModel.showDialogData(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {

                }

                @Override
                public void onError() {

                }

                @Override
                public void onComplete() {

                }
            });
        }
    }

    /**
     * 多媒体显示数据
     */
    public void showMediaData(){
        final DefaultView view = (DefaultView) getView();
        if (view!=null){
            defaultModel.showMediaData(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {

                }

                @Override
                public void onError() {

                }

                @Override
                public void onComplete() {

                }
            });
        }
    }

    /**
     * 轮播图图片地址
     */
    public void showBannerData(){
        final DefaultView view = (DefaultView) getView();
        if (view!=null){
            defaultModel.showBannerUrl(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {

                }

                @Override
                public void onError() {

                }

                @Override
                public void onComplete() {

                }
            });
        }
    }

    /**
     * 数据库操作
     */
    public void showDbData(){
        final DefaultView view = (DefaultView) getView();
        if (view!=null){
            defaultModel.showSqlite(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {

                }

                @Override

                public void onError() {

                }


                @Override
                public void onComplete() {

                }
            });
        }
    }

    /**
     * 刷新
     */
    public void showRefreshData(){
        final DefaultView view = (DefaultView) getView();
        if (view != null){
            defaultModel.showRefreshData(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {
                    ToastUtils.onToast(msg);
                }

                @Override

                public void onError() {
                    ToastUtils.onToast("加载错误");
                }


                @Override
                public void onComplete() {

                }
            });
        }
    }

    /**
     * 数据验证
     */
    public void showValidateData(){
        final DefaultView view = (DefaultView) getView();
        if (view != null){
            defaultModel.showValidateData(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {
                    ToastUtils.onToast(msg);
                }

                @Override

                public void onError() {
                    ToastUtils.onToast("加载错误");
                }


                @Override
                public void onComplete() {

                }
            });
        }
    }

    /**
     * 设计模式
     */
    public void showDesignPatternData(){
        final DefaultView view = (DefaultView) getView();
        if (view != null){
            defaultModel.showDesignPatternData(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {
                    ToastUtils.onToast(msg);
                }

                @Override

                public void onError() {
                    ToastUtils.onToast("加载错误");
                }


                @Override
                public void onComplete() {

                }
            });
        }
    }


    /**
     * 工具类
     */
    public void showUtilsClassData(){
        final DefaultView view = (DefaultView) getView();
        if (view != null){
            defaultModel.showUtilsClass(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {
                    ToastUtils.onToast(msg);
                }

                @Override

                public void onError() {
                    ToastUtils.onToast("加载错误");
                }


                @Override
                public void onComplete() {

                }
            });
        }
    }

    /**
     * app
     */
    public void showAppManagerData(){
        final DefaultView view = (DefaultView) getView();
        if (view != null){
            defaultModel.showAppManagerValidate(new Callback<List<String>>() {
                @Override
                public void onSuccess(List<String> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {
                    ToastUtils.onToast(msg);
                }

                @Override

                public void onError() {
                    ToastUtils.onToast("加载错误");
                }


                @Override
                public void onComplete() {

                }
            });
        }
    }

    public void showIndexData(){
        final WaveIndexView view = (WaveIndexView) getView();
        if (view != null){
            defaultModel.onShowIndexBar(new Callback<List<CityInfoBean>>() {
                @Override
                public void onSuccess(List<CityInfoBean> data) {
                    view.showData(data);
                }

                @Override
                public void onFailure(String msg) {
                    ToastUtils.onToast(msg);
                }

                @Override

                public void onError() {
                    ToastUtils.onToast("加载错误");
                }


                @Override
                public void onComplete() {

                }
            });
        }
    }
}
