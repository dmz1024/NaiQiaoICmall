package com.naiqiao.mall.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.naiqiao.mall.R;
import base.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.fragment.base.TabIndicatorBaseFragment;
import com.naiqiao.mall.view.RightImageTitleBarView;

import java.util.ArrayList;

import interfaces.OnTitleBarListener;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/12/7.
 */

public class MyOrderContentFragment extends TabIndicatorBaseFragment implements OnTitleBarListener {


    @Override
    protected void initTitleView() {
        ((RightImageTitleBarView) getTitleBar())
                .setTitleContent(getTitleContent())
                .setOnTitleBarListener(this)
                .setRightImage(R.mipmap.icon_shai);
    }

    @Override
    protected View getTitleBarView() {
        return new RightImageTitleBarView(getContext());
    }

    @Override
    protected ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> list=new ArrayList<>();
        list.add(MyOrderFragment.getInstance(""));
        list.add(MyOrderFragment.getInstance("1"));
        list.add(MyOrderFragment.getInstance("2"));
        list.add(MyOrderFragment.getInstance("3"));
        list.add(MyOrderFragment.getInstance("4"));
        list.add(MyOrderFragment.getInstance("5"));
        return list;
    }

    @Override
    protected String[] getTabTitles() {
        return new String[]{"全部订单","待付款","待发货","在途订单","已送达","订单回收站"};
    }

    @Override
    protected String getTitleContent() {
        return "我的订单";
    }

    @Override
    public void left() {

    }

    @Override
    public void right() {
        RxBus.get().post("addFragment", new AddFragmentBean(new OrderSearchFragment()));
    }

    @Override
    public void center() {

    }
}
