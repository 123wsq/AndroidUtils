package com.example.wsq.androidutils.fragment.main;

import android.widget.RadioGroup;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;

import butterknife.BindView;

/**
 * Created by wsq on 2018/1/23.
 */

public class MenuFragment extends BaseFragment {

    public static final String TAG = MenuFragment.class.getName();
    public static final String INTERFACE = TAG;


    @BindView(R.id.rg_RadioGroup) RadioGroup rg_RadioGroup;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_buttom_menu;
    }

    @Override
    public void initView() {

        onRadioGroupChangeListener();

    }

    public void onRadioGroupChangeListener(){

        rg_RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {

                switch (checkId){
                    case R.id.radioButton1:
                        mFunctionsManage.invokeFunction(TAG+_INTERFACE_WITHP, 1);
                        break;
                    case R.id.radioButton2:
                        mFunctionsManage.invokeFunction(TAG+_INTERFACE_WITHP, 2);
                        break;
                    case R.id.radioButton3:
                        mFunctionsManage.invokeFunction(TAG+_INTERFACE_WITHP, 3);
                        break;
                    case R.id.radioButton4:
                        mFunctionsManage.invokeFunction(TAG+_INTERFACE_WITHP, 4);
                        break;
                }

            }
        });
    }
}
