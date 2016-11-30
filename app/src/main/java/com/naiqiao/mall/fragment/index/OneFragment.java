package com.naiqiao.mall.fragment.index;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.naiqiao.mall.adapter.SendCarAdapter;
import com.naiqiao.mall.bean.SendCarBean;
import com.naiqiao.mall.bean.User;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.fragment.IndexSearchFragment;
import com.naiqiao.mall.view.OneAndTwoTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import interfaces.OnTitleBarListener;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class OneFragment extends ListNetWorkBaseFragment<SendCarBean> implements OnTitleBarListener {

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new SendCarAdapter(getContext(), (ArrayList<SendCarBean.Data>) totalList);
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
    protected Class<SendCarBean> getTClass() {
        return SendCarBean.class;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return true;
    }

    @Override
    protected void initTitleView() {
        OneAndTwoTitleBarView titleBarView= (OneAndTwoTitleBarView) getTitleBar();
        titleBarView.setOnTitleBarListener(this);
    }


    @Override
    protected View getTitleBarView() {
        return new OneAndTwoTitleBarView(getContext());
    }

    @Override
    protected float top() {
        return 55;
    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public void center() {
        RxBus.get().post("addFragment",new AddFragmentBean(new IndexSearchFragment()));
    }
}
