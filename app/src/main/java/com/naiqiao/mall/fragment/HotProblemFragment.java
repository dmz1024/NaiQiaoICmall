package com.naiqiao.mall.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.AllShopAdapter;
import com.naiqiao.mall.adapter.HotProblemAdapter;
import com.naiqiao.mall.bean.AllShopBean;
import com.naiqiao.mall.bean.HotProblemBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class HotProblemFragment extends ListNetWorkBaseFragment<HotProblemBean> {


    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new HotProblemAdapter(getContext(), (ArrayList<HotProblemBean.Data>) totalList);
    }


    @Override
    protected View getTitleBarView() {
        return null;
    }



    @Override
    protected String url() {
        return ApiConstant.HELP;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "hot_question");
        return super.map();
    }

    @Override
    protected Class<HotProblemBean> getTClass() {
        return HotProblemBean.class;
    }


    @Override
    protected boolean isCanRefresh() {
        return false;
    }

    @Override
    protected boolean getLoadMore() {
        return false;
    }
}
