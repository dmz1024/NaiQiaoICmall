package com.naiqiao.mall.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.adapter.TwoRightAdapter;
import com.naiqiao.mall.bean.TwoRightBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.fragment.index.IndexContentFragment;

import java.util.ArrayList;
import java.util.Map;

import base.bean.TipLoadingBean;
import base.fragment.ListNetWorkBaseFragment;
import base.other.ItemDecoration;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class TwoRightFragment extends ListNetWorkBaseFragment<TwoRightBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new TwoRightAdapter(getContext(), (ArrayList<TwoRightBean.Data>) totalList);
    }


    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected String url() {
        return ApiConstant.CATEGORY;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "index");
        if (!TextUtils.isEmpty(cat_id)) {
            map.put("cat_id", cat_id);
        }
        return super.map();
    }

    private String cat_id;

    public void filter(String cat_id) {

        this.cat_id = cat_id;
        setFirst(true);
        startRefresh();
    }


    @Override
    protected String getBackColor() {
        return "#f5f5f5";
    }

    @Override
    protected Class<TwoRightBean> getTClass() {
        return TwoRightBean.class;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }


    @Override
    protected boolean isCanRefresh() {
        return false;
    }

    @Override
    protected boolean writeCache() {
        return true;
    }

    @Override
    protected boolean shouldCache() {
        return true;
    }

    @Override
    protected boolean getLoadMore() {
        return false;
    }

//    @Override
//    protected TipLoadingBean getTipLoadingBean() {
//        return ((IndexContentFragment) getParentFragment().getParentFragment()).currentPosition() == 1 ? new TipLoadingBean() : null;
//    }


    @Override
    protected View getIsLoadingView() {
        TextView view = (TextView) View.inflate(getContext(), com.mall.naiqiao.mylibrary.R.layout.net_work_show_view, null);
        return view;
    }

    @Override
    protected RecyclerView.ItemDecoration getDividerItemDecoration() {
        return new ItemDecoration(getContext(), LinearLayoutManager.VERTICAL, 20, "#f5f5f5");
    }
}
