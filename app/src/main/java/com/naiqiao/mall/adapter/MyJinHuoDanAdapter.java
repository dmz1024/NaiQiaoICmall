package com.naiqiao.mall.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.MyJinHuoDanBean;
import com.naiqiao.mall.bean.rxbus.MyJHDRxBus;
import com.naiqiao.mall.controller.MyJHDController;
import com.naiqiao.mall.fragment.ShopDescFragment;
import com.naiqiao.mall.view.AddAndSubView;

import java.util.ArrayList;

import api.TestConstant;
import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import base.bean.rxbus.AddFragmentBean;
import butterknife.BindView;
import util.RxBus;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class MyJinHuoDanAdapter extends BaseAdapter<MyJinHuoDanBean.Data> {

    public MyJinHuoDanAdapter(Context ctx, ArrayList<MyJinHuoDanBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_my_jinhuodan, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder mHolder = (ViewHolder) holder;
        final MyJinHuoDanBean.Data data = list.get(position);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        mHolder.iv_choose.setImageResource(data.isChoose ? R.mipmap.icon_checked : R.mipmap.icon_check);
        mHolder.tv_title.setText(data.goods_name);
        mHolder.tv_price.setText(data.goods_price);
        mHolder.tv_old_price.setText(data.market_price);
        mHolder.tv_have_count.setText("剩余：" + data.stock + "件");
        mHolder.tv_total.setText("小计：" + data.subtotal);
        mHolder.tv_tip.setText("本产品可获得" + data.give_integral + "积分");
        mHolder.tv_guige.setText("规格："+data.goods_attr);
        mHolder.view_aas.setOnChangeListener(new AddAndSubView.OnChangeListener() {
            @Override
            public void add() {
                mHolder.view_aas.setCanChange(false);
                MyJHDController.getInstance().changeNum(new MyJHDRxBus(true, position, mHolder.view_aas.getCount() + 1, data.rec_id));
            }

            @Override
            public void sub() {
                mHolder.view_aas.setCanChange(false);
                MyJHDController.getInstance().changeNum(new MyJHDRxBus(false, position, mHolder.view_aas.getCount() - 1, data.rec_id));
            }
        }).setCanChange(data.isChange).setMax(data.stock).setCount(data.goods_number);
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_tip)
        TextView tv_tip;
        @BindView(R.id.tv_have_count)
        TextView tv_have_count;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.tv_old_price)
        TextView tv_old_price;
        @BindView(R.id.tv_guige)
        TextView tv_guige;
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.iv_choose)
        ImageView iv_choose;
        @BindView(R.id.tv_total)
        TextView tv_total;
        @BindView(R.id.view_aas)
        AddAndSubView view_aas;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            iv_choose.setOnClickListener(this);
            tv_old_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
        }

        @Override
        protected void onClick(int layoutPosition) {
            RxBus.get().post("addFragment",new AddFragmentBean(new ShopDescFragment()));
        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            if (id == R.id.iv_choose) {
                iv_choose.setImageResource((list.get(layoutPosition).isChoose = !list.get(layoutPosition).isChoose) ? R.mipmap.icon_checked : R.mipmap.icon_check);
                choose();
            }
        }
    }


    protected void choose() {

    }
}
