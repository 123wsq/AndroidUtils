package com.example.wsq.androidutils.fragment.main.custom;

import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class EditTextFragment extends BaseFragment {

    public static final String TAG = EditTextFragment.class.getName();
    public static  String INTERFACE_NPNR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHP = TAG + _INTERFACE_WITHP;
    public static final String INTERFACE_WITHR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHPR = TAG +_INTERFACE_WITHPR;

    @BindView(R.id.tv_title)
    TextView tv_title;
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_edittext;
    }

    @Override
    protected void initView() {

        tv_title.setText("输入框");
    }

    @OnClick(R.id.ll_back)
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
        }
    }
}
