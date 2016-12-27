package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.JiaoYi_JiFen_FanDianBean;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class JiaoYi_JiFen_FanDianAdapter extends BaseAdapter<JiaoYi_JiFen_FanDianBean.Data> {
    public JiaoYi_JiFen_FanDianAdapter(Context ctx, ArrayList<JiaoYi_JiFen_FanDianBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_jiaoyi_jifen_fandian, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mholder = ((ViewHolder) holder);
        JiaoYi_JiFen_FanDianBean.Data data = list.get(position);
        mholder.tv_time.setText(data.change_time);
        mholder.tv_content.setText(data.change_desc);
        mholder.tv_count.setText(data.user_money);
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
