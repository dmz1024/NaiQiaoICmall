package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.ShopBean;
import com.naiqiao.mall.bean.YuCunHuoBean;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class YuCunHuoAdapter extends BaseAdapter<YuCunHuoBean.Data> {

    public YuCunHuoAdapter(Context ctx, ArrayList<YuCunHuoBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_yucunhuo, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        YuCunHuoBean.Data data = list.get(position);
        creatShop(mHolder.rv_shop, data.goods);
        mHolder.tv_sn.setText("订单编号："+data.order_sn);
        mHolder.tv_statu.setText(data.order_status);
        mHolder.tv_price.setText("总价:￥"+data.total_fee+"  运费:￥"+data.shipping_fee);
    }


    private void creatShop(RecyclerView rv_shop, ArrayList<ShopBean> shops) {
        ShopAdapter mAdapter = new ShopAdapter(ctx, shops);
        LinearLayoutManager manager = new LinearLayoutManager(ctx);
        rv_shop.setLayoutManager(manager);
        rv_shop.setAdapter(mAdapter);
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_sn)
        TextView tv_sn;
        @BindView(R.id.tv_statu)
        TextView tv_statu;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.bt_left)
        Button bt_left;
        @BindView(R.id.bt_right)
        Button bt_right;
        @BindView(R.id.rv_shop)
        RecyclerView rv_shop;

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }
}
