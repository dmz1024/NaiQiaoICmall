package com.naiqiao.mall.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.IndexSearchHotAdapter;
import com.naiqiao.mall.bean.IndexHotBean;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/28.
 */

public class IndexSearchHotFragment extends ListNetWorkBaseFragment<IndexHotBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new IndexSearchHotAdapter(getContext(), (ArrayList) totalList);
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
    protected LinearLayoutManager getLayoutManager() {
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return layoutManager;
    }

    @Override
    protected Class<IndexHotBean> getTClass() {
        return IndexHotBean.class;
    }

    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }

    @Override
    protected boolean getLoadMore() {
        return false;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return true;
    }

    @Override
    protected String getBackColor() {
        return "#ffffff";
    }

}
