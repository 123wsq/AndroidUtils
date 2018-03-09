package com.example.wsq.androidutils.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.example.wsq.androidutils.mvp.view.BaseView;
import com.wsq.library.views.view.LoadingDialog;

import butterknife.ButterKnife;

public abstract class BaseActivity<V, T extends BasePresenter<V >> extends AppCompatActivity implements BaseView{

    protected T ipresenter;
    private LoadingDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(getLayoutId());
        ipresenter = createPresenter();
        ipresenter.attachView((V)this);
        dialog = new LoadingDialog(this);
        ButterKnife.bind(this);

        initView();
    }

    protected abstract T createPresenter();

    protected abstract int getLayoutId();

    protected abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ipresenter.deachView();
    }

    @Override
    public void showLoadding() {
        if (!dialog.isShowing()) dialog.show();
    }

    @Override
    public void dismissLoadding() {
        if (dialog.isShowing())dialog.dismiss();
    }

    @Override
    public void loadFail(String errorMsg) {

    }

    @Override
    public Context getContext() {
        return this;
    }
}
