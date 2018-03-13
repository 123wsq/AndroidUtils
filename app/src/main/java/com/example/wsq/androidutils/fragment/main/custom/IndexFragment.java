package com.example.wsq.androidutils.fragment.main.custom;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.orhanobut.logger.Logger;
import com.wsq.library.views.view.IndexView;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R.id.tv_title) TextView tv_title;

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
        tv_title.setText("索引");

        index_View.setOnTouchingLetterChangedListener(new IndexView.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                Message msg = new Message();
                msg.obj = s;
                handler.sendMessage(msg);
            }
        });

    }

    @OnClick(R.id.ll_back)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
        }
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv_index.setText(msg.obj+"");
        }
    };
}
