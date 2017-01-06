package com.naiqiao.mall.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.naiqiao.mall.fragment.base.TabIndicatorBaseFragment;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2016/12/12.
 */

public class JiFenShopContentFragment extends TabIndicatorBaseFragment {
    @Override
    protected ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(JiFenShopFragment.getInstance(0));
        fragments.add(JiFenShopFragment.getInstance(1));
        return fragments;
    }

    @Override
    protected void initView() {
        super.initView();
        tab.setTabMode(TabLayout.MODE_FIXED);
        tab.setTabGravity(TabLayout.GRAVITY_CENTER);
    }

    @Override
    protected String[] getTabTitles() {
        return new String[]{"积分特价兑换","全积分兑换"};
    }

    @Override
    protected String getTitleContent() {
        return "积分商城";
    }
}
