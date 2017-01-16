package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.ShopBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class ChangeShopItemAdapter extends BaseAdapter<ShopBean> {

    public ChangeShopItemAdapter(Context ctx, ArrayList<ShopBean> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_only_back_money, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        ShopBean data = list.get(position);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        mHolder.tv_title.setText(data.goods_name);
        mHolder.tv_price.setText("￥" + data.goods_price);
        mHolder.tv_count.setText("x" + data.goods_number);
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        public TextView tv_title;
        @BindView(R.id.tv_count)
        public TextView tv_count;
        @BindView(R.id.tv_price)
        public TextView tv_price;
        @BindView(R.id.iv_img)
        public ImageView iv_img;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
