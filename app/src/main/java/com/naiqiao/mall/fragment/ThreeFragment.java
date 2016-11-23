package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.naiqiao.mall.MyAdapter;
import com.naiqiao.mall.R;
import com.naiqiao.mall.User;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.DefaultTitleBarListNetWorkBaseFragment;
import base.fragment.DefaultTitleBarNotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class ThreeFragment extends DefaultTitleBarNotNetWorkBaseFragment {
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
    protected String getTitleContent() {
        return "我要发货";
    }

    @Override
    protected int getLeftVisi() {
        return View.INVISIBLE;
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


}
