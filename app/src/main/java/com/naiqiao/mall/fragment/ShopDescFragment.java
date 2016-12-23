package com.naiqiao.mall.fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import com.naiqiao.mall.fragment.base.TabIndicatorBaseFragment;
import com.naiqiao.mall.view.ShopDescTitleBarView;

import java.util.ArrayList;

import util.Util;

/**
 * Created by dengmingzhi on 2016/12/23.
 */

public class ShopDescFragment extends TabIndicatorBaseFragment {
    @Override
    protected ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new AllShopFragment());
        fragments.add(new AllShopFragment());
        return fragments;
    }

    @Override
    protected String[] getTabTitles() {
        return new String[]{"  商品  ", "  详情  "};
    }

    @Override
    protected void initView() {
        super.initView();
        tab.setTabMode(TabLayout.MODE_FIXED);
        tab.setTabGravity(TabLayout.GRAVITY_CENTER);
        tab.setBackgroundColor(Color.parseColor("#00000000"));
        ViewGroup.LayoutParams layoutParams = tab.getLayoutParams();
        layoutParams.height=Util.dp2Px(45);
        tab.setLayoutParams(layoutParams);
    }

    @Override
    protected String getTitleContent() {
        return "";
    }

    @Override
    protected void initTitleView() {

    }

    @Override
    protected View getTitleBarView() {
        return new ShopDescTitleBarView(getContext());
    }

    @Override
    protected int getTop() {
        return 0;
    }
}
