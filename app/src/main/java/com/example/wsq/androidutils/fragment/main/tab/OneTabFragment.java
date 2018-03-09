package com.example.wsq.androidutils.fragment.main.tab;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.example.wsq.androidutils.mvp.presenter.CityPresenter;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.BaseView;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.wsq.library.listener.OnRecyclerViewItemClickListener;
import com.wsq.library.tools.RecyclerViewDivider;
import com.wsq.library.tools.ToastUtils;
import com.wsq.library.views.adapter.DefaultAdapter;
import com.wsq.library.utils.DensityUtil;
import com.wsq.library.views.view.LoadingDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by wsq on 2018/1/20.
 */

public class OneTabFragment extends BaseFragment<DefaultView, DefaultPresenter<DefaultView>> implements DefaultView{

    public static final String INTERFACE_NPNR = OneTabFragment.class.getName()+"NPNR";
    public static final String INTERFACE_WITHP = OneTabFragment.class.getName()+"withParam";
    public static final String INTERFACE_WITHR = OneTabFragment.class.getName()+"withResult";
    public static final String INTERFACE_WITHPR = OneTabFragment.class.getName()+"withParamResult";


    public static final String TAG = OneTabFragment.class.getName();
    public static final String INTERFACE = TAG;

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

        ipresenter.showData();

    }
    OnRecyclerViewItemClickListener mListener = new OnRecyclerViewItemClickListener() {
        @Override
        public void onRecyclerItemClickListener(View view, int position) {
//
            mFunctionsManage.invokeFunction(INTERFACE_WITHP,position);

        }

        @Override
        public void onRecyclerItemLongClickListener(View view, int position) {
            ToastUtils.onToast("您长按了 "+ mData.get(position));
        }
    };



    @Override
    public void showData(List<String> data) {
        mData.addAll(data);
        mAdater.notifyDataSetChanged();
    }
}
