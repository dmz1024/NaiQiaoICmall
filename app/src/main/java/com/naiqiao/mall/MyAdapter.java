package com.naiqiao.mall;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naiqiao.mall.bean.User;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.fragment.index.OneFragment;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class MyAdapter extends BaseAdapter<User.Data> {
    public static int count = 1;

    public MyAdapter(Context ctx, ArrayList<User.Data> list) {
        super(ctx, list);
    }

    public MyAdapter(ArrayList<User.Data> list) {
        super(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyView(View.inflate(ctx, R.layout.item_two_left_content, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (list.get(position).r == 2) {
            ((MyView) holder).tv_title.setText(list.get(position).data2.name);
        }
    }


    public class MyView extends BaseViewHolder {
        public TextView tv_title;

        public MyView(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {
            super.onClick(layoutPosition);
            AddFragmentBean addFragmentBean = new AddFragmentBean();
            addFragmentBean.setFragment(new OneFragment());
//            addFragmentBean.setInAnimation(R.anim.small_2_big);
//            addFragmentBean.setOutAnimation(R.anim.big_2_small);
            RxBus.get().post("addFragment", addFragmentBean);
        }
    }
}
