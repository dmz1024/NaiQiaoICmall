package com.naiqiao.mall.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.fragment.base.TabIndicatorBaseFragment;
import com.naiqiao.mall.view.RightImageTitleBarView;

import java.util.ArrayList;

import base.fragment.NotNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/12/7.
 */

public class YiFaHuoContentFragment extends TabIndicatorBaseFragment {


    @Override
    protected void initTitleView() {
        ((RightImageTitleBarView) getTitleBar()).setTitleContent(getTitleContent()).setRightImage(R.mipmap.icon_shai);
    }

    @Override
    protected View getTitleBarView() {
        return new RightImageTitleBarView(getContext());
    }

    @Override
    protected ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> list=new ArrayList<>();
        list.add(YiFaHuoFragment.getInstance(""));
        list.add(YiFaHuoFragment.getInstance("1"));
        list.add(YiFaHuoFragment.getInstance("2"));
        list.add(YiFaHuoFragment.getInstance("3"));
        list.add(YiFaHuoFragment.getInstance("4"));
        return list;
    }

    @Override
    protected String[] getTabTitles() {
        return new String[]{"全部订单","待付运费","待发货","已发货","订单回收站"};
    }

    @Override
    protected String getTitleContent() {
        return "我已发货";
    }
}
