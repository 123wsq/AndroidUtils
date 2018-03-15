package com.example.wsq.androidutils.fragment.main.custom;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.example.wsq.androidutils.base.BaseFragment;
import com.example.wsq.androidutils.mvp.presenter.BasePresenter;
import com.example.wsq.androidutils.mvp.presenter.DefaultPresenter;
import com.example.wsq.androidutils.mvp.view.BaseView;
import com.example.wsq.androidutils.mvp.view.DefaultView;
import com.wsq.library.listener.OnRecyclerViewItemClickListener;
import com.wsq.library.tools.RecyclerViewDivider;
import com.wsq.library.utils.DensityUtil;
import com.wsq.library.views.adapter.DefaultAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class AnimatorFragment extends BaseFragment{

    public static final String TAG = AnimatorFragment.class.getName();
    public static  String INTERFACE_NPNR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHP = TAG + _INTERFACE_WITHP;
    public static final String INTERFACE_WITHR = TAG + _INTERFACE_NPNR;
    public static final String INTERFACE_WITHPR = TAG +_INTERFACE_WITHPR;

    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_anim_ofInt) TextView tv_anim_ofInt;
    @BindView(R.id.tv_anim_oFloat) TextView tv_anim_oFloat;
    @BindView(R.id.tv_anim_xml) TextView tv_anim_xml;
    @BindView(R.id.tv_anim_object) TextView tv_anim_object;
    @BindView(R.id.tv_anim_rotation) TextView tv_anim_rotation;
    @BindView(R.id.tv_anim_translation) TextView tv_anim_translation;
    @BindView(R.id.tv_anim_scale) TextView tv_anim_scale;



    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_anim;
    }

    @Override
    protected void initView() {
        tv_title.setText("属性动画");



    }
    @OnClick({R.id.ll_back, R.id.tv_anim_ofInt, R.id.tv_anim_oFloat, R.id.tv_anim_xml, R.id.tv_anim_object, R.id.tv_anim_rotation, R.id.tv_anim_translation, R.id.tv_anim_scale})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_back:
                mFunctionsManage.invokeFunction(INTERFACE_BACK);
                break;
            case R.id.tv_anim_ofInt:
                // 步骤1：设置属性数值的初始值 & 结束值
                int width = tv_anim_ofInt.getLayoutParams().width;
                ValueAnimator valueAnimator = ValueAnimator.ofInt(width, DensityUtil.dp2px(getContext(), 200), width);
                // 初始值 = 当前按钮的宽度，此处在xml文件中设置为150
                // 结束值 = 500
                // ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置
                // 即默认设置了如何从初始值150 过渡到 结束值500

                // 步骤2：设置动画的播放各种属性
                valueAnimator.setDuration(2000);
                // 设置动画运行时长:1s

                // 步骤3：将属性数值手动赋值给对象的属性:此处是将 值 赋给 按钮的宽度
                // 设置更新监听器：即数值每次变化更新都会调用该方法
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {

                        int currentValue = (Integer) animator.getAnimatedValue();
                        // 获得每次变化后的属性值
                        System.out.println(currentValue);
                        // 输出每次变化后的属性值进行查看

                        tv_anim_ofInt.getLayoutParams().width = currentValue;
                        // 每次值变化时，将值手动赋值给对象的属性
                        // 即将每次变化后的值 赋 给按钮的宽度，这样就实现了按钮宽度属性的动态变化

                        // 步骤4：刷新视图，即重新绘制，从而实现动画效果
                        tv_anim_ofInt.requestLayout();

                    }
                });

                valueAnimator.start();
                // 启动动画

                break;
            case R.id.tv_anim_oFloat:
                // 步骤1：设置属性数值的初始值 & 结束值
                int width1 = tv_anim_oFloat.getLayoutParams().width;
                ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(width1, DensityUtil.dp2px(getContext(), 200), width1);
                // 初始值 = 当前按钮的宽度，此处在xml文件中设置为150
                // 结束值 = 500
                // ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置
                // 即默认设置了如何从初始值150 过渡到 结束值500

                // 步骤2：设置动画的播放各种属性
                valueAnimator1.setDuration(2000);
                // 设置动画运行时长:1s

                // 步骤3：将属性数值手动赋值给对象的属性:此处是将 值 赋给 按钮的宽度
                // 设置更新监听器：即数值每次变化更新都会调用该方法
                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {

                        float currentValue = (Float) animator.getAnimatedValue();
                        // 获得每次变化后的属性值
                        System.out.println(currentValue);
                        // 输出每次变化后的属性值进行查看

                        tv_anim_oFloat.getLayoutParams().width = (int)currentValue;
                        // 每次值变化时，将值手动赋值给对象的属性
                        // 即将每次变化后的值 赋 给按钮的宽度，这样就实现了按钮宽度属性的动态变化

                        // 步骤4：刷新视图，即重新绘制，从而实现动画效果
                        tv_anim_oFloat.requestLayout();

                    }
                });
//                valueAnimator1.setTarget(tv_anim_oFloat);
                valueAnimator1.start();
                // 启动动画
                break;
            case R.id.tv_anim_xml:
                // 载入XML动画
                Animator animator = AnimatorInflater.loadAnimator(getActivity(), R.animator.set_animation);
                // 设置动画对象
                animator.setTarget(tv_anim_xml);
                // 启动动画
                animator.start();

                break;
            case R.id.tv_anim_object:
                // 表示的是:
                // 动画作用对象是mButton
                // 动画作用的对象的属性是透明度alpha
                // 动画效果是:常规 - 全透明 - 常规
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(tv_anim_object, "alpha", 1f, 0f, 1f);
                animator1.setDuration(5000);
                animator1.start();
                break;
            case R.id.tv_anim_rotation:
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(tv_anim_rotation, "rotation", 0f, 180f,0f);

                // 表示的是:
                // 动画作用对象是mButton
                // 动画作用的对象的属性是旋转alpha
                // 动画效果是:0 - 360
                animator2.setDuration(5000);
                animator2.start();

                break;
                case R.id.tv_anim_translation:

                    float curTranslationX = tv_anim_translation.getTranslationX();
                    // 获得当前按钮的位置
                    ObjectAnimator animator3 = ObjectAnimator.ofFloat(tv_anim_translation, "translationX", curTranslationX, 300,curTranslationX);


                    // 表示的是:
                    // 动画作用对象是mButton
                    // 动画作用的对象的属性是X轴平移（在Y轴上平移同理，采用属性"translationY"
                    // 动画效果是:从当前位置平移到 x=1500 再平移到初始位置
                    animator3.setDuration(5000);
                    animator3.start();
                    break;
            case R.id.tv_anim_scale:
                ObjectAnimator animator4 = ObjectAnimator.ofFloat(tv_anim_scale, "scaleX", 1f, 3f, 1f);
                // 表示的是:
                // 动画作用对象是mButton
                // 动画作用的对象的属性是X轴缩放
                // 动画效果是:放大到3倍,再缩小到初始大小
                animator4.setDuration(5000);
                animator4.start();

                break;
        }
    }
}
