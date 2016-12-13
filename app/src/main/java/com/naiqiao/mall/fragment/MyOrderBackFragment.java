package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.naiqiao.mall.adapter.MyOrderAdapter;
import com.naiqiao.mall.adapter.MyOrderBackAdapter;
import com.naiqiao.mall.bean.MyOrderBackBean;
import com.naiqiao.mall.bean.MyOrderBean;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class MyOrderBackFragment extends ListNetWorkBaseFragment<MyOrderBackBean> {

    private String type = "";

    public static MyOrderBackFragment getInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        MyOrderBackFragment fragment = new MyOrderBackFragment();
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
        return new MyOrderBackAdapter(getContext(), (ArrayList<MyOrderBackBean.Data>) totalList);
    }

    @Override
    protected String url() {
        return "http://www.ediancha.com/app.php";
    }

    @Override
    protected Map<String, String> map() {
        map.put("c", "chahui");
        map.put("a", "index");
        map.put("type", "1");
        return super.map();
    }

    @Override
    protected Class<MyOrderBackBean> getTClass() {
        return MyOrderBackBean.class;
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
