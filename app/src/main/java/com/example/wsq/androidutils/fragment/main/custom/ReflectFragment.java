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
import com.wsq.library.utils.DensityUtil;
import com.wsq.library.views.adapter.DefaultAdapter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class ReflectFragment extends BaseFragment{

    public static final String TAG = ReflectFragment.class.getName();
    public static  String INTERFACE_NPNR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHP = TAG + _INTERFACE_WITHP;
    public static final String INTERFACE_WITHR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHPR = TAG +_INTERFACE_WITHPR;


    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_getClass) TextView tv_getClass;
    @BindView(R.id.tv_Class) TextView tv_Class;

    private DefaultAdapter mAdapter;
    private List<String> mData;


    @Override
    protected BasePresenter<BaseView> createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_reflect;
    }

    @Override
    protected void initView() {
        mData = new ArrayList<>();
        tv_title.setText("反射机制");



    }
    @OnClick({R.id.ll_back, R.id.tv_getClass})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
            case R.id.tv_getClass:

                String path= "";
                ClassLoader loader = Thread.currentThread().getContextClassLoader();
                String packPath = path.replaceAll(".", "/");
                URL url = loader.getResource(packPath);

                break;
        }
    }



}
