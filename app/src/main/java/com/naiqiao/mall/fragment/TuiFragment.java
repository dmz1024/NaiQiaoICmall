package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.ShopBean;

import java.util.ArrayList;

import base.bean.rxbus.AddFragmentBean;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/30.
 */

public class TuiFragment extends NotNetWorkBaseFragment {
    private ArrayList<ShopBean> shops;
    private String id;

    public static TuiFragment getInstance(ArrayList<ShopBean> shops, String id) {
        TuiFragment fragment = new TuiFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", shops);
        bundle.putString("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            shops = bundle.getParcelableArrayList("data");
            id = bundle.getString("id");
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_tui;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBar = (DefaultTitleBarView) getTitleBar();
        titleBar.setTitleContent("售后类型");
    }

    @OnClick(R.id.tv_tui_kuan)
    void backOnlyKuan() {
        RxBus.get().post("addFragment", new AddFragmentBean(OnlyBackMoneyFragment.getInstance(shops,id,"1")));
    }
    @OnClick(R.id.tv_tui_all)
    void backAllKuan() {
        RxBus.get().post("addFragment", new AddFragmentBean(OnlyBackMoneyFragment.getInstance(shops,id,"2")));
    }
}
