package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.ChangeShopDescBean;
import com.naiqiao.mall.bean.ShopBean;

import java.util.ArrayList;
import java.util.List;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class ChangeShopDescAdapter extends BaseAdapter<ChangeShopDescBean.Data> {

    public ChangeShopDescAdapter(Context ctx, ArrayList<ChangeShopDescBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_change_shop_desc, null));
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        ChangeShopDescBean.Data data = list.get(position);
        mHolder.tv_title.setText(data.title);
        mHolder.tv_more.setText(list.get(position).isMore ? "收起" : "展开");
        mHolder.tv_more.setVisibility(data.shops.size() <= 2 ? View.GONE : View.VISIBLE);
        creatShop(mHolder.rv_shop, data.shops, data.isMore);
    }

    private void creatShop(RecyclerView rv_shop, ArrayList<ShopBean> shops, boolean isMore) {
        ChangeShopItemAdapter mAdapter;
        if (isMore || shops.size() < 2) {
            mAdapter = new ChangeShopItemAdapter(ctx, shops);
        } else {
            ArrayList<ShopBean> arrayList = new ArrayList<>();
            arrayList.add(shops.get(0));
            arrayList.add(shops.get(1));
            mAdapter = new ChangeShopItemAdapter(ctx, arrayList);
        }
        LinearLayoutManager manager = new LinearLayoutManager(ctx);
        rv_shop.setAdapter(mAdapter);
        rv_shop.setLayoutManager(manager);
    }


    public class ViewHolder extends BaseViewHolder {
        public RecyclerView rv_shop;
        public TextView tv_title;
        public TextView tv_more;

        public ViewHolder(View itemView) {
            super(itemView);
            rv_shop = (RecyclerView) itemView.findViewById(R.id.rv_shop);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_more = (TextView) itemView.findViewById(R.id.tv_more);
            tv_more.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            switch (id) {
                case R.id.tv_more:
                    more(layoutPosition);
                    break;
            }
        }
    }

    private void more(int layoutPosition) {
        list.get(layoutPosition).isMore = !list.get(layoutPosition).isMore;
        notifyDataSetChanged();
    }


}
