package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.YiFaHuoAdapter;
import com.naiqiao.mall.adapter.ZaiTuDingDanAdapter;
import com.naiqiao.mall.bean.YiFaHuoBean;
import com.naiqiao.mall.bean.ZaiTuDingDanBean;
import com.naiqiao.mall.view.RightImageTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class YiFaHuoFragment extends ListNetWorkBaseFragment<YiFaHuoBean> {

    private String type = "";

    public static YiFaHuoFragment getInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        YiFaHuoFragment fragment = new YiFaHuoFragment();
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
        return new YiFaHuoAdapter(getContext(), (ArrayList<YiFaHuoBean.Data>) totalList);
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
    protected Class<YiFaHuoBean> getTClass() {
        return YiFaHuoBean.class;
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
