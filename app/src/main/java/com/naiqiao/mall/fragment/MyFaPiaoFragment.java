package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.JiaoYi_JiFen_FanDianAdapter;
import com.naiqiao.mall.adapter.MyFaPiaoAdapter;
import com.naiqiao.mall.bean.JiaoYi_JiFen_FanDianBean;
import com.naiqiao.mall.bean.MyFaPiaoBean;
import com.naiqiao.mall.interfaces.OnJiaoYi_JiFen_FanDianTitleBarListener;
import com.naiqiao.mall.view.JiaoYi_JiFen_FanDianTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class MyFaPiaoFragment extends ListNetWorkBaseFragment<MyFaPiaoBean> implements OnJiaoYi_JiFen_FanDianTitleBarListener {
    protected JiaoYi_JiFen_FanDianTitleBarView titleBarView;

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyFaPiaoAdapter(getContext(), (ArrayList<MyFaPiaoBean.Data>) totalList);
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
    protected Class<MyFaPiaoBean> getTClass() {
        return MyFaPiaoBean.class;
    }


    @Override
    protected View getTitleBarView() {
        return titleBarView = new JiaoYi_JiFen_FanDianTitleBarView(getContext());
    }

    @Override
    protected void initTitleView() {
        titleBarView.setButtonTitle("申请开票").setTitleContent("我的发票");
    }

    @Override
    protected float top() {
        return 80;
    }

    @Override
    public void rightBt() {

    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public void center() {

    }
}
