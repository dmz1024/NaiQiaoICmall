package com.naiqiao.mall.fragment;

import android.support.v4.app.LoaderManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.MyCollectAdapter;
import com.naiqiao.mall.adapter.MyJinHuoDanAdapter;
import com.naiqiao.mall.bean.MyCollectBean;
import com.naiqiao.mall.bean.MyJinHuoDanBean;
import com.naiqiao.mall.view.RightImageTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import interfaces.OnTitleBarListener;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class MyCollectFragment extends ListNetWorkBaseFragment<MyCollectBean> implements OnTitleBarListener {
    public boolean isVertical = true;

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyCollectAdapter(getContext(), (ArrayList<MyCollectBean.Data>) totalList);
    }


    @Override
    protected View getTitleBarView() {
        return new RightImageTitleBarView(getContext());
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
    protected Class<MyCollectBean> getTClass() {
        return MyCollectBean.class;
    }

    @Override
    protected LinearLayoutManager getLayoutManager() {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return isVertical ? 2 : 1;
            }
        });
        return layoutManager;
    }

    private RightImageTitleBarView titleBarView;

    @Override
    protected void initTitleView() {
        titleBarView = (RightImageTitleBarView) getTitleBar();
        titleBarView.setOnTitleBarListener(this).setTitleContent("我的收藏");
    }


    @Override
    public void left() {

    }

    @Override
    public void right() {
        titleBarView.setRightImage((isVertical = !isVertical) ? R.mipmap.icon_display_list : R.mipmap.icon_display_block);
        ((MyCollectAdapter) mAdapter).setVertical(isVertical);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void center() {

    }

    // 3，（可选）如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
//    mRecyclerView.setHasFixedSize(true);

}
