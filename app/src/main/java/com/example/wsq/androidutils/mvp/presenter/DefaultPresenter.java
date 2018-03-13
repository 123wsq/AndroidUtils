package com.example.wsq.androidutils.mvp.presenter;

import com.example.wsq.androidutils.mvp.callback.Callback;
import com.example.wsq.androidutils.mvp.model.impl.CityModelImpl;
import com.example.wsq.androidutils.mvp.model.impl.DefaultModelImpl;
import com.example.wsq.androidutils.mvp.model.inter.CityModelinter;
import com.example.wsq.androidutils.mvp.model.inter.DefaultModelInter;
import com.example.wsq.androidutils.mvp.view.BaseView;
import com.example.wsq.androidutils.mvp.view.DefaultView;

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
}
