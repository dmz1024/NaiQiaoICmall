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
import com.naiqiao.mall.bean.SendMonadBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class SendMonadAdapter extends BaseAdapter<SendCarBean.Data> {

    public SendMonadAdapter(Context ctx, ArrayList<SendCarBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_send_monad, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        SendCarBean.Data data = list.get(position);
        Glide.with(ctx).load(TestConstant.IMAGE).into(mHolder.iv_img);
        mHolder.tv_have_count.setText(Html.fromHtml("发货数量：<font color='#f73f5f'><b>" + position + "</b></font>瓶"));
        mHolder.iv_choose.setImageResource(data.isChoose ? R.mipmap.icon_checked : R.mipmap.icon_check);
    }


    public class ViewHolder extends BaseViewHolder {
        public TextView tv_title;
        public TextView tv_have_count;
        public TextView tv_guige;
        public TextView tv_yj;
        public ImageView iv_img;
        public ImageView iv_choose;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_have_count = (TextView) itemView.findViewById(R.id.tv_have_count);
            tv_guige = (TextView) itemView.findViewById(R.id.tv_guige);
            tv_yj = (TextView) itemView.findViewById(R.id.tv_yj);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            iv_choose = (ImageView) itemView.findViewById(R.id.iv_choose);
            itemView.setOnClickListener(this);
            iv_choose.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {

        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            if (id == R.id.iv_choose) {
                iv_choose.setImageResource((list.get(layoutPosition).isChoose = !list.get(layoutPosition).isChoose) ? R.mipmap.icon_checked : R.mipmap.icon_check);
                choose();
            }
        }
    }


    protected void choose(){

    }
}
