package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.AddressAdapter;
import com.naiqiao.mall.adapter.SendCarAdapter;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.SendCarBean;
import com.naiqiao.mall.bean.rxbus.AddressRxBus;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import api.TestConstant;
import base.bean.rxbus.AddFragmentBean;
import base.fragment.ListNetWorkBaseFragment;
import interfaces.OnTitleBarListener;
import rx.Observable;
import rx.functions.Action1;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class AddressFragment extends ListNetWorkBaseFragment<AddressBean> implements OnTitleBarListener {
    private Observable<AddressRxBus> address;

    private boolean isChoose;

    public static AddressFragment getInstance(boolean isChoose) {
        AddressFragment addressFragment = new AddressFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isChoose", isChoose);
        addressFragment.setArguments(bundle);
        return addressFragment;
    }


    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new AddressAdapter(getContext(), (ArrayList<AddressBean.Data>) totalList,isChoose);
    }

    private void initRxBus() {
        address = RxBus.get().register("address", AddressRxBus.class);
        address.subscribe(new Action1<AddressRxBus>() {
            @Override
            public void call(AddressRxBus rxBus) {
                switch (rxBus.index) {
                    case "def":
                        ((ArrayList<AddressBean.Data>) totalList).get(rxBus.position).def = 1;
                        if (rxBus.oldPosition != -1) {
                            ((ArrayList<AddressBean.Data>) totalList).get(rxBus.oldPosition).def = 0;
                        }
                        mAdapter.notifyDataSetChanged();
                        break;
                    case "delete":
                        if (rxBus.oldPosition == rxBus.position) {
                            ((AddressAdapter) mAdapter).setDefPosition(-1);
                        }
                        mAdapter.remove(rxBus.position);
                        break;
                    case "add_update":
                        startRefresh();
                        break;
                }
            }
        });
    }


    @Override
    protected String url() {
        return ApiConstant.AREA;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "send_address");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (address == null) {
            initRxBus();
        }
        Bundle bundle = getArguments();
        if (bundle != null) {
            isChoose = bundle.getBoolean("isChoose");
        }
    }

    @Override
    protected Class<AddressBean> getTClass() {
        return AddressBean.class;
    }


    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar())
                .setTitleContent("收货地址")
                .setRightContent(isChoose?"添加地址":"")
                .setOnTitleBarListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("address", address);
    }

    @Override
    public void left() {
        RxBus.get().post("back","back");
    }

    @Override
    public void right() {
        RxBus.get().post("addFragment", new AddFragmentBean(new AddressEditFragment()));
    }

    @Override
    public void center() {

    }
}
