package com.wsq.library.views.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2018/2/9 0009.
 */

public class IndexView extends LinearLayout {
    private String[] index={"#","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    private Context mContext;
    private OnTextChangeListener mListener;
    private int  curPosition = -1 ;
    private int height;
    private int width;
    public IndexView(Context context) {
        super(context);

    }

    @SuppressLint("NewApi")
    public IndexView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.mContext = context;
        setOrientation(LinearLayout.VERTICAL);
        onAddView();

    }


    public void onAddView(){

        for (int i = 0; i < index.length; i++) {
            final TextView textView = new TextView(mContext);
            textView.setGravity(Gravity.CENTER);
            textView.setText(index[i]);
            textView.setOnClickListener(new MyOnClickListener(i));
            addView(textView);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        return super.onTouchEvent(event);
    }


    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {

        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        width = getWidth();
        height = getHeight();
        float downPoint;
        int spaceSize = height/ index.length+1;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downPoint = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int curPoint = (int) event.getY();

                int poi = curPoint % spaceSize == 0 ? (curPoint / spaceSize) : curPoint/spaceSize + 1;

                if (mListener != null){
                    mListener.onChangeTextListener(index[poi >= index.length-1 ? index.length -1 : poi]);
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return super.dispatchTouchEvent(event);
    }

    class MyOnClickListener implements OnClickListener{
        int position;


        public MyOnClickListener(int position){
            this.position = position;
        }
        @Override
        public void onClick(View view) {
            if (mListener != null){
                mListener.onChangeTextListener(index[position]);
            }
        }
    }

    public void onTextChangeListener(OnTextChangeListener listener){
        this.mListener = listener;
    }


    public interface OnTextChangeListener{
        void onChangeTextListener(String result);
    }
}
