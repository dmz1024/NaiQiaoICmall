package com.naiqiao.mall.fragment;

import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.FilterShopListAdapter;
import com.naiqiao.mall.adapter.SendCarAdapter;
import com.naiqiao.mall.bean.FilterShopListBean;
import com.naiqiao.mall.bean.SendCarBean;
import com.naiqiao.mall.constant.ApiConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class FilterShopListFragment extends ListNetWorkBaseFragment<FilterShopListBean> {


    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new FilterShopListAdapter(getContext(), (ArrayList<FilterShopListBean.Data>) totalList);
    }


    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected String url() {
        return ApiConstant.CATEGORY;
    }

    private Map<String, String> filterMap = new HashMap<>();

    @Override
    protected Map<String, String> map() {
        map.putAll(filterMap);
        return super.map();
    }

    public void setFilterMap(Map<String, String> filterMap) {
        this.filterMap.clear();
        map.clear();
        this.filterMap.putAll(filterMap);
    }

    @Override
    protected Class<FilterShopListBean> getTClass() {
        return FilterShopListBean.class;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return true;
    }

}
