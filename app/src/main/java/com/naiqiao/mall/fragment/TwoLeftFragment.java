package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.adapter.TwoLeftAdapter;
import com.naiqiao.mall.bean.TwoLeftBean;

import java.util.ArrayList;
import java.util.Map;

import base.bean.TipLoadingBean;
import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class TwoLeftFragment extends ListNetWorkBaseFragment<TwoLeftBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new TwoLeftAdapter(getContext(), (ArrayList<TwoLeftBean.Data>) totalList);
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
        map.put("a", "index");
        map.put("c", "area");
        return super.map();
    }


    @Override
    protected String getBackColor() {
        return "#ffffff";
    }

    @Override
    protected Class<TwoLeftBean> getTClass() {
        return TwoLeftBean.class;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }

    @Override
    protected boolean getLoadMore() {
        return false;
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }


    @Override
    protected View getIsLoadingView() {
        TextView view = (TextView) View.inflate(getContext(), com.mall.naiqiao.mylibrary.R.layout.net_work_show_view, null);
        view.setText("正\n\n在\n\n加\n\n载\n.\n.\n.");
        return view;
    }

    @Override
    protected boolean writeCache() {
        return false;
    }

    @Override
    protected TipLoadingBean getTipLoadingBean() {
        return new TipLoadingBean();
    }
}
