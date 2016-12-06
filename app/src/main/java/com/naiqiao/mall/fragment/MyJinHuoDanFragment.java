package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.MyJinHuoDanAdapter;
import com.naiqiao.mall.bean.MyJinHuoDanBean;
import com.naiqiao.mall.bean.SendCarBean;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class MyJinHuoDanFragment extends ListNetWorkBaseFragment<MyJinHuoDanBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyJinHuoDanAdapter(getContext(), (ArrayList<MyJinHuoDanBean.Data>) totalList);
    }


    @Override
    protected View getTitleBarView() {
        return null;
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
    protected Class<MyJinHuoDanBean> getTClass() {
        return MyJinHuoDanBean.class;
    }


}
