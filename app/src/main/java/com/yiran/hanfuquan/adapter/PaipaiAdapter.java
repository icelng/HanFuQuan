package com.yiran.hanfuquan.adapter;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yiran.hanfuquan.R;

import java.util.ArrayList;

/**
 * Created by yiran on 2017/9/1.
 */

public class PaipaiAdapter extends RecyclerView.Adapter<PaipaiAdapter.ViewHolder>{

    private Context context;
    private ArrayList<AdapterCellData> datas = new ArrayList<>();

    public PaipaiAdapter(Context context){
        this.context = context;
    }

    public void add(String titleName, String imgUrl){
        AdapterCellData adapterCellData = new AdapterCellData(titleName, imgUrl);
        datas.add(adapterCellData);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_paipai, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AdapterCellData data = datas.get(position);
        Glide.with(context).load(data.imgUrl).into(holder.iv);
        holder.tvTitle.setText(data.title);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private static class AdapterCellData{
        public  AdapterCellData(String title, String imgUrl){
            this.title = title;
            this.imgUrl = imgUrl;
        }
        public String title;
        public String imgUrl;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cv;
        public TextView tvTitle;
        public ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.paipai_item);
            tvTitle = (TextView) itemView.findViewById(R.id.paipai_item_title);
            iv = (ImageView) itemView.findViewById(R.id.paipai_item_show_img);
        }
    }
}
