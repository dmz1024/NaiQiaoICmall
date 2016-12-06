package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.FilterShopListBean;
import com.naiqiao.mall.bean.ZaiTuDingDanBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class ZaiTuDingDanAdapter extends BaseAdapter<ZaiTuDingDanBean.Data> {

    public ZaiTuDingDanAdapter(Context ctx, ArrayList<ZaiTuDingDanBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_zai_tu_ding_dan, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        creatShop(mHolder.rv_shop, position);
    }


    private void creatShop(RecyclerView rv_shop, int position) {
        ZaiTuDingDanShopAdapter mAdapter = new ZaiTuDingDanShopAdapter(ctx, list.get(position).shops);
        LinearLayoutManager manager = new LinearLayoutManager(ctx);
        rv_shop.setLayoutManager(manager);
        rv_shop.setAdapter(mAdapter);
    }


    public class ViewHolder extends BaseViewHolder {
        public TextView tv_sn;
        public TextView tv_statu;
        public TextView tv_price;
        public Button bt_show;
        public RecyclerView rv_shop;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_sn = (TextView) itemView.findViewById(R.id.tv_sn);
            tv_statu = (TextView) itemView.findViewById(R.id.tv_statu);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            bt_show = (Button) itemView.findViewById(R.id.bt_show);
            rv_shop = (RecyclerView) itemView.findViewById(R.id.rv_shop);
        }


    }
}
