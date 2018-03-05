package com.example.wsq.androidutils.fragment.main.tab;

import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;

import butterknife.BindView;

/**
 * Created by wsq on 2018/1/20.
 */

public class TwoTabFragment extends BaseFragment{

    public static final String INTERFACE_NPNR = TwoTabFragment.class.getName()+"NPNR";
    public static final String INTERFACE_WITHP = TwoTabFragment.class.getName()+"withParam";
    public static final String INTERFACE_WITHR = TwoTabFragment.class.getName()+"withResult";
    public static final String INTERFACE_WITHPR = TwoTabFragment.class.getName()+"withParamResult";

    @BindView(R.id.tv_content)
    TextView tv_content;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_test;
    }

    @Override
    public void initView() {
        tv_content.setText("这个是第二个");
    }


}
