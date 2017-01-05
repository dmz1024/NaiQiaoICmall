package com.naiqiao.mall.fragment;


import android.support.v7.widget.RecyclerView;

import base.bean.rxbus.AddFragmentBean;

import com.naiqiao.mall.adapter.MyJiFenAdapter;
import com.naiqiao.mall.bean.JiaoYiJLBean;
import com.naiqiao.mall.bean.MyJIFenBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.fragment.base.JiaoYiJiFenFanDianBaseFragment;

import java.util.ArrayList;
import java.util.Map;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/25.
 * 我的积分
 */

public class MyJiFenFragment extends JiaoYiJiFenFanDianBaseFragment<MyJIFenBean>  {

    @Override
    protected String url() {
        return ApiConstant.USER;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "transform_points");
        return super.map();
    }

    @Override
    protected Class<MyJIFenBean> getTClass() {
        return MyJIFenBean.class;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyJiFenAdapter(getContext(), (ArrayList<MyJIFenBean.Data>) totalList);
    }


    @Override
    protected void initTitleView() {
        super.initTitleView();
        titleBarView.setTitleContent("我的积分");
        titleBarView.setButtonTitle("积分商城");
    }

    @Override
    public void rightBt() {
        RxBus.get().post("addFragment",new AddFragmentBean(new JiFenDuiContentFragment()));
    }

    @Override
    protected void writeData(boolean isWrite, MyJIFenBean bean) {
        super.writeData(isWrite, bean);
        titleBarView.setPrice("积分余额：" + bean.rank_points);
    }
}
