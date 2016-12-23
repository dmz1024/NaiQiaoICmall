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
import butterknife.BindView;


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
        AllShopBean.Data data = list.get(position);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        mHolder.tv_title.setText(data.goods_name);
        mHolder.tv_guige.setText("规格：" + data.goods_attr);
        mHolder.tv_have_count.setText("剩余" + data.goods_number);
        mHolder.tv_price.setText("￥" + data.goods_price);
        mHolder.tv_count.setText("销量：" + data.sale + "件");
        mHolder.tv_yj.setText("预警值" + data.warn);
    }

    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_guige)
        TextView tv_guige;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.tv_have_count)
        TextView tv_have_count;
        @BindView(R.id.tv_count)
        TextView tv_count;
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.tv_yj)
        TextView tv_yj;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }
    }

}
