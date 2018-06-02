package com.wsq.library.views.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wlibrary.R;
import com.wsq.library.bean.CityInfoBean;
import com.wsq.library.listener.OnRecyclerViewItemClickListener;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder>{

    private Context mContext;
    private List<CityInfoBean> mData;
    private OnRecyclerViewItemClickListener mListener;
    public CityAdapter(Context context, List<CityInfoBean> list, OnRecyclerViewItemClickListener listener){
        this.mContext = context;
        this.mData = list;
        this.mListener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_city, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvName.setText(mData.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mListener != null){
                mListener.onRecyclerItemClickListener(view, getAdapterPosition());
            }
        }
    }
}
