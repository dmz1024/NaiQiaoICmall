package com.naiqiao.mall.fragment.index;

import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.ChangeTwoRightBean;
import com.naiqiao.mall.fragment.TwoLeftFragment;
import com.naiqiao.mall.fragment.TwoRightFragment;
import com.naiqiao.mall.view.OneAndTwoTitleBarView;

import base.fragment.NotNetWorkBaseFragment;
import rx.Observable;
import rx.functions.Action1;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class TwoFragment extends NotNetWorkBaseFragment {

    @Override
    protected View getTitleBarView() {
        return new OneAndTwoTitleBarView(getContext());
    }

    @Override
    protected float top() {
        return 55;
    }

    private TwoLeftFragment twoLeftFragment;
    private TwoRightFragment twoRightFragment;
    private Observable<ChangeTwoRightBean> changeTwoRightRxBus;

    @Override
    protected void initView() {
        getChildFragmentManager().beginTransaction().replace(R.id.fg_left, twoLeftFragment = new TwoLeftFragment()).commit();
        getChildFragmentManager().beginTransaction().replace(R.id.fg_right, twoRightFragment = new TwoRightFragment()).commit();
        changeTwoRightRxBus = RxBus.get().register("changeTwoRight", ChangeTwoRightBean.class);
        changeTwoRightRxBus.subscribe(new Action1<ChangeTwoRightBean>() {
            @Override
            public void call(ChangeTwoRightBean changeTwoRightBean) {
                twoRightFragment.setFirst(true);
                twoRightFragment.startRefresh();
            }
        });
    }

    @Override
    protected void initData() {
        twoLeftFragment.startRefresh();
    }

    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_two;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("changeTwoRight", changeTwoRightRxBus);
    }
}
