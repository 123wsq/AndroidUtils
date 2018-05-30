package com.example.wsq.androidutils.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class SearchCityAdapter extends RecyclerView.Adapter<SearchCityAdapter.ViewHolder>{

    private Context mContext;
    private List<CityInfoBean> mData;
    public SearchCityAdapter(Context context, List<CityInfoBean> list){
        this.mContext =context;
        this.mData = list;
    }
    @Override
    public SearchCityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_city_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchCityAdapter.ViewHolder holder, int position) {

        CityInfoBean bean = mData.get(position);

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
