package com.example.wsq.androidutils.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.wsq.androidutils.mvp.presenter.BasePresenter;

import butterknife.ButterKnife;

public abstract class BaseActivity<V, T extends BasePresenter<V >> extends AppCompatActivity{

    protected T ipresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(getLayoutId());
        ipresenter = createPresenter();
        ipresenter.attachView((V)this);
        ButterKnife.bind(this);

        initView();
    }

    protected  abstract T createPresenter();

    protected abstract int getLayoutId();

    protected abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ipresenter.deachView();
    }
}
