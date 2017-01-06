package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.JiFenShopBean;
import com.naiqiao.mall.view.pop.JifenDuiHuanCountPopView;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class JiFenShopTeJiaAdapter extends BaseAdapter<JiFenShopBean.Data> {
    private int type = 0;

    public JiFenShopTeJiaAdapter(Context ctx, ArrayList<JiFenShopBean.Data> list) {
        super(ctx, list);
    }

    public JiFenShopTeJiaAdapter(Context ctx, ArrayList<JiFenShopBean.Data> list, int type) {
        this(ctx, list);
        this.type = type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, type == 0 ? R.layout.item_jifen_tejia : R.layout.item_jifen_all, null));
    }

    @Override
    public int getItemViewType(int position) {
        return type;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        double jifen = 1234;
        double price = 123;
        JiFenShopBean.Data data = list.get(position);
        mHolder.tv_title.setText(data.goods_name);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        mHolder.tv_shi.setText("市场价：￥" + data.market_price);
        mHolder.tv_price.setText(Html.fromHtml(type == 0 ? "<font color='#f73f5f'><b>" + data.exchange_integral + "</b></font>积分+<font color='#f73f5f'><b>" + data.shop_price + "</b></font>元" : "<font color='#f73f5f'><b>" + data.exchange_integral + "</b></font>积分"));
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.tv_shi)
        TextView tv_shi;
        @BindView(R.id.bt_dui)
        Button bt_dui;

        public ViewHolder(View itemView) {
            super(itemView);
            bt_dui.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            new JifenDuiHuanCountPopView(ctx).showAtLocation(false);
        }
    }
}
