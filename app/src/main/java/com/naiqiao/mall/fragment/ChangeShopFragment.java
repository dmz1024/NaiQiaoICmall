package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.AddressAdapter;
import com.naiqiao.mall.adapter.ChooseChangeShopAdapter;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.ChangeShopBean;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class ChangeShopFragment extends ListNetWorkBaseFragment<ChangeShopBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new ChooseChangeShopAdapter(getContext(), (ArrayList<ChangeShopBean.Data>) totalList);
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
    protected Class<ChangeShopBean> getTClass() {
        return ChangeShopBean.class;
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
    protected View getNoDataView() {
        View view = View.inflate(getContext(), R.layout.view_no_data_change_shop, null);
        return view;
    }
}
