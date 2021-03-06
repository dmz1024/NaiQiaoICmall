package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.MyBackShopBean;
import com.naiqiao.mall.fragment.ChangeShopDescContentFragment;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.bean.rxbus.AddFragmentBean;
import butterknife.BindView;
import util.RxBus;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class MyBackShopAdapter extends BaseAdapter<MyBackShopBean.Data> {

    public MyBackShopAdapter(Context ctx, ArrayList<MyBackShopBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_my_back_shop, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        MyBackShopBean.Data data = list.get(position);
        mHolder.tv_statu.setTextColor(Color.parseColor(data.type == 3 ? "#f73f5f" : "#333333"));
        mHolder.tv_statu.setText(data.status);
        mHolder.tv_sn.setText("换货单号：" + data.order_sn);
        mHolder.tv_price.setText("虚拟仓商品：￥" + data.amount + "    新进商品：" + data.total_fee);

    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_sn)
        TextView tv_sn;
        @BindView(R.id.tv_statu)
        TextView tv_statu;
        @BindView(R.id.tv_price)
        TextView tv_price;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {
            int type = list.get(layoutPosition).type;
            RxBus.get().post("addFragment", new AddFragmentBean(ChangeShopDescContentFragment.getInstance(type > 2 ? 2 : type,list.get(layoutPosition).back_id)));
        }
    }
}
