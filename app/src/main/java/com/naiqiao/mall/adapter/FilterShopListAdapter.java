package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.FilterShopListBean;
import com.naiqiao.mall.bean.SendCarBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class FilterShopListAdapter extends BaseAdapter<FilterShopListBean.Data> {

    public FilterShopListAdapter(Context ctx, ArrayList<FilterShopListBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_filter_shop_list, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        FilterShopListBean.Data data = list.get(position);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        mHolder.tv_title.setText(data.goods_name);
        mHolder.tv_price.setText("￥" + data.shop_price);
        mHolder.tv_old_price.setText("￥" + data.market_price);
        mHolder.tv_count.setText("已卖出" + data.p + "件");
    }


    public class ViewHolder extends BaseViewHolder {
        public TextView tv_title;
        public TextView tv_guige;
        public TextView tv_price;
        public TextView tv_yj;
        public TextView tv_count;
        public TextView tv_old_price;
        public ImageView iv_img;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_guige = (TextView) itemView.findViewById(R.id.tv_guige);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            tv_old_price = (TextView) itemView.findViewById(R.id.tv_old_price);
            tv_count = (TextView) itemView.findViewById(R.id.tv_count);
            tv_yj = (TextView) itemView.findViewById(R.id.tv_yj);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            itemView.setOnClickListener(this);
            tv_old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
        }

        @Override
        protected void onClick(int layoutPosition) {

        }
    }
}
