package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.JiaoYi_JiFen_FanDianAdapter;
import com.naiqiao.mall.adapter.MyFaPiaoAdapter;
import com.naiqiao.mall.bean.JiaoYi_JiFen_FanDianBean;
import com.naiqiao.mall.bean.MyFaPiaoBean;
import com.naiqiao.mall.bean.MyFanDianBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.fragment.base.JiaoYiJiFenFanDianBaseFragment;
import com.naiqiao.mall.interfaces.OnJiaoYi_JiFen_FanDianTitleBarListener;
import com.naiqiao.mall.view.JiaoYi_JiFen_FanDianTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class MyFaPiaoFragment extends JiaoYiJiFenFanDianBaseFragment<MyFaPiaoBean> {

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyFaPiaoAdapter(getContext(), (ArrayList<MyFaPiaoBean.Data>) totalList);
    }

    @Override
    protected String url() {
        return ApiConstant.INVOICE;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "invoice_list");
        return super.map();
    }

    @Override
    protected Class<MyFaPiaoBean> getTClass() {
        return MyFaPiaoBean.class;
    }

    @Override
    protected void initTitleView() {
        super.initTitleView();
        titleBarView.setButtonTitle("申请开票").setTitleContent("我的发票");
    }

    @Override
    protected void writeData(boolean isWrite, MyFaPiaoBean bean) {
        super.writeData(isWrite, bean);
        titleBarView.setPrice("可开发票额度：" + bean.cou_money);
    }
}
