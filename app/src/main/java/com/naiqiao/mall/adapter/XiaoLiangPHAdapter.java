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
import com.naiqiao.mall.bean.JiaoYiJiLvBean;
import com.naiqiao.mall.bean.XiaoLiangPHBean;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import util.Util;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class XiaoLiangPHAdapter extends BaseAdapter<XiaoLiangPHBean.Data> {
    private int itemLenght;

    public XiaoLiangPHAdapter(Context ctx, ArrayList<XiaoLiangPHBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_xiao_liang_ph, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = (ViewHolder) holder;
        if (position == 0) {
            itemLenght = Util.getWidth() / (list.get(position).length * 2);
            Log.d("itemLenght", Util.getWidth() + "");
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mHolder.rl_length.getLayoutParams();
            layoutParams.width = (Util.getWidth() / 2) + (list.get(position).length * itemLenght);

            Log.d("ddd", ((Util.getWidth() / 2) + (list.get(position).length * itemLenght)) + "");
            mHolder.rl_length.setLayoutParams(layoutParams);
        }

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
        mHolder.tv_count.setText(list.get(position).length+"");
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
