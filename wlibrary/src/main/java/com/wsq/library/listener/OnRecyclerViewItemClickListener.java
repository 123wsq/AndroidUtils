package com.wsq.library.listener;

import android.view.View;

/**
 * Created by wsq on 2018/1/25.
 */

public interface OnRecyclerViewItemClickListener {

    /**
     * 点击事件
     * @param position
     */
    void onRecyclerItemClickListener(View view, int position);

    /**
     * 长按事件
     * @param position
     */
    void onRecyclerItemLongClickListener(View view, int position);
}
