package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.JiFenShopTeJiaAdapter;
import com.naiqiao.mall.bean.JiFenShopBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/12/12.
 */

public class JiFenShopFragment extends ListNetWorkBaseFragment<JiFenShopBean> {
    public static JiFenShopFragment getInstance(int type) {
        JiFenShopFragment fragment = new JiFenShopFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    private int type = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt("type");
        }
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new JiFenShopTeJiaAdapter(getContext(), (ArrayList<JiFenShopBean.Data>) totalList, type);
    }

    @Override
    protected String url() {
        return ApiConstant.EXCHANGE;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", type == 0 ? "index_p" : "index");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    protected Class<JiFenShopBean> getTClass() {
        return JiFenShopBean.class;
    }

    @Override
    protected LinearLayoutManager getLayoutManager() {
        return new GridLayoutManager(getContext(), 2);
    }

    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return type == 0;
    }
}
