package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.MyOrderBackBean;
import com.naiqiao.mall.bean.ShopBean;
import com.naiqiao.mall.fragment.BackShopDescFragment;
import com.naiqiao.mall.fragment.OrderDescFragment;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.bean.rxbus.AddFragmentBean;
import butterknife.BindView;
import util.RxBus;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class MyOrderBackAdapter extends BaseAdapter<MyOrderBackBean.Data> {

    public MyOrderBackAdapter(Context ctx, ArrayList<MyOrderBackBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_my_order_back, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        MyOrderBackBean.Data data = list.get(position);
        creatShop(mHolder.rv_shop, data.goods);
        mHolder.tv_price.setText("总价:￥" + data.amount + "   实付:￥" + data.money_paid);
        mHolder.tv_statu.setText(data.status);
        mHolder.tv_sn.setText("订单编号："+data.order_sn);
    }


    private void creatShop(RecyclerView rv_shop, ArrayList<ShopBean> shops) {
        ShopAdapter mAdapter = new ShopAdapter(ctx, shops);
        LinearLayoutManager manager = new LinearLayoutManager(ctx) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
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
        @BindView(R.id.rv_shop)
        RecyclerView rv_shop;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {

        }

        @Override
        protected void onClick(int layoutPosition) {
            RxBus.get().post("addFragment", new AddFragmentBean(BackShopDescFragment.getInstance(list.get(layoutPosition).back_id)));
        }
    }
}
