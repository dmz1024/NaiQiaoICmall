package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.TwoLeftBean;
import com.naiqiao.mall.bean.TwoRightBean;
import com.naiqiao.mall.bean.rxbus.ChangeTwoRightBean;

import java.util.ArrayList;
import java.util.List;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.other.ItemDecoration;
import util.RxBus;
import view.TitleRelativeLayout;

/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class TwoRightAdapter extends BaseAdapter<TwoRightBean.Data> {
    public static final int SHOW_TYPE_IMAGE = 1;
    public static final int SHOW_TYPE_TUIJIAN = 2;
    public static final int SHOW_TYPE_FENLEI = 3;
    private boolean isCreat;

    public TwoRightAdapter(Context ctx, ArrayList<TwoRightBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SHOW_TYPE_FENLEI)
            return new TitleFenleiViewHolder(View.inflate(ctx, R.layout.item_two_right_fenlei, null));
        else if (viewType == SHOW_TYPE_TUIJIAN)
            return new TitleTuijianViewHolder(View.inflate(ctx, R.layout.item_two_right_fenlei, null));
        else
            return new ImageViewHolder(View.inflate(ctx, R.layout.item_two_right_img, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TwoRightBean.Data data = list.get(position);
        if (holder instanceof TitleFenleiViewHolder) {
            TitleFenleiViewHolder mHolder = (TitleFenleiViewHolder) holder;
            mHolder.trl_title.setTitle(data.title + " | " + data.othername);
            mHolder.trl_title.setContent("排行榜");
            creatFeil(mHolder.rv_content, position);
        } else if (holder instanceof TitleTuijianViewHolder) {
            TitleTuijianViewHolder mHolder = (TitleTuijianViewHolder) holder;
            mHolder.trl_title.setTitle(data.title + "|" + data.othername);
            mHolder.trl_title.setContent("更多推荐");
            creatTuij(mHolder.rv_content, position);
        } else {
            ImageViewHolder mHolder = (ImageViewHolder) holder;
            Glide.with(ctx).load(data.data1.get(0).ad_image).into(mHolder.iv_ad);
        }
    }


    private void creatTuij(RecyclerView rv_content, int position) {
        GridLayoutManager manager = new GridLayoutManager(ctx, 3);
        TwoRightTuiJAdapter mAdapter = new TwoRightTuiJAdapter(ctx, list.get(position).data2);
        rv_content.setAdapter(mAdapter);
        rv_content.setLayoutManager(manager);
        if (!isCreat) {
            isCreat = true;
            rv_content.addItemDecoration(new ItemDecoration(ctx, LinearLayoutManager.HORIZONTAL, 1, "#f5f5f5"));
        }
    }

    private void creatFeil(RecyclerView rv_content, int position) {
        GridLayoutManager manager = new GridLayoutManager(ctx, 3);
        TwoRightFeiLAdapter mAdapter = new TwoRightFeiLAdapter(ctx, list.get(position).data3);
        rv_content.setAdapter(mAdapter);
        rv_content.setLayoutManager(manager);
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
        public TitleRelativeLayout trl_title;
        public RecyclerView rv_content;

        public TitleTuijianViewHolder(View itemView) {
            super(itemView);
            trl_title = (TitleRelativeLayout) itemView.findViewById(R.id.trl_title);
            rv_content = (RecyclerView) itemView.findViewById(R.id.rv_content);
        }
    }

    public class TitleFenleiViewHolder extends BaseViewHolder {
        public TitleRelativeLayout trl_title;
        public RecyclerView rv_content;

        public TitleFenleiViewHolder(View itemView) {
            super(itemView);
            trl_title = (TitleRelativeLayout) itemView.findViewById(R.id.trl_title);
            rv_content = (RecyclerView) itemView.findViewById(R.id.rv_content);
        }

    }

    public class ImageViewHolder extends BaseViewHolder {
        public ImageView iv_ad;

        public ImageViewHolder(View itemView) {
            super(itemView);
            iv_ad = (ImageView) itemView.findViewById(R.id.iv_img);
        }

        @Override
        protected void onClick(int layoutPosition) {

        }
    }


}
