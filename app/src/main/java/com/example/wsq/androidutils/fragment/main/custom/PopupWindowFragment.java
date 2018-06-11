package com.example.wsq.androidutils.fragment.main.custom;

import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.wsq.library.views.view.CustomPopup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PopupWindowFragment extends BaseFragment{

    public static final String TAG = PopupWindowFragment.class.getName();
    @BindView(R.id.ll_layout)
    LinearLayout ll_layout;
    @BindView(R.id.tv_title)
    TextView tv_title;

    CustomPopup popup;
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_popup;
    }

    @Override
    protected void initView() {

        tv_title.setText("PopupWindow");
    }

    @OnClick({R.id.ll_back, R.id.tv_show_popup})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
            case R.id.tv_show_popup:
            showPopup();
                break;
        }
    }

    public void showPopup(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        popup = new CustomPopup(getActivity(), list, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.dismiss();
            }
        }, new CustomPopup.PopupItemListener() {
            @Override
            public void onClickItemListener(int position, String result) {

                popup.dismiss();
            }
        });
        popup.onTitle("设置");
        popup.onSetHeight(list.size()*50+75);
        popup.showAtLocation(ll_layout, Gravity.BOTTOM|Gravity.CENTER, 0, 0);
    }

}
