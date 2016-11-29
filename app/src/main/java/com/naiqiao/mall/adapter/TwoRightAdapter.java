package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.TwoLeftBean;
import com.naiqiao.mall.bean.TwoRightBean;
import com.naiqiao.mall.bean.rxbus.ChangeTwoRightBean;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class TwoRightAdapter extends BaseAdapter<TwoRightBean.Data> {
    public static final int SHOW_TYPE_IMAGE = 1;
    public static final int SHOW_TYPE_TUIJIAN = 2;
    public static final int SHOW_TYPE_FENLEI = 3;

    public TwoRightAdapter(Context ctx, ArrayList<TwoRightBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SHOW_TYPE_FENLEI || viewType == SHOW_TYPE_TUIJIAN)
            return new TitleFenleiViewHolder(View.inflate(ctx, R.layout.item_two_right_fenlei, null));
        else
            return new ImageViewHolder(View.inflate(ctx, R.layout.item_two_right_img, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TitleFenleiViewHolder) {
            TitleFenleiViewHolder mHolder = (TitleFenleiViewHolder) holder;
        } else if (holder instanceof TitleTuijianViewHolder) {
            TitleTuijianViewHolder mHolder = (TitleTuijianViewHolder) holder;
        } else {
            ImageViewHolder mHolder = (ImageViewHolder) holder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        int type = list.get(position).type;
        if (type == 3)
            return SHOW_TYPE_FENLEI;
        else if (type == 2)
            return SHOW_TYPE_TUIJIAN;
        return SHOW_TYPE_IMAGE;
    }

    public class TitleTuijianViewHolder extends BaseViewHolder {

        public TitleTuijianViewHolder(View itemView) {
            super(itemView);
        }

    }

    public class TitleFenleiViewHolder extends BaseViewHolder {

        public TitleFenleiViewHolder(View itemView) {
            super(itemView);

        }

    }

    public class ImageViewHolder extends BaseViewHolder {

        public ImageViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onClick(int layoutPosition) {

        }
    }
}
