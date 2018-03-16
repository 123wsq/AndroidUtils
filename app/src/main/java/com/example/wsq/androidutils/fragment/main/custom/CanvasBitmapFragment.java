package com.example.wsq.androidutils.fragment.main.custom;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.wsq.library.tools.ToastUtils;
import com.wsq.library.views.view.SimpleView;
import com.wsq.library.views.view.SwitchView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class CanvasBitmapFragment extends BaseFragment {

    public static final String TAG = CanvasBitmapFragment.class.getName();
    public static  String INTERFACE_NPNR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHP = TAG + _INTERFACE_WITHP;
    public static final String INTERFACE_WITHR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHPR = TAG +_INTERFACE_WITHPR;

    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.sv_SimpleView)SimpleView sv_SimpleView;


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_canvas_bitmap;
    }

    @Override
    protected void initView() {
        tv_title.setText("图片交集");


    }
    @OnClick({R.id.ll_back, R.id.tv_clear, R.id.tv_src,
            R.id.tv_dst, R.id.tv_src_over, R.id.tv_dst_over, R.id.tv_src_in, R.id.tv_dst_in,
            R.id.tv_src_out, R.id.tv_dst_out, R.id.tv_src_atop, R.id.tv_dst_atop, R.id.tv_xor,
            R.id.tv_darken, R.id.tv_lighten, R.id.tv_multiply, R.id.tv_screen})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
            case R.id.tv_clear:
                sv_SimpleView.setXfermode(SimpleView.CLEAR);
                break;
            case R.id.tv_src:
                ToastUtils.onToast("只绘制源图像");
                sv_SimpleView.setSrcBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.image_sign_background));
                break;
            case R.id.tv_dst:
                ToastUtils.onToast("只绘制目标图像");
                sv_SimpleView.setDstBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.image_default_tx));
                break;
            case R.id.tv_src_over:
                ToastUtils.onToast("在目标图像的顶部绘制源图像");
                sv_SimpleView.setXfermode(SimpleView.SRC_OVER);
                break;
            case  R.id.tv_dst_over:
                ToastUtils.onToast("在源图像的顶部绘制目标图像");
                sv_SimpleView.setXfermode(SimpleView.DST_OVER);
                break;
            case R.id.tv_src_in:
                ToastUtils.onToast("只在源图像和目标图像相交的地方绘制源图像");
                sv_SimpleView.setXfermode(SimpleView.SRC_IN);
                break;
            case R.id.tv_dst_in:
                ToastUtils.onToast("只在源图像和目标图像相交的地方绘制目标图像");
                sv_SimpleView.setXfermode(SimpleView.DST_IN);
                break;
            case R.id.tv_src_out:
                ToastUtils.onToast("只在源图像和目标图像不相交的地方绘制源图像");
                sv_SimpleView.setXfermode(SimpleView.SRC_OUT);
                break;
            case  R.id.tv_dst_out:
                ToastUtils.onToast("只在源图像和目标图像不相交的地方绘制目标图像");
                sv_SimpleView.setXfermode(SimpleView.DST_OUT);
                break;
            case  R.id.tv_src_atop:
                ToastUtils.onToast("在源图像和目标图像相交的地方绘制源图像，在不相交的地方绘制目标图像");
                sv_SimpleView.setXfermode(SimpleView.SRC_ATOP);
                break;
            case R.id.tv_dst_atop:
                ToastUtils.onToast("在源图像和目标图像相交的地方绘制目标图像，在不相交的地方绘制源图像");
                sv_SimpleView.setXfermode(SimpleView.DST_ATOP);
                break;
            case R.id.tv_xor:
                ToastUtils.onToast("在源图像和目标图像重叠之外的任何地方绘制他们，而在不重叠的地方不绘制任何内容");
                sv_SimpleView.setXfermode(SimpleView.XOR);
                break;
            case R.id.tv_darken:
                ToastUtils.onToast("获得每个位置上两幅图像中最暗的像素并显示");
                sv_SimpleView.setXfermode(SimpleView.DARKEN);
                break;
            case R.id.tv_lighten:
                ToastUtils.onToast("获得每个位置上两幅图像中最亮的像素并显示");
                sv_SimpleView.setXfermode(SimpleView.LIGHTEN);
                break;
            case R.id.tv_multiply:
                ToastUtils.onToast("将每个位置的两个像素相乘，除以255，然后使用该值创建一个新的像素进行显示。结果颜色=顶部颜色*底部颜色/255");
                sv_SimpleView.setXfermode(SimpleView.MULTIPLY);
                break;
            case R.id.tv_screen:
                ToastUtils.onToast("反转每个颜色，执行相同的操作（将他们相乘并除以255），然后再次反转。结果颜色=255-(((255-顶部颜色)*(255-底部颜色))/255)");
                sv_SimpleView.setXfermode(SimpleView.SCREEN);
                break;
            default:

                break;
        }
    }

}
