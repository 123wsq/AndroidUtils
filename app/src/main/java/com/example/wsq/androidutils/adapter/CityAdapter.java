package com.example.wsq.androidutils.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wsq.androidutils.R;
import com.wsq.library.bean.CityInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/8 0008.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder>{

    private Context mContext;
    private List<CityInfoBean> mData;
    public CityAdapter(Context context, List<CityInfoBean> list){
        this.mContext =context;
        this.mData = list;
    }
    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_city_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, int position) {

        holder.tv_city_name.setText(mData.get(position).getCity_name());

        if (position == 0){
            String curStart = mData.get(position).getCity_logogram().substring(0, 1);
            holder.tv_index.setVisibility(View.VISIBLE);
            holder.tv_index.setText(curStart.toUpperCase());
        }else{
            String upStart = mData.get(position-1).getCity_logogram().substring(0, 1);
            String curStart = mData.get(position).getCity_logogram().substring(0, 1);
            if (!upStart.equals(curStart)){
                holder.tv_index.setVisibility(View.VISIBLE);
                holder.tv_index.setText(curStart.toUpperCase());
            }else{
                holder.tv_index.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_index;
        private TextView tv_city_name;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_index = itemView.findViewById(R.id.tv_index);
            tv_city_name = itemView.findViewById(R.id.tv_city_name);
        }
    }
}
