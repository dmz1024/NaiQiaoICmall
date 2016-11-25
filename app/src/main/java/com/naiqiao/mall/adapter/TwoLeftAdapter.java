package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.TwoLeftBean;
import com.naiqiao.mall.bean.rxbus.ChangeTwoRightBean;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class TwoLeftAdapter extends BaseAdapter<TwoLeftBean.Data> {
    public static final int SHOW_TYPE_TITLE = 1;
    public static final int SHOW_TYPE_CONTENT = 2;
    public int currentChoose = 1;
    public boolean isFirst = true;

    public TwoLeftAdapter(Context ctx, ArrayList<TwoLeftBean.Data> list) {
        super(ctx, list);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewType == SHOW_TYPE_TITLE ? new TitleViewHolder(View.inflate(ctx, R.layout.item_two_left_title, null)) : new ContentViewHolder(View.inflate(ctx, R.layout.item_two_left_content, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TitleViewHolder) {
            TitleViewHolder viewHolder = ((TitleViewHolder) holder);
            viewHolder.tv_title.setText(list.get(position).name);
        } else {
            ContentViewHolder viewHolder = ((ContentViewHolder) holder);
            viewHolder.tv_title.setText(list.get(position).name);
            if (currentChoose == position) {
                viewHolder.tv_title.setTextColor(Color.parseColor("#f73f5f"));
                viewHolder.itemView.setBackgroundColor(Color.parseColor("#f5f5f5"));
            } else {
                viewHolder.tv_title.setTextColor(Color.parseColor("#373737"));
                viewHolder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
            }

            if (position == 1 && isFirst) {
                isFirst = false;
                RxBus.get().post("changeTwoRight", new ChangeTwoRightBean());
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).type == 1 ? SHOW_TYPE_TITLE : SHOW_TYPE_CONTENT;
    }

    public class TitleViewHolder extends BaseViewHolder {
        public TextView tv_title;
        public TextView tv_alias_title;
        public View view;
        public View view_line;
        public FrameLayout fg_back;

        public TitleViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_alias_title = (TextView) itemView.findViewById(R.id.tv_alias_title);
            view = itemView.findViewById(R.id.view);
            view_line = itemView.findViewById(R.id.view_line);
            fg_back = (FrameLayout) itemView.findViewById(R.id.fg_back);
        }

    }

    public class ContentViewHolder extends BaseViewHolder {
        public TextView tv_title;
        public View itemView;

        public ContentViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {
            if (currentChoose != layoutPosition) {
                currentChoose = layoutPosition;
                notifyDataSetChanged();
                RxBus.get().post("changeTwoRight", new ChangeTwoRightBean());
            }
        }
    }
}
