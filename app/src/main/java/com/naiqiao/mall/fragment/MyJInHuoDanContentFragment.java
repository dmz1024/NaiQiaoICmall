package com.naiqiao.mall.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.SendMonadAdapter;
import com.naiqiao.mall.bean.SendMonadBean;

import java.util.ArrayList;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import util.DrawableUtil;
import view.Color2Text;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class MyJInHuoDanContentFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.tv_count)
    Color2Text tv_count;
    @BindView(R.id.tv_choose)
    TextView tv_choose;
    @BindView(R.id.bt_pay)
    Button bt_pay;
    private boolean isChoose = true;

    @Override
    protected int getRId() {
        return R.layout.fragment_jinhuodan;
    }

    private MyJinHuoDanFragment danFragment;

    @Override
    protected void initView() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, danFragment = new MyJinHuoDanFragment()).commit();
    }


    @Override
    protected void initData() {
        tv_count.setTextNotChange("共10件");
    }

    @OnClick(R.id.bt_pay)
    void payCar() {
    }

    @OnClick(R.id.tv_choose)
    void choose() {
        isChoose = !isChoose;
        changeChoose();
    }

    private void changeChoose() {
        tv_choose.setCompoundDrawables(DrawableUtil.setBounds(isChoose ? getResources().getDrawable(R.mipmap.icon_checked) : getResources().getDrawable(R.mipmap.icon_check)), null, null, null);
    }


    @Override
    protected void initTitleView() {
        DefaultTitleBarView defaultTitleBarView = (DefaultTitleBarView) getTitleBar();
        defaultTitleBarView.setTitleContent("我的进货单");
    }

}
