package com.example.wsq.androidutils.fragment.main.custom;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wsq.library.tools.RecyclerViewDivider;
import com.wsq.library.tools.ToastUtils;
import com.wsq.library.utils.DensityUtil;
import com.wsq.library.views.adapter.DefaultAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class RefreshFragment extends BaseFragment<DefaultView, DefaultPresenter<DefaultView>> implements DefaultView{

    public static final String TAG = RefreshFragment.class.getName();
    public static  String INTERFACE_NPNR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHP = TAG + _INTERFACE_WITHP;
    public static final String INTERFACE_WITHR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHPR = TAG +_INTERFACE_WITHPR;

    @BindView(R.id.rv_RecyclerView)
    RecyclerView rv_RecyclerView;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    private DefaultAdapter mAdapter;
    private List<String> mData;

    @Override
    public void showData(List<String> data) {
        mData.clear();
        mData.addAll(data);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected DefaultPresenter<DefaultView> createPresenter() {
        return new DefaultPresenter<>();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_refresh;
    }

    @Override
    protected void initView() {

        mData = new ArrayList<>();
        tv_title.setText("刷新");

        rv_RecyclerView.addItemDecoration(new RecyclerViewDivider(
                getActivity(), LinearLayoutManager.HORIZONTAL, DensityUtil.dp2px(getActivity(), 5),
                ContextCompat.getColor(getActivity(), R.color.default_backgroud_color)));
        rv_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_RecyclerView.setHasFixedSize(true);

        mAdapter = new DefaultAdapter(getActivity(), mData, null);
        rv_RecyclerView.setAdapter(mAdapter);
        ipresenter.showRefreshData();

        onRefresh();
    }

    @OnClick(R.id.ll_back)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
        }
    }


    public void onRefresh(){
        refreshLayout.setRefreshHeader(new BezierCircleHeader(getContext()));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                ToastUtils.onToast("数据刷新");
                refreshlayout.finishRefresh(2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                ToastUtils.onToast("数据加载");
                refreshlayout.finishLoadmore(2000);
            }
        });
    }
}
