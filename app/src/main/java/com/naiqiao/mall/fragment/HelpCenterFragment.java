package com.naiqiao.mall.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.HelpServerAdapter;
import com.naiqiao.mall.bean.HelpServerBean;
import com.naiqiao.mall.fragment.index.FourFragment;

import java.util.ArrayList;
import java.util.List;

import base.fragment.NotNetWorkBaseFragment;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2017/1/3.
 */

public class HelpCenterFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.rv_content)
    RecyclerView rv_content;
    @BindViews({R.id.tv_qq, R.id.tv_tel, R.id.tv_online, R.id.tv_more})
    List<TextView> tvs;

    @Override
    protected void initData() {
        initSerVer();
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, new HotProblemFragment()).commit();
    }

    private void initSerVer() {
        ArrayList<HelpServerBean> helps = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            helps.add(new HelpServerBean(new FourFragment(), R.mipmap.help_menu_01, "帮助中心"));
        }
        HelpServerAdapter mAdapter = new HelpServerAdapter(getContext(), helps);
        GridLayoutManager mManager = new GridLayoutManager(getContext(), 4);
        rv_content.setLayoutManager(mManager);
        rv_content.setAdapter(mAdapter);
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_help_center;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("帮助中心");
    }
}
