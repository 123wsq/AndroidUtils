package com.example.wsq.androidutils.fragment.main.custom;

import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class NightPatternFragment extends BaseFragment{
    @BindView(R.id.tv_title)
    TextView tv_title;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

        tv_title.setText("夜间模式");
    }

    @OnClick({R.id.ll_back, R.id.tv_light, R.id.tv_night})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
            case R.id.tv_light:

                break;
            case R.id.tv_night:

                break;
        }
    }
}
