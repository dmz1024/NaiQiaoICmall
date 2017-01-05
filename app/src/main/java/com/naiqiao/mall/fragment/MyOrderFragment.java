package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.naiqiao.mall.adapter.MyOrderAdapter;
import com.naiqiao.mall.adapter.YuCunHuoAdapter;
import com.naiqiao.mall.bean.MyOrderBean;
import com.naiqiao.mall.bean.YuCunHuoBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class MyOrderFragment extends ListNetWorkBaseFragment<MyOrderBean> {

    private String type = "";

    public static MyOrderFragment getInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        MyOrderFragment fragment = new MyOrderFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getString("type");
        }
    }


    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyOrderAdapter(getContext(), (ArrayList<MyOrderBean.Data>) totalList);
    }

    @Override
    protected String url() {
        return ApiConstant.FLOW;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "order_list");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("status", type);
        return super.map();
    }

    @Override
    protected Class<MyOrderBean> getTClass() {
        return MyOrderBean.class;
    }

    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return TextUtils.isEmpty(type);
    }

    @Override
    protected boolean writeCache() {
        return false;
    }
}
