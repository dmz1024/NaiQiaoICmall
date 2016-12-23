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
        initRxBus();
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, addressFragment = new AddressFragment()).commit();
    }

    private void initRxBus() {
        startReFreshRxBus = RxBus.get().register("startReFreshRxBus", String.class);
        startReFreshRxBus.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                addressFragment.startRefresh();
            }
        });
    }

    private AddressFragment addressFragment;

    private Observable<String> startReFreshRxBus;


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

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("startReFreshRxBus", startReFreshRxBus);
    }
}
