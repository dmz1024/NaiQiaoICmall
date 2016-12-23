package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.DaoHuoTZBean;
import com.naiqiao.mall.bean.MyCollectBean;
import com.naiqiao.mall.bean.rxbus.CollectRxbus;
import com.naiqiao.mall.controller.MyCollectController;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import view.pop.TipMessage;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class MyCollectAdapter extends BaseAdapter<MyCollectBean.Data> {
    private int type = 1;

    public void setVertical(int type) {
        this.type = type;
    }


    public MyCollectAdapter(Context ctx, ArrayList<MyCollectBean.Data> list) {
        super(ctx, list);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, type == 1 ? R.layout.item_my_collect_vertical : R.layout.item_my_collect_horizontal, null));
    }


    @Override
    public int getItemViewType(int position) {
        return type;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder mHolder = ((ViewHolder) holder);
        MyCollectBean.Data data = list.get(position);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        mHolder.tv_price.setText(data.shop_price);
        mHolder.tv_title.setText(data.goods_name);
        mHolder.tv_guige.setText("规格："+data.goods_attr);
    }

    public class ViewHolder extends BaseViewHolder {
        public TextView tv_guige;
        public TextView tv_title;
        public TextView tv_price;
        public Button bt_add;
        public ImageView iv_img;
        public ImageView iv_delete;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_guige = (TextView) itemView.findViewById(R.id.tv_guige);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            bt_add = (Button) itemView.findViewById(R.id.bt_add);
            iv_delete = (ImageView) itemView.findViewById(R.id.iv_delete);
            itemView.setOnClickListener(this);
            iv_delete.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, final int layoutPosition) {
            switch (id) {
                case R.id.iv_delete:
                    new TipMessage(ctx,new TipMessage.TipMessageBean("提示","是否取消收藏？","取消","确定")){
                        @Override
                        protected void right() {
                            super.right();
                            MyCollectController.getInstance().collect(list.get(layoutPosition).goods_id, new CollectRxbus("cancel", layoutPosition));
                        }
                    }.showAtLocation(false);
                    break;
            }
        }
    }

}
