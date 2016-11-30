package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;

import com.naiqiao.mall.adapter.XiaoLiangPHAdapter;
import com.naiqiao.mall.bean.XiaoLiangPHBean;

import java.util.ArrayList;
import java.util.Map;

import base.bean.BaseBean;
import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/30.
 */

public class XiaoLiangPaiHangFragment extends ListNetWorkBaseFragment<XiaoLiangPHBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new XiaoLiangPHAdapter(getContext(), (ArrayList<XiaoLiangPHBean.Data>) totalList);
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
    protected Class<XiaoLiangPHBean> getTClass() {
        return XiaoLiangPHBean.class;
    }

    @Override
    protected String getBackColor() {
        return "#ffffff";
    }

    @Override
    protected boolean getLoadMore() {
        return false;
    }


    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBarView = (DefaultTitleBarView) getTitleBar();
        titleBarView.setTitleContent("单品销量排行");
    }
}
