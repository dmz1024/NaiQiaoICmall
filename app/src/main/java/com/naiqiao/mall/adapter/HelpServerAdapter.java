package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.HelpServerBean;
import com.naiqiao.mall.bean.rxbus.AddressRxBus;
import com.naiqiao.mall.controller.AddressController;
import com.naiqiao.mall.fragment.AddressEditFragment;
import com.naiqiao.mall.view.pop.JiaMengSQPopView;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.bean.rxbus.AddFragmentBean;
import butterknife.BindView;
import util.DrawableUtil;
import util.RxBus;
import view.pop.TipMessage;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class HelpServerAdapter extends BaseAdapter<HelpServerBean> {

    public HelpServerAdapter(Context ctx, ArrayList<HelpServerBean> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_help_server, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        HelpServerBean data = list.get(position);
        mHolder.tv_content.setText(data.content);
        mHolder.tv_content.setCompoundDrawables(null, DrawableUtil.setBounds(ctx.getResources().getDrawable(data.rid)), null, null);

    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_content)
        TextView tv_content;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_content.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, final int layoutPosition) {
            if (layoutPosition == 6) {
                new JiaMengSQPopView(ctx).showAtLocation(false);
                return;
            }
            RxBus.get().post("addFragment", new AddFragmentBean(list.get(layoutPosition).fragment));
        }
    }
}
