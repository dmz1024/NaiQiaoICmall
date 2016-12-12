package com.naiqiao.mall.fragment.jiameng;

import com.naiqiao.mall.R;

import base.fragment.NotNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/12.
 */

public class JiaMengSubmitSuccessFragment extends NotNetWorkBaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_jiameng_submit_success;
    }


    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("提交");
    }
}
