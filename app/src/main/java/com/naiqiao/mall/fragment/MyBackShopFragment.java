package com.naiqiao.mall.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naiqiao.mall.adapter.MyBackShopAdapter;
import com.naiqiao.mall.bean.MyBackShopBean;

import java.util.ArrayList;
import java.util.Map;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.ListNetWorkBaseFragment;
import base.other.ItemDecoration;
import interfaces.OnTitleBarListener;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class MyBackShopFragment extends ListNetWorkBaseFragment<MyBackShopBean> implements OnTitleBarListener {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyBackShopAdapter(getContext(), (ArrayList<MyBackShopBean.Data>) totalList);
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
    protected RecyclerView.ItemDecoration getDividerItemDecoration() {
        return new ItemDecoration(getContext(), LinearLayoutManager.VERTICAL,1,"#e0e0e0");
    }

    @Override
    protected Class<MyBackShopBean> getTClass() {
        return MyBackShopBean.class;
    }


    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("我的进货")
                .setRightContent("申请换货")
                .setRightColor("#f73f5f")
                .setRightSize(14).setOnTitleBarListener(this);
    }

    @Override
    public void left() {

    }

    @Override
    public void right() {
        RxBus.get().post("addFragment",new AddFragmentBean(new ChangeShopRootFragment()));
    }

    @Override
    public void center() {

    }
}
