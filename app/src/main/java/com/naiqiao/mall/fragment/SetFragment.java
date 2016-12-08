package com.naiqiao.mall.fragment;

import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/7.
 */

public class SetFragment extends NotNetWorkBaseFragment {

    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_set;
    }


    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBar = (DefaultTitleBarView) getTitleBar();
        titleBar.setTitleContent("设置");
    }


    @OnClick({R.id.tv_set, R.id.tv_address, R.id.tv_safe, R.id.tv_fankui, R.id.tv_about, R.id.tv_cache, R.id.bt_exit})
    void tvOnclick(View view) {
        switch (view.getId()) {
            case R.id.tv_set:
                RxBus.get().post("addFragment",new AddFragmentBean(new UserSetFragment()));
                break;
            case R.id.tv_address:
                RxBus.get().post("addFragment",new AddFragmentBean(new AddressContentFragment()));
                break;
            case R.id.tv_safe:
                RxBus.get().post("addFragment",new AddFragmentBean(new SafeCenterFragment()));
                break;
            case R.id.tv_fankui:
                break;
            case R.id.tv_about:
                break;
            case R.id.tv_cache:
                break;
            case R.id.bt_exit:
                break;
        }
    }
}
