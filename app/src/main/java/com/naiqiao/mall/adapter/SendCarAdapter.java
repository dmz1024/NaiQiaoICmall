package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AllShopBean;
import com.naiqiao.mall.bean.SendCarBean;
import com.naiqiao.mall.view.AddAndSubView;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class SendCarAdapter extends BaseAdapter<AllShopBean.Data> {

    public SendCarAdapter(Context ctx, ArrayList<AllShopBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_send_car, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        final AllShopBean.Data data = list.get(position);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        mHolder.tv_have_count.setText(Html.fromHtml("剩余：<font color='#f73f5f'><b>" + data.goods_number + "</b></font>瓶"));
        mHolder.tv_title.setText(data.goods_name);
        mHolder.tv_guige.setText("规格：" + data.goods_attr);
        mHolder.tv_price.setText("￥" + data.goods_price);
        mHolder.tv_yj.setText("预警值" + data.warn);

        mHolder.view_aas.setMin(0).setMax(data.goods_number).setCount(data.currenTcount).setOnChangeListener(new AddAndSubView.OnChangeListener() {
            @Override
            public void add() {
                list.get(position).currenTcount = mHolder.view_aas.getCount();
            }

            @Override
            public void sub() {
                list.get(position).currenTcount = mHolder.view_aas.getCount();
            }
        });
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_have_count)
        TextView tv_have_count;
        @BindView(R.id.tv_guige)
        TextView tv_guige;
        @BindView(R.id.tv_yj)
        TextView tv_yj;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.view_aas)
        AddAndSubView view_aas;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {

        }
    }
}
