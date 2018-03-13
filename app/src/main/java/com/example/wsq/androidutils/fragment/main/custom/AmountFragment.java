package com.example.wsq.androidutils.fragment.main.custom;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.wsq.library.tools.ToastUtils;
import com.wsq.library.utils.AmountUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class AmountFragment extends BaseFragment{

    public static final String TAG = AmountFragment.class.getName();
    public static  String INTERFACE_NPNR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHP = TAG + _INTERFACE_WITHP;
    public static final String INTERFACE_WITHR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHPR = TAG +_INTERFACE_WITHPR;

    @BindView(R.id.tv_title) TextView tv_title;
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_amount;
    }

    @Override
    protected void initView() {
        tv_title.setText("金额");

    }

    @OnClick({R.id.ll_back, R.id.tv_f2y, R.id.tv_2p})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
            case R.id.tv_f2y:
                try {
                    ToastUtils.onToast(AmountUtils.F2Y("0.12345"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.tv_2p:
                try {
                    ToastUtils.onToast(AmountUtils.S2P("12.345"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
