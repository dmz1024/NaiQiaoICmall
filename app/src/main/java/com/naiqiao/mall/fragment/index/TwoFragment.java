package com.naiqiao.mall.fragment.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.MyAdapter;
import com.naiqiao.mall.User;
import com.naiqiao.mall.view.OneAndTwoTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class TwoFragment extends ListNetWorkBaseFragment<User> {

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyAdapter(getContext(), (ArrayList<User.Data>) totalList);
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
    protected Class<User> getTClass() {
        return User.class;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }

    @Override
    protected void initTitleView() {

    }

    @Override
    protected View getTitleBarView() {
        return new OneAndTwoTitleBarView(getContext());
    }

    @Override
    protected float top() {
        return 65;
    }
}
