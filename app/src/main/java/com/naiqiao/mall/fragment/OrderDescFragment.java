package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.ShopAdapter;
import com.naiqiao.mall.bean.MyOrderDescBean;
import com.naiqiao.mall.bean.ShopBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import view.Color2Text;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class OrderDescFragment extends SingleNetWorkBaseFragment<MyOrderDescBean> {
    private String id;
    @BindView(R.id.tv_address)
    Color2Text tv_address;
    @BindView(R.id.tv_order_info)
    TextView tv_order_info;
    @BindView(R.id.tv_price)
    TextView tv_price;
    @BindView(R.id.ll_wiliu)
    LinearLayout ll_wiliu;
    @BindView(R.id.tv_wuliu)
    TextView tv_wuliu;
    @BindView(R.id.rl_wuliu)
    RelativeLayout rl_wuliu;
    @BindView(R.id.tv_wuliu_info)
    TextView tv_wuliu_info;

    public static OrderDescFragment getInstance(String id) {
        OrderDescFragment fragment = new OrderDescFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");
        }
    }

    @BindView(R.id.rv_shop)
    RecyclerView rv_shop;

    @Override
    protected String url() {
        return ApiConstant.FLOW;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "order_detail");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("order_id", id);
        return super.map();
    }

    @Override
    protected void writeData(boolean isWrite, MyOrderDescBean bean) {
        super.writeData(isWrite, bean);
        creatShops(bean.data.data2);
        goodsInfo(bean.data.data1);
        wuliuInfo(bean.data.data3);
    }


    /**
     * 物流信息
     *
     * @param data
     */
    private void wuliuInfo(MyOrderDescBean.Data.Wuliu data) {
        if (TextUtils.isEmpty(data.shipping_name)) {
            return;
        }
        ll_wiliu.setVisibility(View.VISIBLE);

        if (data.info != null && data.info.size() > 0) {
            rl_wuliu.setVisibility(View.VISIBLE);
            tv_wuliu_info.setText(data.info.get(0).qsname + "\n" + data.info.get(0).time);

        }
        tv_wuliu.setText("物流公司：" + data.shipping_name + "\n物流单号：" + data.no);
    }


    private void goodsInfo(MyOrderDescBean.Data.Data1Bean data) {
        tv_address.setContentNotChange("收件人："+data.consignee+"     "+data.mobile+"\n");
        tv_address.setTextNotChange(data.group_address);
        tv_price.setText(data.formated_total_fee+"\n"+data.formated_shipping_fee);
        tv_order_info.setText("订单状态："+data.order_status+"\n订单编号："+data.order_sn+"\n操作时间："+data.pay_time);
    }


    private void creatShops(ArrayList<ShopBean> shops) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        ShopAdapter mAdapter = new ShopAdapter(getContext(), shops);
        rv_shop.setAdapter(mAdapter);
        rv_shop.setLayoutManager(manager);
    }


    @Override
    protected Class<MyOrderDescBean> getTClass() {
        return MyOrderDescBean.class;
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_my_order_desc, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("订单详情");
    }
}
