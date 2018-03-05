package com.example.wsq.androidutils.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wsq.androidutils.activity.MainActivity;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.orhanobut.logger.Logger;
import com.wsq.library.struct.FunctionsManage;


import butterknife.ButterKnife;

public abstract class BaseFragment<V, T extends BasePresenter<V >> extends Fragment {


    public String _INTERFACE_NPNR = "_NPNR";  //没参数没有返回值
    public String _INTERFACE_WITHP = "_WITHP";  //只有参数
    public String _INTERFACE_WITHR = "_WITHR";  //只有返回值
    public String _INTERFACE_WITHPR = "_WITHPR";  //有参数有返回值


    public FunctionsManage mFunctionsManage;
    protected T ipresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view  = inflater.inflate(getLayoutId(), container, false);

        ipresenter = createPresenter();
        if (ipresenter != null) {
            ipresenter.attachView((V) this);
        }
        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    protected  abstract T createPresenter();

    protected abstract int getLayoutId();

    protected abstract void initView();


    public void setFunctionsManager(FunctionsManage functionsManager){

        this.mFunctionsManage = functionsManager;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            MainActivity mBaseActivity = (MainActivity) context;

            try {
                if (getTag() != null)
                mBaseActivity.setFunctionsForFragment(getTag());
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (ipresenter != null) {
            ipresenter.deachView();
        }
    }
}
