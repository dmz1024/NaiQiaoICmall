package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.naiqiao.mall.adapter.DaoHuoTZAdapter;
import com.naiqiao.mall.adapter.TongZhiGGAdapter;
import com.naiqiao.mall.bean.DaoHuoTZBean;
import com.naiqiao.mall.bean.TongZhiGGBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.ListNetWorkBaseFragment;
import interfaces.OnTitleBarListener;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/2.
 */

public class DaoHuoTZFragment extends ListNetWorkBaseFragment<DaoHuoTZBean> implements OnTitleBarListener {
    private boolean isTz;

    public static DaoHuoTZFragment getInstance(boolean isTz) {
        DaoHuoTZFragment daoHuoTZFragment = new DaoHuoTZFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isTz", isTz);
        daoHuoTZFragment.setArguments(bundle);
        return daoHuoTZFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            isTz = bundle.getBoolean("isTz");
        }
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new DaoHuoTZAdapter(getContext(), (ArrayList<DaoHuoTZBean.Data>) totalList,isTz);
    }

    @Override
    protected String url() {
        return ApiConstant.NEWSCENTER;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "notice_less");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    protected Class<DaoHuoTZBean> getTClass() {
        return DaoHuoTZBean.class;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBarView = (DefaultTitleBarView) getTitleBar();
        titleBarView.setTitleContent(isTz ? "到货通知" : "库存预警").setOnTitleBarListener(this);
        if (!isTz) {
            titleBarView.setRightColor("#f73f5f").setRightContent("设置");
        }

    }

    @Override
    public void left() {
        RxBus.get().post("back", "back");
    }

    @Override
    public void right() {
        RxBus.get().post("addFragment", new AddFragmentBean(new YuJingSetFragment()));
    }

    @Override
    public void center() {

    }
}
