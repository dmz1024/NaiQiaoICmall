package com.naiqiao.mall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.ChangeShopBean;
import com.naiqiao.mall.view.AddAndSubView;

import java.util.ArrayList;

import base.adapter.BaseAdapter;
import base.adapter.BaseViewHolder;
import butterknife.BindView;


/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class ChooseChangeShopTwoAdapter extends BaseAdapter<ChangeShopBean.Data> {

    public ChooseChangeShopTwoAdapter(Context ctx, ArrayList<ChangeShopBean.Data> list) {
        super(ctx, list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(ctx, R.layout.item_change_shop, null));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder mHolder = ((ViewHolder) holder);
        final ChangeShopBean.Data data = list.get(position);
        Glide.with(ctx).load(data.goods_thumb).into(mHolder.iv_img);
        mHolder.tv_title.setText(data.goods_name);
        mHolder.tv_have_count.setText("剩余：" + data.goods_number + "件");
        mHolder.tv_price.setText(data.format_goods_price.substring(0, data.format_goods_price.length() - 1));
        mHolder.view_as.setMin(0).setMax(data.goods_number).setCount(data.count).setOnChangeListener(new AddAndSubView.OnChangeListener() {
            @Override
            public void add() {
                list.get(position).count = mHolder.view_as.getCount();
                if(data.isChoose){
                    choose();
                }
            }

            @Override
            public void sub() {
                list.get(position).count = mHolder.view_as.getCount();
                if(data.isChoose){
                    choose();
                }
            }
        });

        mHolder.iv_choose.setImageResource(data.isChoose ? R.mipmap.icon_checked : R.mipmap.icon_check);
    }


    public class ViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_title)
        TextView tv_title;
        @BindView(R.id.tv_price)
        public TextView tv_price;
        @BindView(R.id.tv_have_count)
        TextView tv_have_count;
        @BindView(R.id.iv_img)
        ImageView iv_img;
        @BindView(R.id.view_as)
        AddAndSubView view_as;
        @BindView(R.id.iv_choose)
        ImageView iv_choose;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_choose.setOnClickListener(this);
        }

        @Override
        protected void itemOnclick(int id, int layoutPosition) {
            super.itemOnclick(id, layoutPosition);
            iv_choose.setImageResource((list.get(layoutPosition).isChoose = !list.get(layoutPosition).isChoose) ? R.mipmap.icon_checked : R.mipmap.icon_check);
            choose();
        }
    }

    private OnChangeShopChooseListener chooseListener;

    public void setOnChangeShopChooseListener(OnChangeShopChooseListener chooseListener) {
        this.chooseListener = chooseListener;
    }

    public interface OnChangeShopChooseListener {
        boolean isChoose();
    }

    public void choose() {

    }
}
