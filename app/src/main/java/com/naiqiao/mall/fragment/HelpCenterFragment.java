package com.naiqiao.mall.fragment;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.HelpServerAdapter;
import com.naiqiao.mall.adapter.HotProblemAdapter;
import com.naiqiao.mall.bean.HelpServerBean;
import com.naiqiao.mall.bean.HotProblemBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.fragment.index.FourFragment;
import com.naiqiao.mall.fragment.login.ForgetFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import base.fragment.NotNetWorkBaseFragment;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import util.Util;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2017/1/3.
 */

public class HelpCenterFragment extends SingleNetWorkBaseFragment<HotProblemBean> {
    @BindView(R.id.rv_content)
    RecyclerView rv_content;
    @BindView(R.id.iv_drop)
    ImageView iv_drop;
    @BindViews({R.id.tv_qq, R.id.tv_tel, R.id.tv_online, R.id.tv_more})
    List<TextView> tvs;
    @BindView(R.id.rv_hot)
    RecyclerView rv_hot;

    @OnClick({R.id.tv_qq, R.id.tv_tel, R.id.tv_online, R.id.tv_more})
    void tvOnclick(View view) {
        switch (view.getId()) {
            case R.id.tv_qq:
                Util.qq(getContext(), "1395386348");
                break;
            case R.id.tv_tel:
                Util.tel(getContext(), "18326167257");
                break;
            case R.id.tv_online:
                break;
            case R.id.tv_more:
                more();
                break;
        }
    }


    private void more() {
        isMore = !isMore;
        hotAdapter.showMore(isMore);
        tvs.get(3).setText(isMore ? "收起问题" : "查看问题");
        iv_drop.setImageResource(isMore ? R.mipmap.icon_go_up : R.mipmap.icon_go_down);
    }


    @Override
    protected String url() {
        return ApiConstant.HELP;
    }

    @Override
    protected void writeData(boolean isWrite, HotProblemBean bean) {
        super.writeData(isWrite, bean);
        initSerVer();
        initHot(bean.data);
    }

    private HotProblemAdapter hotAdapter;
    private boolean isMore;

    private void initHot(ArrayList<HotProblemBean.Data> data) {
        if (data.size() > 3) {
            ((View) tvs.get(3).getParent()).setVisibility(View.VISIBLE);
        }
        hotAdapter = new HotProblemAdapter(getContext(), data);
        LinearLayoutManager mManager = new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rv_hot.setLayoutManager(mManager);
        rv_hot.setAdapter(hotAdapter);
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "hot_question");
        return super.map();
    }

    @Override
    protected Class<HotProblemBean> getTClass() {
        return HotProblemBean.class;
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_help_center, null);
        ButterKnife.bind(this, view);
        return view;
    }


    private void initSerVer() {
        ArrayList<HelpServerBean> helps = new ArrayList<>();
        helps.add(new HelpServerBean(new FourFragment(), R.mipmap.help_menu_01, "在途订单"));
        helps.add(new HelpServerBean(new FourFragment(), R.mipmap.help_menu_02, "我已发货"));
        helps.add(new HelpServerBean(new FourFragment(), R.mipmap.help_menu_03, "邮费说明"));
        helps.add(new HelpServerBean(new SafeCenterFragment(), R.mipmap.help_menu_04, "安全中心"));
        helps.add(new HelpServerBean(new FourFragment(), R.mipmap.help_menu_05, "我要发货"));
        helps.add(new HelpServerBean(new FourFragment(), R.mipmap.help_menu_06, "积分商城"));
        helps.add(new HelpServerBean(null, R.mipmap.help_menu_07, "我要加盟"));
        helps.add(new HelpServerBean(new ForgetFragment(), R.mipmap.help_menu_08, "找回密码"));

        HelpServerAdapter mAdapter = new HelpServerAdapter(getContext(), helps);
        GridLayoutManager mManager = new GridLayoutManager(getContext(), 4) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rv_content.setLayoutManager(mManager);
        rv_content.setAdapter(mAdapter);
    }


    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("帮助中心");
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }
}
