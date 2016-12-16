package com.naiqiao.mall.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.AffirmOrderAdapter;
import com.naiqiao.mall.bean.AffirmOrderBean;

import java.util.ArrayList;

import base.fragment.NotNetWorkBaseFragment;
import base.other.ItemDecoration;
import butterknife.BindView;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/16.
 */

public class AffirmOrderFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.bt_affirm)
    Button bt_affirm;
    @BindView(R.id.bt_update)
    Button bt_update;
    @BindView(R.id.rv_order)
    RecyclerView rv_order;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        creatOrder();
    }

    private void creatOrder() {
        ArrayList<AffirmOrderBean> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data.add(new AffirmOrderBean());
        }
        AffirmOrderAdapter mAdapter = new AffirmOrderAdapter(getContext(), data);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rv_order.setAdapter(mAdapter);
        rv_order.setLayoutManager(manager);
        rv_order.addItemDecoration(new ItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL, 10, "#f5f5f5"));
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_affirm_order;
    }


    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("确认订单");
    }
}
