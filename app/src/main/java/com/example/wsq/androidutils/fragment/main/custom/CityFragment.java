package com.example.wsq.androidutils.fragment.main.custom;

import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.adapter.CityAdapter;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.CityPresenter;
import com.example.wsq.androidutils.mvp.view.CityView;
import com.wsq.library.bean.CityInfoBean;
import com.wsq.library.dao.CityDao;
import com.wsq.library.tools.RecyclerViewDivider;
import com.wsq.library.tools.ToastUtils;
import com.wsq.library.utils.DensityUtil;
import com.wsq.library.views.view.IndexView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/7 0007.
 */

public class CityFragment extends BaseFragment<CityView, CityPresenter<CityView>> implements CityView, IndexView.OnTouchingLetterChangedListener {

    public static final String TAG = CityFragment.class.getName();
    public static final String INTERFACE_NPNR = TAG+"NPNR";
    public static final String INTERFACE_WITHP = TAG+"withParam";
    public static final String INTERFACE_WITHR = TAG+"withResult";
    public static final String INTERFACE_WITHPR = TAG+"withParamResult";

    @BindView(R.id.rv_RecyclerView) RecyclerView rv_RecyclerView;
    @BindView(R.id.index_View) IndexView index_View;
    @BindView(R.id.et_search) TextView et_search;

    private CityAdapter mAdapter;

    private List<CityInfoBean> mData;

    @Override
    protected CityPresenter<CityView> createPresenter() {
        return new CityPresenter<>();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_city;
    }

    @Override
    protected void initView() {
        mData = new ArrayList<>();
        rv_RecyclerView.addItemDecoration(new RecyclerViewDivider(
                getActivity(), LinearLayoutManager.HORIZONTAL, DensityUtil.dp2px(getActivity(), 10),
                ContextCompat.getColor(getActivity(), R.color.default_backgroud_color)));
        rv_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_RecyclerView.setHasFixedSize(true);

        mAdapter = new CityAdapter(getActivity(), mData);
        rv_RecyclerView.setAdapter(mAdapter);
        index_View.setOnTouchingLetterChangedListener(this);

        try {
            ipresenter.getAllCity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.et_search)
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.et_search:
                mFunctionsManage.invokeFunction(INTERFACE_NPNR);
                break;
        }
    }

    @Override
    public void onTouchingLetterChanged(String s) {
//        Logger.d("选择的是 ： "+s);

        Message msg = new Message();
        msg.obj = s.toLowerCase();
        handler.sendMessage(msg);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String curIndex = (String) msg.obj;
            for (int i = 0; i < mData.size(); i++) {

                String index = mData.get(i).getCity_logogram() .substring(0, 1);
                if (curIndex.equals(index)){
                    rv_RecyclerView.scrollToPosition(i);
                    break;
                }
            }

        }
    };

    @Override
    public void showAllCity(List<CityInfoBean> list) {
        mData.addAll(list);
        mAdapter.notifyDataSetChanged();
    }
}
