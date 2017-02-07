package com.naiqiao.mall.fragment;

import com.naiqiao.mall.R;

import base.fragment.NotNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2017/2/6.
 */

public class AffirmGoPayFragment extends NotNetWorkBaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_affirm_gopay;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("确认发货单");
    }
}
