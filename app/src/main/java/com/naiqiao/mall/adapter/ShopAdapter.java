package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.ShopBean;
import com.naiqiao.mall.bean.ZaiTuDingDanBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class ShopAdapter extends BaseAdapter<ShopBean> {

    public ShopAdapter(Context ctx, ArrayList<ShopBean> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_shop, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        ShopBean data = list.get(position);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        if (position == getItemCount() - 1) {
            mHolder.view_line.setVisibility(View.GONE);
        }
        mHolder.tv_title.setText(data.goods_name);
        mHolder.tv_guige.setText("规格：" + data.goods_attr);
        mHolder.tv_price.setText(data.goods_price + "元");
        mHolder.tv_old_price.setText("￥" + data.market_price + "元");
        mHolder.tv_count.setText("x" + data.goods_number);

    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.iv_img)
        public ImageView iv_img;
        @BindView(R.id.view_line)
        public View view_line;
        @BindView(R.id.tv_title)
        public TextView tv_title;
        @BindView(R.id.tv_guige)
        public TextView tv_guige;
        @BindView(R.id.tv_price)
        public TextView tv_price;
        @BindView(R.id.tv_old_price)
        public TextView tv_old_price;
        @BindView(R.id.tv_count)
        public TextView tv_count;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
        }

        @Override
        protected void onClick(int layoutPosition) {

        }
    }
}
