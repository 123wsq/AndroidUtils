package com.example.wsq.androidutils.fragment.main.custom;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.FragmentPresenter;
import com.example.wsq.androidutils.mvp.view.FragmentView;
import com.wsq.library.db.DBManager;

import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/3/7 0007.
 */

public class CityFragment extends BaseFragment<FragmentView, FragmentPresenter<FragmentView>> implements FragmentView{

    public static final String TAG = CityFragment.class.getName();
    public static final String INTERFACE_NPNR = TAG+"NPNR";
    public static final String INTERFACE_WITHP = TAG+"withParam";
    public static final String INTERFACE_WITHR = TAG+"withResult";
    public static final String INTERFACE_WITHPR = TAG+"withParamResult";

    @BindView(R.id.rv_RecyclerView) RecyclerView rv_RecyclerView;

    @Override
    public void onShowProgress() {

    }

    @Override
    public void onHideProgress() {

    }

    @Override
    public void showData(List<Map<String, Object>> data) {

    }

    @Override
    protected FragmentPresenter<FragmentView> createPresenter() {
        return new FragmentPresenter<>();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_city;
    }

    @Override
    protected void initView() {

        DBManager manager = new DBManager(getActivity());
        SQLiteDatabase db = manager.DBManager();
        manager.getAllCityList(db);
    }
}
