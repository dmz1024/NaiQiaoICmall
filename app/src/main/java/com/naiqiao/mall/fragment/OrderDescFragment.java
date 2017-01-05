package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.ShopAdapter;
import com.naiqiao.mall.bean.MyOrderDescBean;
import com.naiqiao.mall.bean.ShopBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import view.Color2Text;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class OrderDescFragment extends SingleNetWorkBaseFragment<MyOrderDescBean> {
    private String id;
    @BindView(R.id.tv_address)
    Color2Text tv_address;
    @BindView(R.id.tv_order_info)
    TextView tv_order_info;
    @BindView(R.id.tv_price)
    TextView tv_price;

    public static OrderDescFragment getInstance(String id) {
        OrderDescFragment fragment = new OrderDescFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");
        }
    }

    @BindView(R.id.rv_shop)
    RecyclerView rv_shop;

    @Override
    protected String url() {
        return ApiConstant.FLOW;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "order_detail");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("order_id", id);
        return super.map();
    }

    @Override
    protected void writeData(boolean isWrite, MyOrderDescBean bean) {
        super.writeData(isWrite, bean);
        creatShops(bean.data.data2);
        goodsInfo(bean.data.data1);
    }


    private void goodsInfo(MyOrderDescBean.Data.Data1Bean data) {

    }


    private void creatShops(ArrayList<ShopBean> shops) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        ShopAdapter mAdapter = new ShopAdapter(getContext(), shops);
        rv_shop.setAdapter(mAdapter);
        rv_shop.setLayoutManager(manager);
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
