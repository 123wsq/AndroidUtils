package com.example.wsq.androidutils.fragment.main.custom;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.adapter.RecyclerAdapter;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.wsq.library.listener.OnRecyclerViewItemClickListener;
import com.wsq.library.tools.RecyclerViewDivider;
import com.wsq.library.tools.ToastUtils;
import com.wsq.library.utils.DensityUtil;
import com.wsq.library.views.adapter.DefaultAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class RecyclerViewHeader extends BaseFragment<DefaultView, DefaultPresenter<DefaultView>> implements DefaultView{

    public static final String TAG = RecyclerViewHeader.class.getName();
    @BindView(R.id.rv_RecyclerView)RecyclerView rv_RecyclerView;

    private List<String> mData;
    private RecyclerAdapter mAdapter;

    @Override
    protected DefaultPresenter<DefaultView> createPresenter() {
        return new DefaultPresenter<>();
    }

    @Override
    protected int getLayoutId() {
        return com.example.wlibrary.R.layout.layout_recyclerview_base;
    }

    @Override
    protected void initView() {

        onInitRecyclerView();
    }

    private void onInitRecyclerView(){
        mData = new ArrayList<>();
        rv_RecyclerView.addItemDecoration(new RecyclerViewDivider(
                getActivity(), LinearLayoutManager.HORIZONTAL, DensityUtil.dp2px(getActivity(), 10),
                ContextCompat.getColor(getActivity(), R.color.default_backgroud_color)));
        final GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        rv_RecyclerView.setLayoutManager(manager);
        rv_RecyclerView.setHasFixedSize(true);

        for (int i = 0; i < 50; i++) {
            mData.add("这个是：" +i);
        }
        mAdapter = new RecyclerAdapter(getActivity(), mData);
        rv_RecyclerView.setAdapter(mAdapter);

        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.isFoot(position) || mAdapter.isHead(position) ? manager.getSpanCount() : 1;
            }
        });
    }

    OnRecyclerViewItemClickListener listener = new OnRecyclerViewItemClickListener() {
        @Override
        public void onRecyclerItemClickListener(View view, int position) {

            ToastUtils.onToast("您点击的是：" +mData.get(position));
        }

        @Override
        public void onRecyclerItemLongClickListener(View view, int position) {

        }
    };
    @Override
    public void showData(List<String> data) {

    }
}
