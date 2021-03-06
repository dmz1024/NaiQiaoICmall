package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.DaoHuoTZBean;
import com.naiqiao.mall.bean.TongZhiGGBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class DaoHuoTZAdapter extends BaseAdapter<DaoHuoTZBean.Data> {
    private boolean isTz;

    public DaoHuoTZAdapter(Context ctx, ArrayList<DaoHuoTZBean.Data> list, boolean isTz) {
        super(ctx, list);
        this.isTz = isTz;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_daohuo_tz, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        DaoHuoTZBean.Data data = list.get(position);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        mHolder.tv_title.setText(data.goods_name);
        mHolder.tv_content.setText("您的产品'" + data.goods_name + "'已不足，请尽快进货");
        if(!isTz){
            mHolder.tv_time.setVisibility(View.GONE);
        }else {

        }
    }


    public class ViewHolder extends BaseViewHolder {
        public TextView tv_content;
        public TextView tv_title;
        public TextView tv_time;
        public Button bt_buy;
        public ImageView iv_img;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            bt_buy = (Button) itemView.findViewById(R.id.bt_buy);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            itemView.setOnClickListener(this);

        }


    }
}
