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
import com.naiqiao.mall.bean.MyCollectBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class MyCollectAdapter extends BaseAdapter<MyCollectBean.Data> {
    private boolean isVertical = true;

    public void setVertical(boolean vertical) {
        isVertical = vertical;
    }

    public MyCollectAdapter(Context ctx, ArrayList<MyCollectBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return isVertical ? new VerticalViewHolder(View.inflate(ctx, R.layout.item_my_collect_vertical, null)) : new HorizontalViewHolder(View.inflate(ctx, R.layout.item_my_collect_horizontal, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VerticalViewHolder) {
            VerticalViewHolder mHolder = ((VerticalViewHolder) holder);
            Glide.with(ctx).load(TestConstant.IMAGE).into(mHolder.iv_img);
        }else {
            HorizontalViewHolder mHolder = ((HorizontalViewHolder) holder);
            Glide.with(ctx).load(TestConstant.IMAGE).into(mHolder.iv_img);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return 2;
    }

    public class VerticalViewHolder extends BaseViewHolder {
        public TextView tv_guige;
        public TextView tv_title;
        public TextView tv_price;
        public Button bt_add;
        public ImageView iv_img;
        public ImageView iv_delete;

        public VerticalViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_guige = (TextView) itemView.findViewById(R.id.tv_guige);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            bt_add = (Button) itemView.findViewById(R.id.bt_add);
            iv_delete = (ImageView) itemView.findViewById(R.id.iv_delete);
            itemView.setOnClickListener(this);
        }
    }

    public class HorizontalViewHolder extends BaseViewHolder {
        public TextView tv_guige;
        public TextView tv_title;
        public TextView tv_price;
        public Button bt_add;
        public ImageView iv_img;
        public ImageView iv_delete;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_guige = (TextView) itemView.findViewById(R.id.tv_guige);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            bt_add = (Button) itemView.findViewById(R.id.bt_add);
            iv_delete = (ImageView) itemView.findViewById(R.id.iv_delete);
            itemView.setOnClickListener(this);
        }
    }
}
