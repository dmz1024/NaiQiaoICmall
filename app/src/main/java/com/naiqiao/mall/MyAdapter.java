package com.naiqiao.mall;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naiqiao.mall.bean.AddFragmentBean;
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
        return new MyView(View.inflate(ctx, R.layout.tv_content, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (list.get(position).r == 2) {
            ((MyView) holder).tv_content.setText(list.get(position).data2.name);
        }
    }


    public class MyView extends BaseViewHolder {
        public TextView tv_content;

        public MyView(View itemView) {
            super(itemView);
            tv_content = (TextView) itemView;
            tv_content.setOnClickListener(this);
        }

        @Override
        protected void onClick(int layoutPosition) {
            super.onClick(layoutPosition);
            AddFragmentBean addFragmentBean = new AddFragmentBean();
            addFragmentBean.setFragment(OneFragment.getInstance("" + (count = count + 1)));
            addFragmentBean.setInAnimation(R.anim.form_2_up);
            addFragmentBean.setOutAnimation(R.anim.go_2_down);
            RxBus.get().post("addFragment", addFragmentBean);
        }
    }
}
