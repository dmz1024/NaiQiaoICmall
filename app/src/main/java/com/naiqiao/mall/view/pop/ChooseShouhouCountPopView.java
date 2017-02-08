package com.naiqiao.mall.view.pop;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;

import base.bean.rxbus.AddFragmentBean;

import com.naiqiao.mall.bean.ShopBean;
import com.naiqiao.mall.fragment.TuiFragment;
import com.naiqiao.mall.view.AddAndSubView;

import java.util.ArrayList;

import util.RxBus;
import util.Util;

/**
 * Created by dengmingzhi on 2016/12/13.
 */

public class ChooseShouhouCountPopView extends TitleBasePopView {
    public ChooseShouhouCountPopView(Context ctx) {
        super(ctx);
    }

    private int count = 0;
    private ArrayList<ShopBean> shops;
    private String id;

    public ChooseShouhouCountPopView(Context ctx, ArrayList<ShopBean> shops, String id) {
        this(ctx);
        this.count = shops.size();
        this.shops = (ArrayList<ShopBean>) shops.clone();
        this.id = id;
    }

    @Override
    protected View getChildView() {
        View view = View.inflate(ctx, R.layout.pop_choose_shouhou_count, null);
        LinearLayout ll_shop = (LinearLayout) view.findViewById(R.id.ll_shop);
        ScrollView sc_shop = (ScrollView) view.findViewById(R.id.sc_shop);
        RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) sc_shop.getLayoutParams();
        params.height=Util.dp2Px(count>1?200:100);
        sc_shop.setLayoutParams(params);
        creatShop(ll_shop);
        Button bt_sq = (Button) view.findViewById(R.id.bt_sq);
        bt_sq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                RxBus.get().post("addFragment", new AddFragmentBean(TuiFragment.getInstance(shops,id)));
            }
        });
        return view;
    }

    private void creatShop(LinearLayout ll_shop) {
        for (int i = 0; i < count; i++) {
            ShopBean shopBean = shops.get(i);
            View view = View.inflate(ctx, R.layout.item_choose_shouhou_count, null);
            ImageView iv_img = (ImageView) view.findViewById(R.id.iv_img);
            TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
            final AddAndSubView view_as = (AddAndSubView) view.findViewById(R.id.view_as);
            TextView tv_count = (TextView) view.findViewById(R.id.tv_count);
            Glide.with(ctx).load(shopBean.goods_thumb).into(iv_img);
            tv_title.setText(shopBean.goods_name);
            tv_count.setText("共" + shopBean.goods_number + "件");
            final int finalI = i;
            view_as.setMin(0).setMax(shopBean.goods_number).setCount(1).setOnChangeListener(new AddAndSubView.OnChangeListener() {
                @Override
                public void add() {
                    shops.get(finalI).count = view_as.getCount();
                }

                @Override
                public void sub() {
                    shops.get(finalI).count = view_as.getCount();
                }
            });
            ll_shop.addView(view);
        }
    }

    @Override
    protected String getTitle() {
        return "选择售后商品数量";
    }
}
