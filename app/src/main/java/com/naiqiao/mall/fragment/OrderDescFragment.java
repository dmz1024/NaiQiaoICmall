package com.naiqiao.mall.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.ShopAdapter;
import com.naiqiao.mall.bean.MyOrderDescBean;
import com.naiqiao.mall.bean.ShopBean;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class OrderDescFragment extends SingleNetWorkBaseFragment<MyOrderDescBean> {
    @BindView(R.id.rv_shop)
    RecyclerView rv_shop;

    @Override
    protected String url() {
        return "http://www.ediancha.com/app.php";
    }

    @Override
    protected void writeData(boolean isWrite, MyOrderDescBean bean) {
        super.writeData(isWrite, bean);
        creatShops();
    }

    private void creatShops() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        ArrayList<ShopBean> shops = new ArrayList<>();
        shops.add(new ShopBean());
        shops.add(new ShopBean());
        shops.add(new ShopBean());
        shops.add(new ShopBean());
        shops.add(new ShopBean());
        shops.add(new ShopBean());
        ShopAdapter mAdapter = new ShopAdapter(getContext(), shops);
        rv_shop.setAdapter(mAdapter);
        rv_shop.setLayoutManager(manager);
    }

    @Override
    protected Map<String, String> map() {
        map.put("c", "chahui");
        map.put("a", "index");
        return super.map();
    }

    @Override
    protected Class<MyOrderDescBean> getTClass() {
        return MyOrderDescBean.class;
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_my_order_desc, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("订单详情");
    }
}
