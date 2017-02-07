package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.XiaoLiangPHBean;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import util.JLogUtils;
import util.Util;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class XiaoLiangPHAdapter extends BaseAdapter<XiaoLiangPHBean.Data> {
    private float itemLenght;
    private int width;

    public XiaoLiangPHAdapter(Context ctx, ArrayList<XiaoLiangPHBean.Data> list) {
        super(ctx, list);
        width = (Util.getWidth() - Util.dp2Px(20)) / 2;
        JLogUtils.D("高"+width);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_xiao_liang_ph, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = (ViewHolder) holder;
        XiaoLiangPHBean.Data data = list.get(position);
        if (position == 0) {
            itemLenght = width / (data.a_sale);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mHolder.rl_length.getLayoutParams();
            layoutParams.width = 2 * width;
            mHolder.rl_length.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mHolder.rl_length.getLayoutParams();
            layoutParams.width = (int) (width + (data.a_sale * itemLenght));
            JLogUtils.D("width"+(int) (width + (data.a_sale * itemLenght)));
            mHolder.rl_length.setLayoutParams(layoutParams);
        }

        mHolder.tv_name.setText(data.name);
        if (position <= 2) {
            mHolder.tv_name.setTextColor(Color.parseColor("#f73f5f"));
            mHolder.tv_top.setTextSize(18 - position);
            mHolder.tv_name.setTextSize(18 - position);
        } else {
            mHolder.tv_name.setTextColor(Color.parseColor("#676767"));
            mHolder.tv_top.setTextSize(16);
            mHolder.tv_name.setTextSize(16);
        }
        mHolder.tv_top.setText("TOP" + (position + 1));
        mHolder.tv_count.setText(data.a_sale + "");
    }

    public class ViewHolder extends BaseViewHolder {
        public TextView tv_top;
        public TextView tv_name;
        public TextView tv_count;
        public RelativeLayout rl_length;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_top = (TextView) itemView.findViewById(R.id.tv_top);
            tv_count = (TextView) itemView.findViewById(R.id.tv_count);
            rl_length = (RelativeLayout) itemView.findViewById(R.id.rl_length);
        }

    }


}
