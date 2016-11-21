package com.naiqiao.mall;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import base.BaseAdapter;
import base.BaseViewHolder;

/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class MyAdapter extends BaseAdapter<User.Data> {
    public MyAdapter(Context ctx, ArrayList<User.Data> list) {
        super(ctx, list);
    }

    public MyAdapter(ArrayList<User.Data> list) {
        super(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyView(View.inflate(ctx, R.layout.tv_content, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(list.get(position).r==2){
            ((MyView) holder).tv_content.setText(list.get(position).data2.name);
        }
    }


    public class MyView extends BaseViewHolder {
        public TextView tv_content;

        public MyView(View itemView) {
            super(itemView);
            tv_content = (TextView) itemView;
        }
    }
}
