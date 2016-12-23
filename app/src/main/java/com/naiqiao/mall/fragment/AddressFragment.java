package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.AddressAdapter;
import com.naiqiao.mall.adapter.SendCarAdapter;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.SendCarBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import api.TestConstant;
import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class AddressFragment extends ListNetWorkBaseFragment<AddressBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new AddressAdapter(getContext(), (ArrayList<AddressBean.Data>) totalList);
    }


    @Override
    protected String url() {
        return ApiConstant.AREA;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "send_address");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    protected Class<AddressBean> getTClass() {
        return AddressBean.class;
    }


    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("收货地址");
    }
}
