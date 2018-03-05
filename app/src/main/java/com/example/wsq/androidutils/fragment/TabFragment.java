package com.example.wsq.androidutils.fragment;

import android.view.View;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.bean.UserBean;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.wsq.library.tools.ToastUtils;

import butterknife.OnClick;

/**
 * Created by wsq on 2018/1/20.
 */

public class TabFragment extends BaseFragment{

    public static final String TAG = TabFragment.class.getName();
    public static final String INTERFACE_NPNR = TAG+"NPNR";
    public static final String INTERFACE_WITHP = TAG+"withParam";
    public static final String INTERFACE_WITHR = TAG+"withResult";
    public static final String INTERFACE_WITHPR = TAG +"withParamResult";


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_tab;
    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.tv_interface_noParam_noResult, R.id.tv_interface_withParamOnly,
            R.id.tv_interface_withResultOnly, R.id.tv_interface_withParamAndResult})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.tv_interface_noParam_noResult:

                mFunctionsManage.invokeFunction(INTERFACE_NPNR);
                break;
            case R.id.tv_interface_withParamOnly:
                UserBean user = new UserBean(12, "wsq", 25, "男");
                mFunctionsManage.invokeFunction(INTERFACE_WITHP, user);
                break;
            case R.id.tv_interface_withResultOnly:
                String string = mFunctionsManage.invokeFunction(INTERFACE_WITHR, String.class);
                ToastUtils.onToast(string);
                break;
            case R.id.tv_interface_withParamAndResult:
                String str = mFunctionsManage.invokeFunction(INTERFACE_WITHPR, 2018, String.class);
                ToastUtils.onToast(str);
                break;
        }
    }
}
