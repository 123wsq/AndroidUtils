package com.wsq.library.views.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wlibrary.R;
import com.orhanobut.logger.Logger;
import com.wsq.library.listener.OnRecyclerViewItemClickListener;

import java.util.List;
import java.util.Map;

/**
 * Created by wsq on 2018/1/24.
 */

public class DefaultAdapter extends RecyclerView.Adapter<DefaultAdapter.ViewHoler>{

    public static final String KEY_DATA = "data";
    private Context mContext;
    private List<Map<String, Object>> mData;
    private OnRecyclerViewItemClickListener mListener;

    public DefaultAdapter(Context context, List<Map<String, Object>> list, OnRecyclerViewItemClickListener listener){
        this.mContext = context;
        this.mData = list;
        this.mListener = listener;
    }
    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_default_item, parent, false);

        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {

        holder.tv_content.setText(mData.get(position).get(KEY_DATA)+"");
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        TextView tv_content;
        LinearLayout ll_layout;
        public ViewHoler(View itemView) {
            super(itemView);
            tv_content = itemView.findViewById(R.id.tv_content);
            ll_layout = itemView.findViewById(R.id.ll_layout);
            ll_layout.setOnClickListener(this);
            ll_layout.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View view) {
            if (mListener != null){
                mListener.onRecyclerItemLongClickListener(view, getPosition());
            }
            return false;
        }

        @Override
        public void onClick(View view) {
            if (mListener != null){
                mListener.onRecyclerItemClickListener(view, getPosition());
            }
        }
    }
}
