package com.naiqiao.mall.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.naiqiao.mall.fragment.base.TabIndicatorBaseFragment;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2016/12/13.
 */

public class MyOrderBackContentFragment extends TabIndicatorBaseFragment {
    @Override
    protected ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(MyOrderBackFragment.getInstance(""));
        fragments.add(MyOrderBackFragment.getInstance("1"));
        fragments.add(MyOrderBackFragment.getInstance("2"));
        fragments.add(MyOrderBackFragment.getInstance("3"));
        return fragments;
    }

    @Override
    protected String[] getTabTitles() {
        return new String[]{"全部订单", "待审核", "退货中", "退货完成"};
    }

    @Override
    protected String getTitleContent() {
        return "我的退货";
    }
}
