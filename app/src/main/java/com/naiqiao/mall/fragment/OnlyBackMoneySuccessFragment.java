package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.naiqiao.mall.R;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class OnlyBackMoneySuccessFragment extends NotNetWorkBaseFragment {
    public static OnlyBackMoneySuccessFragment getInstance(String id) {
        OnlyBackMoneySuccessFragment fragment = new OnlyBackMoneySuccessFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    private String id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_only_back_money_success;
    }

    @OnClick(R.id.bt_show_desc)
    void showDesc() {
        RxBus.get().post("addFragment", new AddFragmentBean(BackShopDescFragment.getInstance(id)));
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("仅退款");
    }


}
