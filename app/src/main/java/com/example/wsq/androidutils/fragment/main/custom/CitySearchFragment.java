package com.example.wsq.androidutils.fragment.main.custom;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.adapter.SearchCityAdapter;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.CityPresenter;
import com.example.wsq.androidutils.mvp.view.CityView;
import com.wsq.library.bean.CityInfoBean;
import com.wsq.library.dao.CityDao;
import com.wsq.library.tools.RecyclerViewDivider;
import com.wsq.library.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/8 0008.
 */

public class CitySearchFragment extends BaseFragment<CityView, CityPresenter<CityView>> implements  CityView, TextWatcher {
    public static final String TAG = CitySearchFragment.class.getName();
    public static final String INTERFACE_NPNR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHP = TAG + _INTERFACE_WITHP;
    public static final String INTERFACE_WITHR = TAG + _INTERFACE_WITHR;
    public static final String INTERFACE_WITHPR = TAG + _INTERFACE_WITHPR;

    @BindView(R.id.rv_RecyclerView) RecyclerView rv_RecyclerView;
    @BindView(R.id.et_city_search) EditText et_city_search;
    @BindView(R.id.tv_title) TextView tv_title;


    private List<CityInfoBean> mData;
    private SearchCityAdapter mAdapter;

    @Override
    protected CityPresenter<CityView> createPresenter() {
        return new CityPresenter<>();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_search_city;
    }

    @Override
    protected void initView() {
        tv_title.setText("城市搜索");
        mData = new ArrayList<>();

        rv_RecyclerView.addItemDecoration(new RecyclerViewDivider(
                getActivity(), LinearLayoutManager.HORIZONTAL, DensityUtil.dp2px(getActivity(), 2),
                ContextCompat.getColor(getActivity(), R.color.default_backgroud_color)));
        rv_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_RecyclerView.setHasFixedSize(true);

        mAdapter = new SearchCityAdapter(getActivity(), mData);
        rv_RecyclerView.setAdapter(mAdapter);
        et_city_search.addTextChangedListener(this);
    }

    @OnClick({R.id.ll_back})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        String str = editable.toString();

        try {
            ipresenter.searchLikeCity(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showAllCity(List<CityInfoBean> list) {
        mData.clear();
        mData.addAll(list);
        mAdapter.notifyDataSetChanged();
    }
}
