package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.SendCarBean;
import com.naiqiao.mall.bean.rxbus.AddressRxBus;
import com.naiqiao.mall.controller.AddressController;
import com.naiqiao.mall.fragment.AddressEditFragment;

import java.util.ArrayList;

import api.TestConstant;
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

public class AddressAdapter extends BaseAdapter<AddressBean.Data> {
    private int defPosition = -1;

    public void setDefPosition(int defPosition) {
        this.defPosition = defPosition;
    }

    public AddressAdapter(Context ctx, ArrayList<AddressBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_address, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        AddressBean.Data data = list.get(position);
        mHolder.tv_name.setText(data.consignee);
        mHolder.tv_tel.setText(data.mobile);
        mHolder.tv_address.setText(data.group_address);
        mHolder.tv_default.setCompoundDrawables(DrawableUtil.setBounds(ctx.getResources().getDrawable(data.def == 1 ? R.mipmap.icon_checked : R.mipmap.icon_check)), null, null, null);
        mHolder.tv_default.setText(data.def == 1 ? "默认地址" : "设为默认");
        if (data.def == 1) {
            defPosition = position;
        }
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_tel)
        TextView tv_tel;
        @BindView(R.id.tv_address)
        TextView tv_address;
        @BindView(R.id.tv_default)
        TextView tv_default;
        @BindView(R.id.tv_delete)
        TextView tv_delete;
        @BindView(R.id.tv_edit)
        TextView tv_edit;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_edit.setOnClickListener(this);
            tv_default.setOnClickListener(this);
            tv_delete.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, final int layoutPosition) {
            switch (id) {
                case R.id.tv_edit:
                    AddressEditFragment addressEditFragment = new AddressEditFragment();
                    addressEditFragment.setData(list.get(layoutPosition), defPosition, layoutPosition);
                    RxBus.get().post("addFragment", new AddFragmentBean(addressEditFragment));
                    break;
                case R.id.tv_default:
                    if (list.get(layoutPosition).def != 1) {
                        AddressController.getInstance().setDef(new AddressRxBus(list.get(layoutPosition).address_id, "def", defPosition, layoutPosition));
                    }
                    break;
                case R.id.tv_delete:
                    new TipMessage(ctx, new TipMessage.TipMessageBean("提示", "是否删除地址？", "取消", "确认")) {
                        @Override
                        protected void right() {
                            super.right();
                            AddressController.getInstance().delete(new AddressRxBus(list.get(layoutPosition).address_id, "delete", defPosition, layoutPosition));
                        }
                    }.showAtLocation(false);
                    break;
            }
        }
    }
}
