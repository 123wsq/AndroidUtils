package com.example.wsq.androidutils.fragment.main.custom;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.wsq.library.utils.ImageUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/31 0031.
 */

public class WaterFragment extends BaseFragment{

    public static final String TAG = WaterFragment.class.getName();
    public static final String INTERFACE_NPNR = TAG+"NPNR";
    public static final String INTERFACE_WITHP = TAG+"withParam";
    public static final String INTERFACE_WITHR = TAG+"withResult";
    public static final String INTERFACE_WITHPR = TAG+"withParamResult";

    @BindView(R.id.tv_center_water)
    TextView tv_center_water;
    @BindView(R.id.iv_water)
    ImageView iv_water;
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_water;
    }

    @Override
    protected void initView() {


    }

    @OnClick({R.id.tv_center_water})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv_center_water:
                try{
                    Bitmap olebitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image_new_year);
                    Bitmap bitmap = ImageUtils.drawTextToCenter(getActivity(), olebitmap, "2018-01-31", 30, Color.WHITE);
                    iv_water.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }

                break;
        }
    }
}
