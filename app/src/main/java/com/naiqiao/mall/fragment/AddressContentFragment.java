package com.naiqiao.mall.fragment;

import android.view.View;

import com.naiqiao.mall.R;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class AddressContentFragment extends NotNetWorkBaseFragment {

    @Override
    protected void initData() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, addressFragment = new AddressFragment()).commit();
    }


    private AddressFragment addressFragment;

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
        RxBus.get().post("addFragment", new AddFragmentBean(new AddressEditFragment()));
    }

}
