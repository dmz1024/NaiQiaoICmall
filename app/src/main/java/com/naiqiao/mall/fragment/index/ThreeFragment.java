package com.naiqiao.mall.fragment.index;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.naiqiao.mall.R;
import com.naiqiao.mall.fragment.SendCarFragment;

import base.fragment.NotNetWorkBaseFragment;
import base.recycleBin.DefaultTitleBarNotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class ThreeFragment extends NotNetWorkBaseFragment {
    private String page;

    @BindView(R.id.bt_send_car)
    Button bt_send_car;

    public static ThreeFragment getInstance(String page) {
        Bundle bundle = new Bundle();
        bundle.putString("page", page);
        ThreeFragment myFragment = new ThreeFragment();
        myFragment.setArguments(bundle);
        return myFragment;
    }


    @Override
    protected int getRId() {
        return R.layout.fragment_three;
    }

    private SendCarFragment sendCarFragment;

    @Override
    protected void initView() {
        getChildFragmentManager().beginTransaction().replace(R.id.fg_content, sendCarFragment = SendCarFragment.getInstance("1")).commit();
    }

    @Override
    protected void initData() {
        sendCarFragment.startRefresh();
    }

    @OnClick(R.id.bt_send_car)
    void sendCar() {

    }

    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }

    @Override
    protected boolean isOnlyInitOne() {
        return false;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView defaultTitleBarView= (DefaultTitleBarView) getTitleBar();
        defaultTitleBarView.showVisiLeft(View.GONE).setTitleContent("我要发货");
    }
}
