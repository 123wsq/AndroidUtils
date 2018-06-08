package com.wsq.library.views.title;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.wlibrary.R;

public class CustomToolBar extends LinearLayout{

    //是否显示返回图片
    private Boolean isLeftImgVisible;

    public CustomToolBar(Context context) {
        super(context);
    }

    public CustomToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs){

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomToolBar);
        isLeftImgVisible = typedArray.getBoolean(R.styleable.CustomToolBar_left_img_visible, true);

    }
}
