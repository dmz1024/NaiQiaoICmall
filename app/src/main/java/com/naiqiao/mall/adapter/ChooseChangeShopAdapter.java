package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AllShopBean;
import com.naiqiao.mall.bean.ChangeShopBean;
import com.naiqiao.mall.view.AddAndSubView;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;

import static com.naiqiao.mall.R.id.tv_count;
import static com.naiqiao.mall.R.id.tv_yj;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class ChooseChangeShopAdapter extends BaseAdapter<ChangeShopBean.Data> {

    public ChooseChangeShopAdapter(Context ctx, ArrayList<ChangeShopBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_change_shop, null));
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = ((ViewHolder) holder);
        Glide.with(ctx).load(TestConstant.IMAGE).into(mHolder.iv_img);
    }

    public class ViewHolder extends BaseViewHolder {
        public TextView tv_title;
        public TextView tv_price;
        public TextView tv_have_count;
        public ImageView iv_img;
        public AddAndSubView view_as;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            view_as = (AddAndSubView) itemView.findViewById(R.id.view_as);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            tv_have_count = (TextView) itemView.findViewById(R.id.tv_have_count);
        }
    }

}
