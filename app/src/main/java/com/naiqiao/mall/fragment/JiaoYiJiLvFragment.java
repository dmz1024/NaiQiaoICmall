package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.JiaoYiJLAdapter;
import com.naiqiao.mall.adapter.JiaoYi_JiFen_FanDianAdapter;
import com.naiqiao.mall.bean.JiaoYiJLBean;
import com.naiqiao.mall.bean.JiaoYi_JiFen_FanDianBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.fragment.base.JiaoYiJiFenFanDianBaseFragment;
import com.naiqiao.mall.view.JiaoYi_JiFen_FanDianTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.bean.TipLoadingBean;
import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class JiaoYiJiLvFragment extends JiaoYiJiFenFanDianBaseFragment<JiaoYiJLBean> {

    @Override
    protected String url() {
        return ApiConstant.USER;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "order_all");
        return super.map();
    }

    @Override
    protected Class<JiaoYiJLBean> getTClass() {
        return JiaoYiJLBean.class;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new JiaoYiJLAdapter(getContext(), (ArrayList<JiaoYiJLBean.Data>) totalList);
    }


    @Override
    protected void initTitleView() {
        super.initTitleView();
        titleBarView.setTitleContent("交易记录");
    }


    @Override
    protected void writeData(boolean isWrite, JiaoYiJLBean bean) {
        super.writeData(isWrite, bean);
        titleBarView.setPrice("合计金额：" + bean.amount+"元");
    }
}
