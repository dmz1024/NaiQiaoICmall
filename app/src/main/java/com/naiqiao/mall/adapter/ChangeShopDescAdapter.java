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

//    @Override
//    public int getItemViewType(int position) {
//        return position;
//    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        ChangeShopDescBean.Data data = list.get(position);

        mHolder.tv_title.setText(position==0?"虚拟仓商品":"新进商品");
        mHolder.tv_more.setText(list.get(position).isMore ? "收起" : "展开");
        mHolder.tv_more.setVisibility(data.goods.size() <= 2 ? View.GONE : View.VISIBLE);
        mHolder.tv_price.setText("共"+data.count.goods_count+"件商品    总价值￥"+data.count.total_fee);
        creatShop(mHolder.rv_shop, data.goods, data.isMore);
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
        public TextView tv_price;

        public ViewHolder(View itemView) {
            super(itemView);
            rv_shop = (RecyclerView) itemView.findViewById(R.id.rv_shop);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_more = (TextView) itemView.findViewById(R.id.tv_more);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
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
