package com.example.wsq.androidutils.fragment.main.custom;

import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.wsq.library.views.waterwave.MultiWaveHeader;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wsq on 2018/5/21.
 */

public class WaterWaveFragment extends BaseFragment{

    public static final String TAG = WaterWaveFragment.class.getName();
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_multiwave)
    MultiWaveHeader tv_multiwave;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_water_wave;
    }

    @Override
    protected void initView() {

        tv_title.setText("水纹");
        /**
         * 格式-format
         * offsetX offsetY scaleX scaleY velocity（dp/s）
         * 水平偏移量 竖直偏移量 水平拉伸比例 竖直拉伸比例 速度
         */
//        tv_multiwave.setWaves("0,0,1,1,25\n90,0,1,1,25");
        String[] waves = "70,25,1.4,1.4,-26\n100,5,1.4,1.2,15\n420,0,1.15,1,-10\n520,10,1.7,1.5,20\n220,0,1,1,-15".split("\n");
        tv_multiwave.setWaves("70,25,1.4,1.4,-26\n100,5,1.4,1.2,15\n420,0,1.15,1,-10\n520,10,1.7,1.5,20\n220,0,1,1,-15");
        tv_multiwave.start();
    }

    @OnClick({R.id.ll_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
        }
    }
}
