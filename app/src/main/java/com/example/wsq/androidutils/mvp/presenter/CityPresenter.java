package com.example.wsq.androidutils.mvp.presenter;

import com.example.wsq.androidutils.mvp.callback.Callback;
import com.example.wsq.androidutils.mvp.model.impl.CityModelImpl;
import com.example.wsq.androidutils.mvp.model.inter.CityModelinter;
import com.example.wsq.androidutils.mvp.view.BaseView;
import com.example.wsq.androidutils.mvp.view.CityView;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.wsq.library.bean.CityInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public class CityPresenter<T extends BaseView> extends BasePresenter<T>{

    private CityModelinter cityModel;
    public CityPresenter(){
        cityModel = new CityModelImpl();
    }

    public void getAllCity() throws Exception{
        final CityView view = (CityView) getView();

        if (view!= null){
            view.showLoadding();

            if (cityModel != null){
                cityModel.loadAllCity(view.getContext(), new Callback<List<CityInfoBean>>() {
                    @Override
                    public void onSuccess(List<CityInfoBean> data) {
                        view.showAllCity(data);
                    }

                    @Override
                    public void onFailure(String msg) {
                        view.loadFail(msg);
                    }

                    @Override
                    public void onError() {

                    }

                    @Override
                    public void onComplete() {

                        view.dismissLoadding();
                    }
                });
            }

        }
    }

    public void searchLikeCity(String like) throws Exception{
        final CityView view = (CityView) getView();
        if (view!= null){
            view.showLoadding();
            if (cityModel != null){
                cityModel.searchCity(view.getContext(), like, new Callback<List<CityInfoBean>>() {
                    @Override
                    public void onSuccess(List<CityInfoBean> data) {
                        view.showAllCity(data);

                    }

                    @Override
                    public void onFailure(String msg) {

                    }

                    @Override
                    public void onError() {

                    }

                    @Override
                    public void onComplete() {
                        view.dismissLoadding();
                    }
                });
            }
        }
    }

}
