package com.example.wsq.androidutils.fragment.main.tab;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.wsq.library.listener.OnRecyclerViewItemClickListener;
import com.wsq.library.tools.RecyclerViewDivider;
import com.wsq.library.utils.DensityUtil;
import com.wsq.library.views.adapter.DefaultAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wsq on 2018/1/20.
 */

public class ThreeTabFragment extends BaseFragment<DefaultView, DefaultPresenter<DefaultView>> implements DefaultView{

    public static final String INTERFACE_NPNR = ThreeTabFragment.class.getName()+"NPNR";
    public static final String INTERFACE_WITHP = ThreeTabFragment.class.getName()+"withParam";
    public static final String INTERFACE_WITHR = ThreeTabFragment.class.getName()+"withResult";
    public static final String INTERFACE_WITHPR = ThreeTabFragment.class.getName()+"withParamResult";

    @BindView(R.id.rv_RecyclerView)
    RecyclerView rv_RecyclerView;

    private DefaultAdapter mAdater;
    private List<String> mData;


    @Override
    protected DefaultPresenter<DefaultView> createPresenter() {
        return new DefaultPresenter<DefaultView>();
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_recyclerview_base;
    }

    @Override
    public void initView() {
        mData = new ArrayList<>();

        rv_RecyclerView.addItemDecoration(new RecyclerViewDivider(
                getActivity(), LinearLayoutManager.HORIZONTAL, DensityUtil.dp2px(getActivity(), 10),
                ContextCompat.getColor(getActivity(), R.color.default_backgroud_color)));
        rv_RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_RecyclerView.setHasFixedSize(true);

        mAdater = new DefaultAdapter(getActivity(), mData, mListener);
        rv_RecyclerView.setAdapter(mAdater);

        ipresenter.showthreeData();
    }

    OnRecyclerViewItemClickListener mListener = new OnRecyclerViewItemClickListener() {
        @Override
        public void onRecyclerItemClickListener(View view, int position) {

            mFunctionsManage.invokeFunction(INTERFACE_WITHP,position);
        }

        @Override
        public void onRecyclerItemLongClickListener(View view, int position) {

        }
    };

    @Override
    public void showData(List<String> data) {
        mData.addAll(data);
        mAdater.notifyDataSetChanged();
    }
}
