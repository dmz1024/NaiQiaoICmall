package com.naiqiao.mall.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class OnlyBackMoneyFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.ll_shop)
    LinearLayout ll_shop;

    @Override
    protected void initData() {
        creatShop();
    }

    private void creatShop() {
        for (int i = 0; i < 2; i++) {
            ll_shop.addView(View.inflate(getContext(), R.layout.item_only_back_money, null));
        }
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_only_back_money;
    }

    @OnClick(R.id.bt_submit)
    void submit() {
        RxBus.get().post("addFragment", new AddFragmentBean(new OnlyBackMoneySuccessFragment()));
    }
}
