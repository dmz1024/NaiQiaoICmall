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
import com.naiqiao.mall.bean.HotProblemBean;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class HotProblemAdapter extends BaseAdapter<HotProblemBean.Data> {

    public HotProblemAdapter(Context ctx, ArrayList<HotProblemBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx,R.layout.item_hot_problem, null));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = ((ViewHolder) holder);
        HotProblemBean.Data data = list.get(position);
        mHolder.tv_title.setText(data.title);
        mHolder.view.setVisibility(position == list.size() - 1 ? View.GONE : View.VISIBLE);
    }

    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.view)
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

        }
    }

}
