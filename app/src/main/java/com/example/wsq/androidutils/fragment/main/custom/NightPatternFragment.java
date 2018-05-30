package com.example.wsq.androidutils.fragment.main.custom;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 夜间模式
 */
public class NightPatternFragment extends BaseFragment{

    public static final String TAG = NightPatternFragment.class.getName();


    @BindView(R.id.tv_title)
    TextView tv_title;


    private boolean enableNightMode = false;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_night;
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
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                getActivity().recreate();
                break;
            case R.id.tv_night:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                getActivity().recreate();
                break;
        }
    }

}
