package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;

import com.naiqiao.mall.adapter.DaoHuoTZAdapter;
import com.naiqiao.mall.adapter.TongZhiGGAdapter;
import com.naiqiao.mall.bean.DaoHuoTZBean;
import com.naiqiao.mall.bean.TongZhiGGBean;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/2.
 */

public class DaoHuoTZFragment extends ListNetWorkBaseFragment<DaoHuoTZBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new DaoHuoTZAdapter(getContext(), (ArrayList<DaoHuoTZBean.Data>) totalList);
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
    protected Class<DaoHuoTZBean> getTClass() {
        return DaoHuoTZBean.class;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBarView = (DefaultTitleBarView) getTitleBar();
        titleBarView.setTitleContent("通知公告");
    }
}
