package com.naiqiao.mall.fragment;

import android.view.View;

import com.naiqiao.mall.R;

import base.fragment.NotNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class ChangeShopContentFragment extends NotNetWorkBaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, new ChangeShopFragment()).commit();
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_change_shop_content;
    }

    @Override
    protected View getTitleBarView() {
        return null;
    }
}
