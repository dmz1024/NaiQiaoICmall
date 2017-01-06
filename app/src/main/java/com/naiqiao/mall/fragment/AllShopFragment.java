package com.naiqiao.mall.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.AllShopAdapter;
import com.naiqiao.mall.adapter.MyCollectAdapter;
import com.naiqiao.mall.bean.AllShopBean;
import com.naiqiao.mall.bean.MyCollectBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
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
        return ApiConstant.VIRTUAL;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "index");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("sort",sort);
        return super.map();
    }

    @Override
    protected Class<AllShopBean> getTClass() {
        return AllShopBean.class;
    }


    public boolean right(boolean isVertical) {
        if (mAdapter == null) {
            return false;
        }
        ((AllShopAdapter) mAdapter).setVertical(isVertical ? 1 : 2);
        int firstVisiItem = layoutManager.findFirstVisibleItemPosition();
        recyclerView.setLayoutManager(layoutManager = (isVertical ? new LinearLayoutManager(getContext()) : new GridLayoutManager(getContext(), 2)));
        mAdapter.notifyDataSetChanged();
        layoutManager.scrollToPosition(firstVisiItem);
        return true;
    }

    private String sort;

    public void filter(String sort) {
        this.sort = sort;
        startRefresh();
    }

}
