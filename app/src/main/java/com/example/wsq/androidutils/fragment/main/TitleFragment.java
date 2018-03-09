package com.example.wsq.androidutils.fragment.main;

import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;

import butterknife.BindView;

/**
 * Created by wsq on 2018/1/23.
 */

public class TitleFragment extends BaseFragment {

    public static final String TAG = TitleFragment.class.getName();
    public static final String INTERFACE = TAG;

    @BindView(R.id.tv_title) TextView tv_title;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_fragment_title;
    }

    @Override
    public void initView() {

    }

    /**
     * 修改标题显示
     * @param title
     */
    public void setTitle(String title){
        tv_title.setText(title);
    }


}
