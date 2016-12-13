package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.JiFenShopTeJiaBean;
import com.naiqiao.mall.view.pop.JifenDuiHuanCountPopView;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class JiFenShopTeJiaAdapter extends BaseAdapter<JiFenShopTeJiaBean.Data> {

    public JiFenShopTeJiaAdapter(Context ctx, ArrayList<JiFenShopTeJiaBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_jifen_tejia, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        double jifen = 1234;
        double price = 123;
        mHolder.tv_price.setText(Html.fromHtml("<font color='#f73f5f'><b>" + jifen + "</b></font>积分+<font color='#f73f5f'><b>" + price + "</b></font>元"));
        Glide.with(ctx).load(TestConstant.IMAGE).into(mHolder.iv_img);
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.tv_shi)
        TextView tv_shi;
        @BindView(R.id.bt_dui)
        Button bt_dui;

        public ViewHolder(View itemView) {
            super(itemView);
            bt_dui.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            new JifenDuiHuanCountPopView(ctx).showAtLocation(false);
        }
    }
}
