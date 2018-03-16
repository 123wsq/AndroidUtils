package com.example.wsq.androidutils.fragment.main.custom;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.BaseView;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.wsq.library.listener.OnRecyclerViewItemClickListener;
import com.wsq.library.tools.RecyclerViewDivider;
import com.wsq.library.tools.ToastUtils;
import com.wsq.library.utils.DensityUtil;
import com.wsq.library.views.adapter.DefaultAdapter;
import com.wsq.library.views.view.SwitchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class CustomControlFragment extends BaseFragment implements SwitchView.OnStateChangedListener {

    public static final String TAG = CustomControlFragment.class.getName();
    public static  String INTERFACE_NPNR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHP = TAG + _INTERFACE_WITHP;
    public static final String INTERFACE_WITHR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHPR = TAG +_INTERFACE_WITHPR;

    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.sv_SwitchView)SwitchView sv_SwitchView;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_custom_control;
    }

    @Override
    protected void initView() {
        tv_title.setText("自定义控件");


        sv_SwitchView.setOnStateChangedListener(this);

    }
    @OnClick(R.id.ll_back)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
        }
    }


    @Override
    public void toggleToOn(SwitchView view) {
        ToastUtils.onToast("打开");
        sv_SwitchView.setOpened(true);
    }

    @Override
    public void toggleToOff(SwitchView view) {

        ToastUtils.onToast("关闭");
        sv_SwitchView.setOpened(false);
    }
}
