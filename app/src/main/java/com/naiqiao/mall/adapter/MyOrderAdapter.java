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
import com.naiqiao.mall.fragment.OrderDescFragment;
import com.naiqiao.mall.view.pop.ChooseShouhouCountPopView;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
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
    }


    private void creatShop(RecyclerView rv_shop, int position) {
        ShopAdapter mAdapter = new ShopAdapter(ctx, list.get(position).shops);
        LinearLayoutManager manager = new LinearLayoutManager(ctx);
        rv_shop.setLayoutManager(manager);
        rv_shop.setAdapter(mAdapter);
    }


    public class ViewHolder extends BaseViewHolder {
        public TextView tv_sn;
        public TextView tv_statu;
        public TextView tv_price;
        public Button bt_left;
        public Button bt_right;
        public RecyclerView rv_shop;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_sn = (TextView) itemView.findViewById(R.id.tv_sn);
            tv_statu = (TextView) itemView.findViewById(R.id.tv_statu);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            bt_left = (Button) itemView.findViewById(R.id.bt_left);
            bt_right = (Button) itemView.findViewById(R.id.bt_right);
            rv_shop = (RecyclerView) itemView.findViewById(R.id.rv_shop);
            itemView.setOnClickListener(this);
            bt_right.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            switch (id){
                case R.id.bt_left:
                    break;
                case R.id.bt_right:
                    new ChooseShouhouCountPopView(ctx).showAtLocation(false);
                    break;
            }
        }

        @Override
        protected void onClick(int layoutPosition) {
            RxBus.get().post("addFragment",new AddFragmentBean(new OrderDescFragment()));
        }
    }
}
