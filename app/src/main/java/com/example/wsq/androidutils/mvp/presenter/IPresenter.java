package com.example.wsq.androidutils.mvp.presenter;

import com.example.wsq.androidutils.mvp.model.IModel;
import com.example.wsq.androidutils.mvp.model.IModelImpl;
import com.example.wsq.androidutils.mvp.view.IView;

import java.util.List;
import java.util.Map;

/**
 * 表示层
 * Created by wsq on 2018/1/17.
 */

public class IPresenter<T extends IView> extends BasePresenter<T>{

    //1. View层的引用
    IView view;


    //2. Model的引用
    IModel model = new IModelImpl();

    //3  构造函数
    public IPresenter() {

    }



    //4 获取数据,执行UI逻辑
    public void fetch(){
        if (weakReference.get() != null){
            weakReference.get().showLoadding();

            if (model != null){
                model.loadData(new IModel.OnDataLoadListener() {
                    @Override
                    public void onComplete(List<Map<String, Object>> list) {
                        if (weakReference.get() != null){
                            weakReference.get().showData(list);
                        }

                        weakReference.get().dimissLodding();
                    }
                });
            }
        }
    }
}
