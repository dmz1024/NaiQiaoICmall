package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.ZaiTuDingDanAdapter;
import com.naiqiao.mall.bean.ZaiTuDingDanBean;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class ZaiTuDingDanFragment extends ListNetWorkBaseFragment<ZaiTuDingDanBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new ZaiTuDingDanAdapter(getContext(), (ArrayList<ZaiTuDingDanBean.Data>) totalList);
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
    protected Class<ZaiTuDingDanBean> getTClass() {
        return ZaiTuDingDanBean.class;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("在途订单");
    }

    @Override
    protected View getTitleBarView() {
        return new DefaultTitleBarView(getContext());
    }

}
