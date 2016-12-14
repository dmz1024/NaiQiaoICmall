package com.naiqiao.mall.fragment;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class OnlyBackMoneySuccessFragment extends NotNetWorkBaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_only_back_money_success;
    }

    @OnClick(R.id.bt_show_desc)
    void showDesc() {
        RxBus.get().post("addFragment",new AddFragmentBean(new BackShopDescFragment()));
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("仅退款");
    }




}
