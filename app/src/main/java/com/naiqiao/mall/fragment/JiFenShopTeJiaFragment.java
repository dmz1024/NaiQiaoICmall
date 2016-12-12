package com.naiqiao.mall.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naiqiao.mall.adapter.JiFenShopTeJiaAdapter;
import com.naiqiao.mall.bean.JiFenShopTeJiaBean;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/12/12.
 */

public class JiFenShopTeJiaFragment extends ListNetWorkBaseFragment<JiFenShopTeJiaBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new JiFenShopTeJiaAdapter(getContext(), (ArrayList<JiFenShopTeJiaBean.Data>) totalList);
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
    protected Class<JiFenShopTeJiaBean> getTClass() {
        return JiFenShopTeJiaBean.class;
    }

    @Override
    protected LinearLayoutManager getLayoutManager() {
        return new GridLayoutManager(getContext(),2);
    }
}
