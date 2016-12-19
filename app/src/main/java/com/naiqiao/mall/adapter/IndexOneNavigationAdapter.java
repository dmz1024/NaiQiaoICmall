package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.IndexOneNavigationBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import jp.wasabeef.glide.transformations.CropCircleTransformation;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class IndexOneNavigationAdapter extends BaseAdapter<IndexOneNavigationBean> {

    public IndexOneNavigationAdapter(Context ctx, ArrayList<IndexOneNavigationBean> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_index_one_navigation_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        Glide.with(ctx).load(TestConstant.IMAGE).bitmapTransform(new CropCircleTransformation(ctx)).into(mHolder.iv_img);
    }


    public class ViewHolder extends BaseViewHolder {
        public ImageView iv_img;
        public TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }

    }
}
