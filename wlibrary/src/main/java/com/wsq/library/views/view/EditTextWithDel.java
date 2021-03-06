package com.wsq.library.views.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wlibrary.R;
import com.orhanobut.logger.Logger;
import com.wsq.library.utils.DensityUtil;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

@SuppressLint("AppCompatCustomView")
public class EditTextWithDel extends EditText {


    private final static String TAG = "EditTextWithDel";
    private Drawable imgInable;
    private Drawable imgAble;
    private Context mContext;

    public EditTextWithDel(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public EditTextWithDel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init();
    }

    public EditTextWithDel(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
//        imgInable = mContext.getResources().getDrawable(R.drawable.delete_gray);
        imgAble = mContext.getResources().getDrawable(R.drawable.image_close);
        //事件监听
        addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                setDrawable();
            }
        });
        setDrawable();
    }

    //设置删除图片
    private void setDrawable() {
        if(length() < 1){
            //表示没有输入文本内容时显示的图片，个人觉得不需要设置默认图片
            setCompoundDrawables (null, null, null, null);
//          setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }else{
            imgAble.setBounds(0,0, DensityUtil.dp2px(mContext, 10),DensityUtil.dp2px(mContext, 10));
            //setCompoundDrawables 画的drawable的宽高是按drawable.setBound()设置的宽高，
            //setCompoundDrawablesWithIntrinsicBounds是画的drawable的宽高是按drawable固定的宽高，
            setCompoundDrawables (null, null, imgAble, null);
        }
    }

    // 处理删除事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (imgAble != null && event.getAction() == MotionEvent.ACTION_UP) {
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Log.e(TAG, "eventX = " + eventX + "; eventY = " + eventY);
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - 70;
            if(rect.contains(eventX, eventY))
                setText("");
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }



    /**
     * 设置晃动动画
     */
    public void setShakeAnimation(){
        this.startAnimation( shakeAnimation( 5 ) );
    }


    /**
     * 晃动动画
     * @param counts 1秒钟晃动多少下
     * @return
     */
    public static Animation shakeAnimation(int counts){
        Animation translateAnimation = new TranslateAnimation(0, 10, 0, 0);
        translateAnimation.setInterpolator(new CycleInterpolator(counts));
        translateAnimation.setDuration( 1000 );
        return translateAnimation;
    }


    public void setCloseDrawable(Drawable drawable){
        this.imgAble = drawable;
    }

}
