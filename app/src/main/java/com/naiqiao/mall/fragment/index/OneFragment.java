package com.naiqiao.mall.fragment.index;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.IndexOneAdapter;
import com.naiqiao.mall.adapter.IndexOneDesenoAdapter;
import com.naiqiao.mall.bean.IndexOneBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.fragment.IndexSearchFragment;
import com.naiqiao.mall.view.OneAndTwoTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.adapter.MyLoopPagerAdapter;
import base.bean.rxbus.AddFragmentBean;
import base.fragment.ListNetWorkBaseFragment;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import interfaces.OnTitleBarListener;
import interfaces.ScrollChangeViewListener;
import util.RxBus;
import view.ScrollChangeScrollView;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class OneFragment extends SingleNetWorkBaseFragment<IndexOneBean> implements OnTitleBarListener, ScrollChangeViewListener {
    @BindView(R.id.ll_root)
    LinearLayout ll_root;
    @BindView(R.id.sc_root)
    ScrollChangeScrollView sc_root;

    @Override
    protected String url() {
        return ApiConstant.INDEX_A;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "index");
        return super.map();
    }

    @Override
    protected Class<IndexOneBean> getTClass() {
        return IndexOneBean.class;
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_index_one, null);
        ButterKnife.bind(this, view);
        sc_root.setScrollViewListener(this);
        return view;
    }

    @Override
    protected void writeData(boolean isWrite, IndexOneBean bean) {
        super.writeData(isWrite, bean);
        ArrayList<IndexOneBean.Data> data = bean.data;
        ArrayList<IndexOneBean.HeaderBean> header = bean.header;
        if (!isWrite) {
            ll_root.removeAllViews();
        }

        for (int i = 0; i < header.size(); i++) {
            switch (header.get(i).type) {
                case 1:
                    creatView1(header.get(i).data1);
                    break;
                case 2:
                    creatView2(header.get(i).data1);
                    break;
                case 3:
                    creatView3(header.get(i).data3);
                    break;
                case 4:
                    creatView4(header.get(i).data4);
                    break;
                case 5:
                    creatView5(header.get(i).data5);
                    break;
            }
        }

        initTitleMore(data);
    }


    private void creatView1(ArrayList<IndexOneBean.HeaderBean.Data1Bean> data1) {
        View view = View.inflate(getContext(), R.layout.item_index_one_rvp, null);
        RollPagerView rpv_content = (RollPagerView) view.findViewById(R.id.rpv_content);
        rpv_content.setPlayDelay(data1.size() > 1 ? 4000 : 0);
        rpv_content.setHintView(new ColorPointHintView(getContext(), R.color.colorf73f5f, Color.WHITE));
        rpv_content.setAdapter(new MyLoopPagerAdapter(rpv_content,data1));
        ll_root.addView(view);
    }

    private void creatView2(ArrayList<IndexOneBean.HeaderBean.Data1Bean> data1) {

    }

    private void creatView3(ArrayList<IndexOneBean.HeaderBean.Data3Bean> data3) {
        RecyclerView rv_content = new RecyclerView(getContext());
        LinearLayoutManager managerDeseno = new LinearLayoutManager(getContext());
        managerDeseno.setOrientation(LinearLayoutManager.HORIZONTAL);
        IndexOneDesenoAdapter adapterDeseno = new IndexOneDesenoAdapter(getContext(), data3);
        rv_content.setLayoutManager(managerDeseno);
        rv_content.setAdapter(adapterDeseno);
        ll_root.addView(rv_content);
    }

    private void creatView4(ArrayList<IndexOneBean.HeaderBean.Data4Bean> data4) {

    }

    private void creatView5(IndexOneBean.HeaderBean.Data5Bean data5) {

    }

    private void initTitleMore(ArrayList<IndexOneBean.Data> data) {
        IndexOneAdapter mAdapter = new IndexOneAdapter(getContext(), data);
        LinearLayoutManager manager = new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        RecyclerView rv_content = new RecyclerView(getContext());
        rv_content.setLayoutManager(manager);
        rv_content.setAdapter(mAdapter);
        ll_root.addView(rv_content);
    }


    @Override
    protected void initTitleView() {
        ((OneAndTwoTitleBarView) getTitleBar()).setOnTitleBarListener(this);
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
    protected boolean isCanRefresh() {
        return false;
    }

    @Override
    public void center() {
        RxBus.get().post("addFragment", new AddFragmentBean(new IndexSearchFragment()));
    }


    @Override
    public void onScrollChanged(ScrollView scrollView, int x, int y, int oldx, int oldy) {

    }

    @Override
    protected boolean shouldCache() {
        return true;
    }

    @Override
    protected boolean writeCache() {
        return true;
    }
}
