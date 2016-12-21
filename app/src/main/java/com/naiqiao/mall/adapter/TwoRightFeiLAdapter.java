package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.TwoRightBean;
import com.naiqiao.mall.fragment.FilterShopContentFragment;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.bean.rxbus.AddFragmentBean;
import util.RxBus;
import util.Util;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class TwoRightFeiLAdapter extends BaseAdapter<TwoRightBean.Data.Data3Bean> {

    public TwoRightFeiLAdapter(Context ctx, ArrayList<TwoRightBean.Data.Data3Bean> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_two_right_fell_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        TwoRightBean.Data.Data3Bean data = list.get(position);
        Glide.with(ctx).load(data.cat_image).into(mHolder.iv_img);
        mHolder.tv_title.setText(data.name);
    }


    public class ViewHolder extends BaseViewHolder {
        public ImageView iv_img;
        public TextView tv_title;
        private LinearLayout.LayoutParams imgParams;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            if (imgParams == null) {
                imgParams = ((LinearLayout.LayoutParams) iv_img.getLayoutParams());
                imgParams.height = (((Util.getWidth()) / 9) * 7 - Util.dp2Px(20)) / 3;
            }
            iv_img.setLayoutParams(imgParams);

            itemView.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {
            RxBus.get().post("addFragment", new AddFragmentBean(FilterShopContentFragment.getInstance(list.get(layoutPosition).id, 0,list.get(layoutPosition).name)));
        }
    }
}
