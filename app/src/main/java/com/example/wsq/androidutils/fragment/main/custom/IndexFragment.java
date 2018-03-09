package com.example.wsq.androidutils.fragment.main.custom;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.orhanobut.logger.Logger;
import com.wsq.library.views.view.IndexView;

import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/2/9 0009.
 */

public class IndexFragment extends BaseFragment {

    public static final String TAG = IndexFragment.class.getName();
    public static final String INTERFACE_NPNR = TAG+"NPNR";
    public static final String INTERFACE_WITHP = TAG+"withParam";
    public static final String INTERFACE_WITHR = TAG+"withResult";
    public static final String INTERFACE_WITHPR = TAG+"withParamResult";

    @BindView(R.id.index_View)
    IndexView index_View;
    @BindView(R.id.tv_index)
    TextView tv_index;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_index;
    }

    @Override
    protected void initView() {

        Logger.d("索引");
        index_View.setOnTouchingLetterChangedListener(new IndexView.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                Message msg = new Message();
                msg.obj = s;
                handler.sendMessage(msg);
            }
        });

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv_index.setText(msg.obj+"");
        }
    };
}
