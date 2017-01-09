package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.view.ViewProgress;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/15.
 */

public class ChangeShopDescContentFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.view_pro)
    ViewProgress view_pro;
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.bt_pay)
    Button bt_pay;
    private int type;

    public static ChangeShopDescContentFragment getInstance(int type) {
        ChangeShopDescContentFragment descContentFragment = new ChangeShopDescContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        descContentFragment.setArguments(bundle);
        return descContentFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt("type");
        }
    }

    @Override
    protected void initData() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, new ChangeShopDescFragment()).commit();
    }



    @Override
    protected void initView() {
        view_pro.setTitle("待审核,待支付差价,换货成功");
        if (type != 0) {
            view_pro.setCurrentPosition(type);
        }
        switch (type) {
            case 0:
                tv_content.setText("温馨提示：换货单正在进行审核，详情咨询客服010-33232277");
                break;
            case 1:
                tv_content.setText("请在2016-12-20之前完成差价￥5666.00元的支付");
                bt_pay.setVisibility(View.VISIBLE);
                break;
            case 2:
                tv_content.setText("温馨提示：换货订单已完成，详情咨询客服010-33232277");
                break;
        }

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_change_shop_desc_content;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("申请换货");
    }


}
