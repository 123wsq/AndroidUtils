package com.example.wsq.androidutils.mvp.presenter;

import com.example.wsq.androidutils.mvp.model.BaseModel;
import com.example.wsq.androidutils.mvp.model.BaseModelImpl;
import com.example.wsq.androidutils.mvp.view.BaseView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

public class DataLoadPresenter<T extends BaseView> extends  BasePresenter<T>{


    BaseModel baseModel = new BaseModelImpl();


    public DataLoadPresenter(){

    }


    /**
     * 开始执行加载数据
     */
    public void fetch(){


        if (weakReference.get() != null){
            weakReference.get().showLoadding();

            if (baseModel != null){

                String Url = "";
                Map<String, String> map = new HashMap<>();

                baseModel.loadHttpData(Url, map, new BaseModel.OnDataLoadListener() {
                    @Override
                    public void onComplete(Map<String, Object> map) {
                        if (weakReference.get() != null){

                            weakReference.get().showData(map);
                        }
                        weakReference.get().dismissLoadding();

                    }

                    @Override
                    public void onLoadError(String errorCode, String errorMsg) {
                        if (weakReference.get() != null){
                            weakReference.get().loadFail(errorMsg);
                        }
                        weakReference.get().dismissLoadding();
                    }
                });
            }
        }
    }


}
