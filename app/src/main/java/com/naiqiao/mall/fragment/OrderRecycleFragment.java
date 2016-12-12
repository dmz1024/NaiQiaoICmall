package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;

import com.naiqiao.mall.R;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;

/**
 * Created by dengmingzhi on 2016/12/12.
 * 订单回收站
 */

public class OrderRecycleFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.rv_shop)
    RecyclerView rv_shop;

    @Override
    protected void initData() {
        creatShop();
    }

    private void creatShop() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_recycle;
    }
}
