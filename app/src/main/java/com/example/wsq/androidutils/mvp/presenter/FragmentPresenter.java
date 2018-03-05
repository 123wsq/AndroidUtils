package com.example.wsq.androidutils.mvp.presenter;

import com.example.wsq.androidutils.mvp.model.FragmentModel;
import com.example.wsq.androidutils.mvp.model.FragmentModelImpl;
import com.example.wsq.androidutils.mvp.view.FragmentView;

import java.util.List;
import java.util.Map;

/**
 * Created by wsq on 2018/1/24.
 */

public class FragmentPresenter<T extends FragmentView> extends BasePresenter<T>{

    FragmentView view;

    FragmentModel model = new FragmentModelImpl();


    public FragmentPresenter() {

    }


    /**
     * 执行加载数据
     */
    public void fetch(){
        if (weakReference.get() != null){

            if (model != null){
                model.loadData(new FragmentModel.OnDataLoadListener() {
                    @Override
                    public void onComplete(List<Map<String, Object>> list) {
                        if (weakReference.get() != null){
                            weakReference.get().showData(list);
                        }
                    }
                });

            }
        }
    }
}
