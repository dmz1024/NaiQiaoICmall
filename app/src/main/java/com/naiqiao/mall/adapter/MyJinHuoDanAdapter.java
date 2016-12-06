package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.MyJinHuoDanBean;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class MyJinHuoDanAdapter extends BaseAdapter<MyJinHuoDanBean.Data> {

    public MyJinHuoDanAdapter(Context ctx, ArrayList<MyJinHuoDanBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_my_jinhuodan, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        MyJinHuoDanBean.Data data = list.get(position);
        Glide.with(ctx).load(TestConstant.IMAGE).into(mHolder.iv_img);
        mHolder.iv_choose.setImageResource(data.isChoose ? R.mipmap.icon_checked : R.mipmap.icon_check);
    }


    public class ViewHolder extends BaseViewHolder {
        public TextView tv_title;
        public TextView tv_have_count;
        public TextView tv_price;
        public TextView tv_old_price;
        public TextView tv_guige;
        public ImageView iv_img;
        public ImageView iv_choose;
        public TextView tv_total;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_have_count = (TextView) itemView.findViewById(R.id.tv_have_count);
            tv_guige = (TextView) itemView.findViewById(R.id.tv_guige);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            iv_choose = (ImageView) itemView.findViewById(R.id.iv_choose);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            tv_old_price = (TextView) itemView.findViewById(R.id.tv_old_price);
            tv_total = (TextView) itemView.findViewById(R.id.tv_total);
            itemView.setOnClickListener(this);
            iv_choose.setOnClickListener(this);
            tv_old_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线
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
