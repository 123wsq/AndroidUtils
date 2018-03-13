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
import com.orhanobut.logger.Logger;
import com.wsq.library.utils.DateUtil;
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
    @BindView(R.id.tv_title) TextView tv_title;
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

        tv_title.setText("图片水印");

    }

    @OnClick({R.id.ll_back, R.id.tv_center_water, R.id.tv_left_top_water, R.id.tv_right_top_water, R.id.tv_left_down_water, R.id.tv_right_down_water})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
            case R.id.tv_center_water:
                try{
                    Bitmap olebitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image_new_year);
                    Bitmap bitmap = ImageUtils.drawTextToCenter(getActivity(), olebitmap, DateUtil.onDateFormat(DateUtil.DATA_FORMAT_1), 30, Color.WHITE);
                    iv_water.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }

                break;
            case R.id.tv_left_top_water:
                try{
                    Bitmap olebitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image_new_year);
                    Bitmap bitmap = ImageUtils.drawTextToLeftTop(getActivity(), olebitmap, DateUtil.onDateFormat(DateUtil.DATA_FORMAT_1), 30, Color.WHITE, 20, 20);
                    iv_water.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.tv_right_top_water:
                try{
                    Bitmap olebitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image_new_year);
                    Bitmap bitmap = ImageUtils.drawTextToRightTop(getActivity(), olebitmap, DateUtil.onDateFormat(DateUtil.DATA_FORMAT_1), 30, Color.WHITE, 20, 20);
                    iv_water.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.tv_left_down_water:
                try{
                    Bitmap olebitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image_new_year);
                    Bitmap bitmap = ImageUtils.drawTextToLeftBottom(getActivity(), olebitmap, DateUtil.onDateFormat(DateUtil.DATA_FORMAT_1), 30, Color.WHITE, 20, 20);
                    iv_water.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.tv_right_down_water:
                try{
                    Bitmap olebitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image_new_year);
                    Bitmap bitmap = ImageUtils.drawTextToRightBottom(getActivity(), olebitmap, DateUtil.onDateFormat(DateUtil.DATA_FORMAT_1), 30, Color.WHITE, 20, 20);
                    iv_water.setImageBitmap(bitmap);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }
}
