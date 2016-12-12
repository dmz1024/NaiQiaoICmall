package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.SendCarBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class WriteSendCarAdapter extends BaseAdapter<SendCarBean.Data> {

    public WriteSendCarAdapter(Context ctx, ArrayList<SendCarBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_write_send_car, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        Glide.with(ctx).load(TestConstant.IMAGE).into(mHolder.iv_img);
        if(position==getItemCount()-1){
            mHolder.view.setVisibility(View.GONE);
        }else {
            mHolder.view.setVisibility(View.VISIBLE);
        }
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_count)
        TextView tv_count;
        @BindView(R.id.tv_guige)
        TextView tv_guige;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.view)
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
        }

    }
}
