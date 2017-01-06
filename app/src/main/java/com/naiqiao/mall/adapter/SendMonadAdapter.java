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
import com.naiqiao.mall.bean.SendMonadBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class SendMonadAdapter extends BaseAdapter<AllShopBean.Data> {

    public SendMonadAdapter(Context ctx, ArrayList<AllShopBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_send_monad, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        AllShopBean.Data data = list.get(position);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        mHolder.tv_have_count.setText(Html.fromHtml("发货数量：<font color='#f73f5f'><b>" + data.currenTcount + "</b></font>瓶"));
        mHolder.iv_choose.setImageResource(data.isChoose == 0 ? R.mipmap.icon_checked : R.mipmap.icon_check);
        mHolder.tv_guige.setText("规格:" + data.goods_attr);
        mHolder.tv_yj.setText("预警值" + data.warn);
        mHolder.tv_title.setText(data.goods_name);
        mHolder.tv_price.setText("￥" + data.goods_price);

    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.tv_have_count)
        TextView tv_have_count;
        @BindView(R.id.tv_guige)
        TextView tv_guige;
        @BindView(R.id.tv_yj)
        TextView tv_yj;
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.iv_choose)
        ImageView iv_choose;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            iv_choose.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {

        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            if (id == R.id.iv_choose) {

                iv_choose.setImageResource((list.get(layoutPosition).isChoose = list.get(layoutPosition).isChoose == 0 ? 1 : 0) == 0 ? R.mipmap.icon_checked : R.mipmap.icon_check);
                choose();
            }
        }
    }


    protected void choose() {

    }
}
