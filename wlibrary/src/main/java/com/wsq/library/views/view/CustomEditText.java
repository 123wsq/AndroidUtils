package com.wsq.library.views.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
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
public class CustomEditText extends EditText implements TextWatcher {


    private Drawable imgInable;
    private int minLength;
    private int maxLength;

    public CustomEditText(Context context) {
        super(context, null);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Custom_Edit);
        minLength =ta.getInt(R.styleable.Custom_Edit_minLength, -1);
        maxLength = ta.getInt(R.styleable.Custom_Edit_maxLength, -1);
        onInit(context);
    }


    public void onInit(Context context){

        imgInable = context.getResources().getDrawable(R.drawable.image_close);
        addTextChangedListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        String str = editable.toString();
        if (str.length() > 0 ){
            Logger.d("====="+str.length());
            setCompoundDrawables(null, null, imgInable, null);
        }else{
            setCompoundDrawables(null, null, null, null);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (imgInable != null &&event.getAction() == MotionEvent.ACTION_UP){
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - 50;
            if(rect.contains(eventX, eventY))
                setText("");
        }
        return super.onTouchEvent(event);
    }
}
