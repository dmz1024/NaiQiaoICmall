package com.naiqiao.mall.fragment.index;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.naiqiao.mall.MyAdapter;
import com.naiqiao.mall.bean.User;
import com.naiqiao.mall.view.OneAndTwoTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.bean.TipLoadingBean;
import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class OneFragment extends ListNetWorkBaseFragment<User> {

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

    }


    @Override
    protected View getTitleBarView() {
        return new OneAndTwoTitleBarView(getContext());
    }

    @Override
    protected float top() {
        return 55;
    }
}
