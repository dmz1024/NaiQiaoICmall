package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.ShopBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class BackShopAdapter extends BaseAdapter<ShopBean> {

    public BackShopAdapter(Context ctx, ArrayList<ShopBean> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_back_shop, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        Glide.with(ctx).load(TestConstant.IMAGE).into(mHolder.iv_img);
        if(position==getItemCount()-1){
            mHolder.view_line.setVisibility(View.GONE);
        }
    }


    public class ViewHolder extends BaseViewHolder {
//        @BindView(R.id.tv_title)
//        public TextView tv_title;
//        @BindView(R.id.tv_have_count)
//        public TextView tv_have_count;
//        @BindView(R.id.tv_guige)
//        public TextView tv_guige;
//        @BindView(R.id.tv_yj)
//        public TextView tv_yj;
        @BindView(R.id.iv_img)
        public ImageView iv_img;
        @BindView(R.id.view_line)
        public View view_line;

        public ViewHolder(View itemView) {
            super(itemView);
//            tv_have_count = (TextView) itemView.findViewById(R.id.tv_have_count);
//            tv_guige = (TextView) itemView.findViewById(R.id.tv_guige);
//            tv_yj = (TextView) itemView.findViewById(R.id.tv_yj);
//            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {

        }
    }
}
