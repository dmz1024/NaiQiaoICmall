package com.naiqiao.mall.view.pop;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naiqiao.mall.R;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.other.PopBaseView;
import util.DrawableUtil;

/**
 * Created by dengmingzhi on 2016/12/1.
 */

public class FilterShopPopView extends PopBaseView {
    private int currentPosition = -1;
    private ArrayList<String> data = new ArrayList();

    public FilterShopPopView(Context ctx) {
        super(ctx);
    }

    public FilterShopPopView(Context ctx, int currentPosition) {
        this(ctx);
        this.currentPosition = currentPosition;
    }


    @Override
    protected int getAnimation() {
        return 0;
    }

    @Override
    protected View getView() {
        View view = View.inflate(ctx, R.layout.pop_filter_shop, null);
        view.findViewById(R.id.tv_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        view.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok(currentPosition);
            }
        });

        RecyclerView rv_content = (RecyclerView) view.findViewById(R.id.rv_content);
        for (int i = 0; i < 10; i++) {
            data.add("洗发水" + i);
        }
        rv_content.setLayoutManager(new GridLayoutManager(ctx, 3));
        rv_content.setAdapter(mAdapter = new FilterShopPopAdapter(ctx, data));
        return view;
    }


    protected void ok(int position) {

    }

    private FilterShopPopAdapter mAdapter;

    protected void clear() {
        currentPosition = -1;
        mAdapter.notifyDataSetChanged();
    }


    class FilterShopPopAdapter extends BaseAdapter<String> {

        public FilterShopPopAdapter(ArrayList<String> list) {
            super(list);
        }

        public FilterShopPopAdapter(Context ctx, ArrayList<String> list) {
            super(ctx, list);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(View.inflate(ctx, R.layout.pop_filter_shop_item, null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder mHolder = (ViewHolder) holder;
            mHolder.tv_content.setText(list.get(position));
            if (position == currentPosition) {
                mHolder.tv_content.setTextColor(Color.parseColor("#f54262"));
                mHolder.iv_img.setVisibility(View.VISIBLE);
            } else {
                mHolder.tv_content.setTextColor(Color.parseColor("#666666"));
                mHolder.tv_content.setCompoundDrawables(null, null, null, null);
                mHolder.iv_img.setVisibility(View.GONE);
            }

        }


        class ViewHolder extends BaseViewHolder {
            public TextView tv_content;
            public ImageView iv_img;

            public ViewHolder(View itemView) {
                super(itemView);
                tv_content = (TextView) itemView.findViewById(R.id.tv_content);
                iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
                itemView.setOnClickListener(this);
            }

            @Override
            protected void onClick(int layoutPosition) {
                if (layoutPosition != currentPosition) {
                    currentPosition = layoutPosition;
                    notifyDataSetChanged();
                }
            }
        }
    }
}
