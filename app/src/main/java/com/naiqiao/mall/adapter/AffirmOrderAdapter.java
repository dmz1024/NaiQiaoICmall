package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.AffirmOrderBean;
import com.naiqiao.mall.bean.SendCarBean;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;
import view.Color2Text;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class AffirmOrderAdapter extends BaseAdapter<AffirmOrderBean> {

    public AffirmOrderAdapter(Context ctx, ArrayList<AffirmOrderBean> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_affirm_order, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        AffirmOrderBean data = list.get(position);
        mHolder.tv_show.setText(data.isSHow ? "收起" : "展开");
        mHolder.ll_shop.setVisibility(data.isSHow ? View.VISIBLE : View.GONE);
        if (data.isSHow && mHolder.ll_shop.getChildCount()==0) {
            creatView(data, mHolder.ll_shop);
        }
    }

    private void creatView(AffirmOrderBean data, LinearLayout ll_shop) {
        for (int i = 0; i < 3; i++) {
            ll_shop.addView(View.inflate(ctx, R.layout.item_affirm_order_shop, null));
        }
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.ll_shop)
        LinearLayout ll_shop;
        @BindView(R.id.tv_sn)
        Color2Text tv_sn;
        @BindView(R.id.tv_address)
        Color2Text tv_address;
        @BindView(R.id.tv_price)
        Color2Text tv_price;
        @BindView(R.id.tv_show)
        TextView tv_show;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_show.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            list.get(layoutPosition).isSHow = !list.get(layoutPosition).isSHow;
            notifyItemChanged(layoutPosition);
        }
    }
}
