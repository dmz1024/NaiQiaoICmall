package com.naiqiao.mall.fragment.index;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.RelativeLayout;

import com.naiqiao.mall.R;
import com.naiqiao.mall.fragment.MyBackShopFragment;
import com.naiqiao.mall.fragment.MyOrderBackContentFragment;

import java.util.List;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindViews;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/24.
 */

public class AfterServiceFragment extends NotNetWorkBaseFragment {
    @BindViews({R.id.rl_huan, R.id.rl_tui, R.id.rl_qq})
    List<RelativeLayout> rls;

    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_after_service;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBar = (DefaultTitleBarView) getTitleBar();
        titleBar.setTitleContent("售后服务").showVisiLeft(View.GONE);
    }


    @OnClick({R.id.rl_huan, R.id.rl_tui, R.id.rl_qq})
    void rlClick(View view) {
        switch (view.getId()) {
            case R.id.rl_huan:
                RxBus.get().post("addFragment",new AddFragmentBean(new MyBackShopFragment()));
                break;
            case R.id.rl_tui:
                RxBus.get().post("addFragment",new AddFragmentBean(new MyOrderBackContentFragment()));
                break;
            case R.id.rl_qq:
                String url = "mqqwpa://im/chat?chat_type=wpa&uin=1395386348";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                break;
        }
    }

}
