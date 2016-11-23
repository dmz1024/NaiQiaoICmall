package com.naiqiao.mall.fragment.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.naiqiao.mall.MyAdapter;
import com.naiqiao.mall.User;
import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import base.recycleBin.DefaultTitleBarListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class OneFragment extends ListNetWorkBaseFragment<User> {
    private String page;

    public static OneFragment getInstance(String page) {
        Bundle bundle = new Bundle();
        bundle.putString("page", page);
        OneFragment myFragment = new OneFragment();
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getString("page");
    }

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
        return true;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView defaultTitleBarView= (DefaultTitleBarView) getTitleBar();
        defaultTitleBarView.showVisiLeft(View.GONE).setTitleContent("首页");
    }
}
