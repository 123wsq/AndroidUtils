package com.example.wsq.androidutils.fragment.main.custom;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.FragmentPresenter;
import com.example.wsq.androidutils.mvp.view.FragmentView;
import com.orhanobut.logger.Logger;
import com.wsq.library.views.view.IndexView;

import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/2/9 0009.
 */

public class IndexFragment extends BaseFragment<FragmentView, FragmentPresenter<FragmentView>> implements FragmentView {

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
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_index;
    }

    @Override
    protected void initView() {

        Logger.d("索引");
        index_View.onTextChangeListener(new IndexView.OnTextChangeListener() {
            @Override
            public void onChangeTextListener(String result) {
//                tv_index.setText(result);
                Message msg = new Message();
                msg.obj = result;
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
