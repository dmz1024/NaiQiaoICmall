package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.JiaoYiJiLvAdapter;
import com.naiqiao.mall.bean.JiaoYiJiLvBean;
import com.naiqiao.mall.view.JiaoYiJilvTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.bean.TipLoadingBean;
import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class JiaoYiJiLvFragment extends ListNetWorkBaseFragment<JiaoYiJiLvBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new JiaoYiJiLvAdapter(getContext(), (ArrayList<JiaoYiJiLvBean.Data>) totalList);
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
    protected Class<JiaoYiJiLvBean> getTClass() {
        return JiaoYiJiLvBean.class;
    }

    @Override
    protected TipLoadingBean getTipLoadingBean() {
        return new TipLoadingBean();
    }

    @Override
    protected void initTitleView() {
        ((JiaoYiJilvTitleBarView) getTitleBar()).setTitleContent("交易记录");
    }

    @Override
    protected View getTitleBarView() {
        return new JiaoYiJilvTitleBarView(getContext());
    }

    @Override
    protected float top() {
        return 80;
    }
}
