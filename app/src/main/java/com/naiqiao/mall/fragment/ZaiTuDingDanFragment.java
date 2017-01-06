package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.MyOrderAdapter;
import com.naiqiao.mall.adapter.ZaiTuDingDanAdapter;
import com.naiqiao.mall.bean.MyOrderBean;
import com.naiqiao.mall.bean.ZaiTuDingDanBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class ZaiTuDingDanFragment extends ListNetWorkBaseFragment<MyOrderBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyOrderAdapter(getContext(), (ArrayList<MyOrderBean.Data>) totalList);
    }

    @Override
    protected String url() {
        return ApiConstant.FLOW;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "order_list");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("status", "3");
        return super.map();
    }

    @Override
    protected Class<MyOrderBean> getTClass() {
        return MyOrderBean.class;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("在途订单");
    }

    @Override
    protected View getTitleBarView() {
        return new DefaultTitleBarView(getContext());
    }

}
