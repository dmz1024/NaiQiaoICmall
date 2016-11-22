package com.naiqiao.mall;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;

import base.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class MyFragmentRefresh extends ListNetWorkBaseFragment<User> {

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyAdapter(getContext(), (ArrayList<User.Data>) totalList);
    }


    @Override
    protected ShowCurrentViewENUM getDefaultView() {
        return ShowCurrentViewENUM.VIEW_IS_LOADING;
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
    protected boolean isOnlyInitOne() {
        return false;
    }
}
