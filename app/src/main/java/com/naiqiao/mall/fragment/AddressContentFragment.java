package com.naiqiao.mall.fragment;

import android.view.View;

import com.naiqiao.mall.R;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.OnClick;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class AddressContentFragment extends NotNetWorkBaseFragment {
    @Override
    protected void initData() {

    }

    private AddressFragment addressFragment;

    @Override
    protected void initView() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, addressFragment = new AddressFragment()).commit();
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_address_content;
    }

    @Override
    protected View getTitleBarView() {
        return null;
    }


    @OnClick(R.id.bt_add)
    void add() {

    }
}
