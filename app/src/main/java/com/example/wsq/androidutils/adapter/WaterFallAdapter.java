package com.example.wsq.androidutils.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wsq.androidutils.R;

import java.util.List;
import java.util.Map;

public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallAdapter.ViewHolder>{

    private Context mContext;
    private List<Map<String, Object>> mData;
    public WaterFallAdapter(Context context, List<Map<String, Object>> list){
        this.mContext = context;
        this.mData = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_masonry_item, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.masonry_item_title.setText(mData.get(position).get("title")+"");
        Glide.with(mContext).load(mData.get(position).get("url")).into(holder.masonry_item_img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView masonry_item_img;
        private TextView masonry_item_title;
        public ViewHolder(View itemView) {
            super(itemView);

            masonry_item_img = itemView.findViewById(R.id.masonry_item_img);
            masonry_item_title = itemView.findViewById(R.id.masonry_item_title);
        }
    }
}
