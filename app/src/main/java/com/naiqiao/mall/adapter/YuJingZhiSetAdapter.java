package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.FilterShopListBean;
import com.naiqiao.mall.bean.YuJingZhiSetBean;
import com.naiqiao.mall.bean.rxbus.YuJingZhiRxBus;
import com.naiqiao.mall.controller.YuJingZhiController;
import com.naiqiao.mall.fragment.ShopInfoDescRootFragment;
import com.naiqiao.mall.view.AddAndSubView;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.bean.rxbus.AddFragmentBean;
import util.JLogUtils;
import util.RxBus;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class YuJingZhiSetAdapter extends BaseAdapter<YuJingZhiSetBean.Data> {

    public YuJingZhiSetAdapter(Context ctx, ArrayList<YuJingZhiSetBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_yu_jing_zhi, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        final YuJingZhiSetBean.Data data = list.get(position);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        mHolder.tv_title.setText(data.goods_name);
        mHolder.tv_sn.setText("产品条形码：" + data.goods_sn);
        mHolder.tv_guige.setText("规格：" + data.attr);
        mHolder.view_aas.setOnChangeListener(new AddAndSubView.OnChangeListener() {
            @Override
            public void add() {
                mHolder.view_aas.setCanChange(false);
                YuJingZhiController.getInstance().changeNum(new YuJingZhiRxBus(position, mHolder.view_aas.getCount(), data.id, mHolder.view_aas.getCount() - 1));
            }

            @Override
            public void sub() {
                mHolder.view_aas.setCanChange(false);
                JLogUtils.D(mHolder.view_aas.getCount()+"");
                YuJingZhiController.getInstance().changeNum(new YuJingZhiRxBus(position, mHolder.view_aas.getCount(), data.id, mHolder.view_aas.getCount() + 1));

            }
        }).setCanChange(data.isChange).setMin(0).setCount(data.warn);
    }


    public class ViewHolder extends BaseViewHolder {
        public TextView tv_title;
        public TextView tv_guige;
        public TextView tv_sn;
        public AddAndSubView view_aas;
        public ImageView iv_img;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_guige = (TextView) itemView.findViewById(R.id.tv_guige);
            tv_sn = (TextView) itemView.findViewById(R.id.tv_sn);
            view_aas = (AddAndSubView) itemView.findViewById(R.id.view_aas);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);

        }
    }



}
