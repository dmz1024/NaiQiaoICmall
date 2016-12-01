package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.SendCarBean;
import com.naiqiao.mall.bean.TwoRightBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import util.Util;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class TwoRightTuiJAdapter extends BaseAdapter<TwoRightBean.Data.Data2Bean> {

    public TwoRightTuiJAdapter(Context ctx, ArrayList<TwoRightBean.Data.Data2Bean> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_60_image, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        Glide.with(ctx).load(list.get(position).brand_logo).into(mHolder.iv_img);
    }


    public class ViewHolder extends BaseViewHolder {
        public ImageView iv_img;
        private FrameLayout.LayoutParams layoutParams;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            if (layoutParams == null) {
                layoutParams = (FrameLayout.LayoutParams) iv_img.getLayoutParams();
                layoutParams.height = (int) (((((Util.getWidth()) / 9) * 7 - Util.dp2Px(20)) / 3) / 1.3);
            }
            iv_img.setLayoutParams(layoutParams);
        }

        @Override
        protected void onClick(int layoutPosition) {

        }
    }
}
