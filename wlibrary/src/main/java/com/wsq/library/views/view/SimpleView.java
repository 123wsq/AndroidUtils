package com.wsq.library.views.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2018/3/16 0016.
 */

public class SimpleView extends View{

    public static final Xfermode CLEAR = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    public static final Xfermode SRC = new PorterDuffXfermode(PorterDuff.Mode.SRC);
    public static final Xfermode DST = new PorterDuffXfermode(PorterDuff.Mode.DST);
    public static final Xfermode SRC_OVER = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
    public static final Xfermode DST_OVER = new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);
    public static final Xfermode SRC_IN = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    public static final Xfermode DST_IN = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    public static final Xfermode SRC_OUT = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
    public static final Xfermode DST_OUT = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    public static final Xfermode SRC_ATOP = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    public static final Xfermode DST_ATOP = new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
    public static final Xfermode XOR = new PorterDuffXfermode(PorterDuff.Mode.XOR);
    public static final Xfermode DARKEN = new PorterDuffXfermode(PorterDuff.Mode.DARKEN);
    public static final Xfermode LIGHTEN = new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN);
    public static final Xfermode MULTIPLY = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
    public static final Xfermode SCREEN = new PorterDuffXfermode(PorterDuff.Mode.SCREEN);

    private Bitmap mSrcB;
    private Bitmap mDstB;
    private Xfermode mMode;



    public SimpleView(Context context) {
        super(context);
    }

    public SimpleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#FFFFFF"));
        Paint mPaint = new Paint();

        //计算目标图片的显示位置
        int x = 0;
        int y = 0;

        if (mSrcB!= null) {
            Rect rect = new Rect(0, 0, mSrcB.getWidth(), mSrcB.getHeight());
            canvas.drawBitmap(mSrcB, rect, rect, mPaint);
        }

        if (mDstB != null){
            if (mSrcB != null){
                x = 200;
                y = 50;
            }
            Rect rect1 = new Rect(x, y, mDstB.getWidth(), mDstB.getHeight());
            if (mMode != null){
                mPaint.setXfermode(mMode);
            }
            canvas.drawBitmap(mDstB, rect1, rect1, mPaint);
        }

    }

    public void setSrcBitmap(Bitmap bitmap){
        this.mSrcB = bitmap;
        postInvalidate();
    }

    public void setDstBitmap(Bitmap bitmap){
        this.mDstB = bitmap;
        postInvalidate();
    }

    public void setXfermode(Xfermode mode){
        this.mMode = mode;
//        invalidate();
    }

}
