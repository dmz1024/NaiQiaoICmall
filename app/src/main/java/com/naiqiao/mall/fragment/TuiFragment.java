package com.naiqiao.mall.fragment;

import com.naiqiao.mall.R;
import base.bean.rxbus.AddFragmentBean;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/30.
 */

public class TuiFragment extends NotNetWorkBaseFragment {

    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_tui;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBar = (DefaultTitleBarView) getTitleBar();
        titleBar.setTitleContent("售后类型");
    }

    @OnClick(R.id.tv_tui_kuan)
    void backOnlyKuan(){
        RxBus.get().post("addFragment",new AddFragmentBean(new OnlyBackMoneyFragment()));
    }
}
