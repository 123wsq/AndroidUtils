package com.example.wsq.androidutils.fragment.main.custom;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.WaveIndexView;
import com.wsq.library.bean.CityInfoBean;
import com.wsq.library.views.index.SortAdapter;
import com.wsq.library.views.index.TitleItemDecoration;
import com.wsq.library.views.index.WaveSideBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/2/9 0009.
 */

public class IndexFragment extends BaseFragment<WaveIndexView, DefaultPresenter<WaveIndexView>> implements WaveIndexView, WaveSideBar.OnTouchLetterChangeListener {

    public static final String TAG = IndexFragment.class.getName();
    public static final String INTERFACE_NPNR = TAG+"NPNR";
    public static final String INTERFACE_WITHP = TAG+"withParam";
    public static final String INTERFACE_WITHR = TAG+"withResult";
    public static final String INTERFACE_WITHPR = TAG+"withParamResult";

    @BindView(R.id.rv_RecyclerView) RecyclerView rv_RecyclerView;
    @BindView(R.id.ws_sideBar) WaveSideBar ws_sideBar;
    @BindView(R.id.tv_title) TextView tv_title;

    private SortAdapter mAdapter;
    private List<CityInfoBean> mData;
    private TitleItemDecoration mDecoration;
    private LinearLayoutManager manager;


    @Override
    protected DefaultPresenter<WaveIndexView> createPresenter() {
        return new DefaultPresenter<>();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_index;
    }

    @Override
    protected void initView() {
        tv_title.setText("索引");

        ws_sideBar.setOnTouchLetterChangeListener(this);

        onInitRecyclerView();
    }

    private void onInitRecyclerView(){

        mData =new ArrayList<>();


        //RecyclerView设置manager
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_RecyclerView.setLayoutManager(manager);
        mAdapter = new SortAdapter(getActivity(), mData);
        rv_RecyclerView.setAdapter(mAdapter);
        mDecoration = new TitleItemDecoration(getActivity(), mData);
        //如果add两个，那么按照先后顺序，依次渲染。
        rv_RecyclerView.addItemDecoration(mDecoration);
        rv_RecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        ipresenter.showIndexData();
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
    public void onLetterChange(String letter) {
        //该字母首次出现的位置
        int position = mAdapter.getPositionForSection(letter.charAt(0));
        if (position != -1) {
            manager.scrollToPositionWithOffset(position, 0);
        }
    }

    @Override
    public void showData(List<CityInfoBean> data) {

        mData.addAll(data);
        // 根据a-z进行排序源数据

        mAdapter.notifyDataSetChanged();

    }
}
