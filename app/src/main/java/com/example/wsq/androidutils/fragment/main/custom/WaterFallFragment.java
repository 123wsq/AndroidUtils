package com.example.wsq.androidutils.fragment.main.custom;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.adapter.WaterFallAdapter;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.example.wsq.androidutils.mvp.view.WaterFallView;
import com.orhanobut.logger.Logger;
import com.wsq.library.views.view.CustomPopup;
import com.wsq.library.views.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class WaterFallFragment extends BaseFragment<WaterFallView, DefaultPresenter<WaterFallView>> implements WaterFallView {

    public static final String TAG = WaterFallFragment.class.getName();

    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.rv_RecyclerView)
    RecyclerView rv_RecyclerView;
@BindView(R.id.ll_layout)
    LinearLayout ll_layout;

    private WaterFallAdapter mAdapter;
    private List<Map<String, Object>> mData;



    @Override
    protected DefaultPresenter<WaterFallView> createPresenter() {
        return new DefaultPresenter<>();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_title_list;
    }

    @Override
    protected void initView() {

        mData = new ArrayList<>();
        tv_title.setText("瀑布流");

        rv_RecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        rv_RecyclerView.addItemDecoration(decoration);

        mAdapter = new WaterFallAdapter(getActivity(), mData);
        rv_RecyclerView.setAdapter(mAdapter);


        ipresenter.onGetWaterFallData();

    }

    @OnClick({R.id.ll_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
        }
    }


    @Override
    public void showData(List<Map<String, Object>> data) {

        mData.addAll(data);

        mAdapter.notifyDataSetChanged();
    }
}
