package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.IndexOneBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class IndexOneDesenoAdapter extends BaseAdapter<IndexOneBean.HeaderBean.Data3Bean> {

    public IndexOneDesenoAdapter(Context ctx, ArrayList<IndexOneBean.HeaderBean.Data3Bean> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_index_one_deseno, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        IndexOneBean.HeaderBean.Data3Bean data = list.get(position);
        Glide.with(ctx).load(data.thumb).into(mHolder.iv_img);
        mHolder.tv_start_time.setText(data.start_time);
        mHolder.tv_title.setText(data.act_name);
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.tv_start_time)
        TextView tv_start_time;
        @BindView(R.id.tv_title)
        TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);

        }

    }
}
