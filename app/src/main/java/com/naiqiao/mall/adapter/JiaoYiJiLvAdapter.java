package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.JiaoYiJiLvBean;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class JiaoYiJiLvAdapter extends BaseAdapter<JiaoYiJiLvBean> {
    public JiaoYiJiLvAdapter(Context ctx, ArrayList<JiaoYiJiLvBean> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_jiaoyijilv, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public class ViewHolder extends BaseViewHolder {
        public TextView tv_time;
        public TextView tv_content;
        public TextView tv_count;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            tv_count = (TextView) itemView.findViewById(R.id.tv_count);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {

        }
    }



}
