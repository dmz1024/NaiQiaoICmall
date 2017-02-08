package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.ShopBean;
import com.naiqiao.mall.view.AddAndSubView;
import com.naiqiao.mall.view.pop.BackShopUpdateAccountPopView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import base.bean.rxbus.AddFragmentBean;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class OnlyBackMoneyFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.ll_shop)
    LinearLayout ll_shop;
    @BindView(R.id.tv_total_money)
    TextView tv_total_money;
    @BindView(R.id.tv_return_type)
    TextView tv_return_type;
    @BindView(R.id.et_price)
    EditText et_price;
    @BindView(R.id.et_back_desc)
    EditText et_back_desc;
    @BindView(R.id.tv_max_price)
    TextView tv_max_price;
    @BindView(R.id.tv_back_acc)
    TextView tv_back_acc;


    private ArrayList<ShopBean> shops;
    private String id;
    private String type;
    private int count;

    public static OnlyBackMoneyFragment getInstance(ArrayList<ShopBean> shops, String id, String type) {
        OnlyBackMoneyFragment fragment = new OnlyBackMoneyFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", shops);
        bundle.putString("id", id);
        bundle.putString("type", type);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            shops = bundle.getParcelableArrayList("data");
            id = bundle.getString("id");
            type = bundle.getString("type");
            count = shops.size();
        }
    }

    @Override
    protected void initData() {
        creatShop();
    }

    private void creatShop() {

        for (int i = 0; i < shops.size(); i++) {
            ShopBean shopBean = shops.get(i);
            View view = View.inflate(getContext(), R.layout.item_only_back_money, null);
            ImageView iv_img = (ImageView) view.findViewById(R.id.iv_img);
            TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
            TextView tv_price = (TextView) view.findViewById(R.id.tv_price);
            TextView tv_count = (TextView) view.findViewById(R.id.tv_count);
            View view_line = view.findViewById(R.id.view_line);
            if (i == count - 1) {
                view_line.setVisibility(View.GONE);
            }
            Glide.with(getContext()).load(shopBean.goods_thumb).into(iv_img);
            tv_title.setText(shopBean.goods_name);
            tv_price.setText("￥" + shopBean.goods_price);
            tv_count.setText("X" + shopBean.count);
            ll_shop.addView(view);
        }

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_only_back_money;
    }

    @OnClick(R.id.bt_submit)
    void submit() {
        Map<String, String> map = new HashMap<>();

        RxBus.get().post("addFragment", new AddFragmentBean(new OnlyBackMoneySuccessFragment()));
    }

    @OnClick(R.id.tv_back_acc)
    void backAcc() {
        //TODO未完成
        new BackShopUpdateAccountPopView(getContext()).showAtLocation(false);
    }
}
