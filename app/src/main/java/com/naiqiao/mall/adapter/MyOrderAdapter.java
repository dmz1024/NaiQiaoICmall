package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.MyOrderBean;

import base.bean.rxbus.AddFragmentBean;

import com.naiqiao.mall.bean.ShopBean;
import com.naiqiao.mall.fragment.OrderDescFragment;
import com.naiqiao.mall.fragment.PayFragment;
import com.naiqiao.mall.view.pop.ChooseShouhouCountPopView;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;
import util.RxBus;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class MyOrderAdapter extends BaseAdapter<MyOrderBean.Data> {

    public MyOrderAdapter(Context ctx, ArrayList<MyOrderBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_my_order, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        MyOrderBean.Data data = list.get(position);
        creatShop(mHolder.rv_shop, position);
        mHolder.tv_sn.setText("订单编号：" + data.order_sn);
        mHolder.tv_statu.setText(data.order_status);
        mHolder.tv_price.setText("总价:" + data.total_fee + "   运费:" + data.money_paid);


        showBt(mHolder.bt_left, mHolder.bt_right, data.status);
    }

    private void showBt(Button left, Button right, int status) {
        left.setVisibility(View.GONE);
        right.setVisibility(View.GONE);

        switch (status) {
            case 1:
                right.setVisibility(View.VISIBLE);
                right.setText("去支付");
                break;
            case 2:
                right.setVisibility(View.VISIBLE);
                right.setText("申请售后");
                break;
            case 3:
                right.setVisibility(View.VISIBLE);
                left.setVisibility(View.VISIBLE);
                left.setText("取消订单");
                right.setText("去支付");
                break;
            case 4:
                right.setVisibility(View.VISIBLE);
                right.setText("查看物流");
                break;
        }
    }


    private void creatShop(RecyclerView rv_shop, int position) {
        ShopAdapter mAdapter = new ShopAdapter(ctx, list.get(position).goods);
        LinearLayoutManager manager = new LinearLayoutManager(ctx) {
            @Override
            public boolean canScrollVertically() {
                return true;
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
        @BindView(R.id.bt_left)
        Button bt_left;
        @BindView(R.id.bt_right)
        Button bt_right;
        @BindView(R.id.rv_shop)
        RecyclerView rv_shop;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            bt_right.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            MyOrderBean.Data data = list.get(layoutPosition);
            switch (id) {
                case R.id.bt_left:
                    break;
                case R.id.bt_right:
                    switch (data.status) {
                        case 3:
                            int count = 0;
                            for (ShopBean shop : data.goods) {
                                count += shop.goods_number;
                            }
                            RxBus.get().post("addFragment", new AddFragmentBean(PayFragment.getInstance(data.order_id, data.total_fee, count)));
                            break;
                        case 2:
                            new ChooseShouhouCountPopView(ctx,data.goods,data.order_id).showAtLocation(false);
                            break;
                    }

                    break;
            }
        }

        @Override
        protected void onClick(int layoutPosition) {
            RxBus.get().post("addFragment", new AddFragmentBean(OrderDescFragment.getInstance(list.get(layoutPosition).order_id)));
        }
    }
}
