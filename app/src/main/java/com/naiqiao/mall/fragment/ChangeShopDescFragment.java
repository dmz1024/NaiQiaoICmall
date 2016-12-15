package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.AddressAdapter;
import com.naiqiao.mall.adapter.ChangeShopDescAdapter;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.ChangeShopBean;
import com.naiqiao.mall.bean.ChangeShopDescBean;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class ChangeShopDescFragment extends ListNetWorkBaseFragment<ChangeShopDescBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new ChangeShopDescAdapter(getContext(), (ArrayList<ChangeShopDescBean.Data>) totalList);
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
    protected Class<ChangeShopDescBean> getTClass() {
        return ChangeShopDescBean.class;
    }


    @Override
    protected View getTitleBarView() {
        return null;
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
