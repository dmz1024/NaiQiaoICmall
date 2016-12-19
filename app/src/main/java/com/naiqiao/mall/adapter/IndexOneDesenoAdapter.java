package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AddressBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class IndexOneDesenoAdapter extends BaseAdapter<AddressBean.Data> {

    public IndexOneDesenoAdapter(Context ctx, ArrayList<AddressBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_index_one_deseno, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        Glide.with(ctx).load(TestConstant.IMAGE).into(mHolder.iv_img);
    }


    public class ViewHolder extends BaseViewHolder {
        public ImageView iv_img;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
        }

    }
}
