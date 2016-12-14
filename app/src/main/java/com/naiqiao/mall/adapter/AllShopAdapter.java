package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AllShopBean;
import com.naiqiao.mall.bean.MyCollectBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class AllShopAdapter extends BaseAdapter<AllShopBean.Data> {
    private int type = 1;

    public void setVertical(int type) {
        this.type = type;
    }

    public AllShopAdapter(Context ctx, ArrayList<AllShopBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, type == 1 ? R.layout.item_all_shop_vertical : R.layout.item_all_shop_horizontal, null));
    }


    @Override
    public int getItemViewType(int position) {
        return type;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = ((ViewHolder) holder);
        Glide.with(ctx).load(TestConstant.IMAGE).into(mHolder.iv_img);
    }

    public class ViewHolder extends BaseViewHolder {
        public TextView tv_guige;
        public TextView tv_title;
        public TextView tv_price;
        public TextView tv_have_count;
        public TextView tv_count;
        public ImageView iv_img;
        public TextView tv_yj;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_guige = (TextView) itemView.findViewById(R.id.tv_guige);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            tv_yj = (TextView) itemView.findViewById(R.id.tv_yj);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            tv_have_count = (TextView) itemView.findViewById(R.id.tv_have_count);
            tv_count = (TextView) itemView.findViewById(R.id.tv_count);
            itemView.setOnClickListener(this);
        }
    }

}
