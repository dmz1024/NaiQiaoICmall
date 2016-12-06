package com.naiqiao.mall.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.OrderSearchAdapter;
import com.naiqiao.mall.bean.OrderSearchBean;
import com.naiqiao.mall.view.IndexSearchTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/12/2.
 */

public class OrderSearchFragment extends ListNetWorkBaseFragment<OrderSearchBean> {

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new OrderSearchAdapter(getContext(), (ArrayList<OrderSearchBean.Data>) totalList);
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
    protected Class<OrderSearchBean> getTClass() {
        return OrderSearchBean.class;
    }


    @Override
    protected View getTitleBarView() {
        return new IndexSearchTitleBarView(getContext());
    }

    @Override
    protected void initTitleView() {
        IndexSearchTitleBarView titleBarView = (IndexSearchTitleBarView) getTitleBar();
        titleBarView.setEdHint("输入订单编号、商品名称");
    }


    @Override
    protected LinearLayoutManager getLayoutManager() {
        return new GridLayoutManager(getContext(), 4);
    }
}
