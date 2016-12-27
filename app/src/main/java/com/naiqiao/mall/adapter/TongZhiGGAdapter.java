package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.TongZhiGGBean;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class TongZhiGGAdapter extends BaseAdapter<TongZhiGGBean.Data> {

    public TongZhiGGAdapter(Context ctx, ArrayList<TongZhiGGBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_tongzhi_gg, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        TongZhiGGBean.Data data = list.get(position);
        mHolder.tv_time.setText(data.add_time);
        mHolder.tv_title.setText(data.short_title);
        mHolder.tv_content.setText(data.content);
    }


    public class ViewHolder extends BaseViewHolder {
        public TextView tv_content;
        public TextView tv_title;
        public TextView tv_time;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            itemView.setOnClickListener(this);

        }


    }
}
