package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.JiFenShopTeJiaBean;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;


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

    }


    public class ViewHolder extends BaseViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);

        }

    }
}
