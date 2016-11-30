package com.naiqiao.mall.fragment.index;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.fragment.SendCarFragment;
import com.naiqiao.mall.fragment.SendMonadContentFragment;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class ThreeFragment extends NotNetWorkBaseFragment {

    @Override
    protected int getRId() {
        return R.layout.fragment_three;
    }

    private SendCarFragment sendCarFragment;

    @Override
    protected void initView() {
        getChildFragmentManager().beginTransaction().replace(R.id.fg_content, sendCarFragment = new SendCarFragment()).commit();
    }

    @Override
    protected void initData() {
        sendCarFragment.startRefresh();
    }

    @OnClick(R.id.bt_send_car)
    void sendCar() {
        RxBus.get().post("addFragment",new AddFragmentBean(new SendMonadContentFragment()));
    }

    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }


    @Override
    protected void initTitleView() {
        DefaultTitleBarView defaultTitleBarView= (DefaultTitleBarView) getTitleBar();
        defaultTitleBarView.showVisiLeft(View.GONE).setTitleContent("我要发货");
    }
}
