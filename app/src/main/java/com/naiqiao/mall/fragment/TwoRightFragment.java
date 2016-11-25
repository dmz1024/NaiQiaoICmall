package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.MyAdapter;
import com.naiqiao.mall.bean.User;

import java.util.ArrayList;
import java.util.Map;

import base.bean.TipLoadingBean;
import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class TwoRightFragment extends ListNetWorkBaseFragment<User> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyAdapter(getContext(), (ArrayList<User.Data>) totalList);
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
    protected String getBackColor() {
        return "#f5f5f5";
    }

    @Override
    protected Class<User> getTClass() {
        return User.class;
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
        return false;
    }

    @Override
    protected boolean shouldCache() {
        return false;
    }

    @Override
    protected TipLoadingBean getTipLoadingBean() {
        return new TipLoadingBean();
    }


    @Override
    protected View getIsLoadingView() {
        TextView view = (TextView) View.inflate(getContext(), com.mall.naiqiao.mylibrary.R.layout.net_work_show_view, null);
        return view;
    }

}
