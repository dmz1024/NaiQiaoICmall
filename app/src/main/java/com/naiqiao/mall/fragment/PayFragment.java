package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.controller.PayController;

import java.util.List;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import util.DrawableUtil;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class PayFragment extends NotNetWorkBaseFragment {
    private String id;
    private String price;
    private int count;
    private int type = 1;
    private int oldType = 1;

    public static PayFragment getInstance(String id, String price, int count) {
        PayFragment fragment = new PayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putString("price", price);
        bundle.putInt("count", count);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");
            price = bundle.getString("price");
            count = bundle.getInt("count");
        }
    }

    @BindViews({R.id.tv_he, R.id.tv_zhi, R.id.tv_wei, R.id.tv_yin})
    List<TextView> tvs;

    @BindView(R.id.tv_price)
    TextView tv_price;


    @Override
    protected void initData() {

    }


    @Override
    protected int getRId() {
        return R.layout.fragment_pay;
    }


    @OnClick({R.id.tv_he, R.id.tv_zhi, R.id.tv_wei, R.id.tv_yin})
    void tvOnclick(View view) {
        switch (view.getId()) {
            case R.id.tv_he:
                type = 1;
                break;
            case R.id.tv_zhi:
                type = 2;
                break;
            case R.id.tv_wei:
                type = 3;
                break;
            case R.id.tv_yin:
                type = 4;
                break;
        }

        if (type != oldType) {
            setDrawable(tvs.get(oldType - 1), R.mipmap.icon_pay_check);
            setDrawable(tvs.get(type - 1), R.mipmap.icon_pay_checked);
            oldType = type;
        }

    }

    @OnClick(R.id.bt_pay)
    void pay() {
        switch (type){
            case 1:
                break;
            case 2:
                PayController.getInstance().setCtx(getContext()).ali(id);
                break;
            case 3:
                PayController.getInstance().setCtx(getContext()).wechat(id);
                break;
            case 4:
                break;
        }
    }

    private void setDrawable(TextView tv, int rid) {
        tv.setCompoundDrawables(DrawableUtil.setBounds(tv.getCompoundDrawables()[0]), null, DrawableUtil.setBounds(getResources().getDrawable(rid)), null);

    }


    @Override
    protected void initView() {
        tv_price.setText("共计" + count + "件商品，需支付：￥" + price);
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("选择支付方式");
    }
}
