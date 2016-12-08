package com.naiqiao.mall.fragment.jiameng;

import com.naiqiao.mall.R;
import com.naiqiao.mall.view.pop.JiaMengSQPopView;
import com.naiqiao.mall.view.pop.PaiZhaoYQPopView;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.OnClick;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class ShenFenZMFragment extends NotNetWorkBaseFragment {

    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_shenfenzm;
    }


    @OnClick(R.id.tv_tips)
    void tips() {
        new PaiZhaoYQPopView(getContext()).showAtLocation(false);
    }

    @OnClick(R.id.bt_next)
    void next() {
        new PaiZhaoYQPopView(getContext()).showAtLocation(false);
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("身份证明");
    }
}
