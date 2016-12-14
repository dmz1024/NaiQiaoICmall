package com.naiqiao.mall.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.AllShopAdapter;
import com.naiqiao.mall.adapter.MyCollectAdapter;
import com.naiqiao.mall.bean.AllShopBean;
import com.naiqiao.mall.bean.MyCollectBean;
import com.naiqiao.mall.view.RightImageTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import interfaces.OnTitleBarListener;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class AllShopFragment extends ListNetWorkBaseFragment<AllShopBean> {


    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new AllShopAdapter(getContext(), (ArrayList<AllShopBean.Data>) totalList);
    }


    @Override
    protected View getTitleBarView() {
        return null;
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
    protected Class<AllShopBean> getTClass() {
        return AllShopBean.class;
    }


    public void right(boolean isVertical) {
        ((AllShopAdapter) mAdapter).setVertical(isVertical ? 1 : 2);
        int firstVisiItem = layoutManager.findFirstVisibleItemPosition();
        recyclerView.setLayoutManager(layoutManager = (isVertical ? new LinearLayoutManager(getContext()) : new GridLayoutManager(getContext(), 2)));
        mAdapter.notifyDataSetChanged();
        layoutManager.scrollToPosition(firstVisiItem);
    }


}
