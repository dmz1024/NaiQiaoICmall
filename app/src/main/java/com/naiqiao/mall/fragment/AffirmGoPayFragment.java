package com.naiqiao.mall.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.ShopAdapter;
import com.naiqiao.mall.bean.AffirmGoPayBean;
import com.naiqiao.mall.bean.GoPayDoneBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.view.ViewSendCode;

import java.util.HashMap;
import java.util.Map;

import api.ApiRequest;
import base.bean.TipLoadingBean;
import base.bean.rxbus.AddFragmentBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import interfaces.OnSingleRequestListener;
import util.JLogUtils;
import util.MyToast;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2017/2/6.
 */

public class AffirmGoPayFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.tv_pay_type)
    TextView tv_pay_type;
    @BindView(R.id.tv_address)
    TextView tv_address;
    @BindView(R.id.tv_bei)
    TextView tv_bei;
    @BindView(R.id.tv_price)
    TextView tv_price;
    @BindView(R.id.tv_submit)
    TextView tv_submit;
    @BindView(R.id.vsc_code)
    ViewSendCode vsc_code;
    @BindView(R.id.tv_fp)
    TextView tv_fp;
    @BindView(R.id.rv_shop)
    RecyclerView rv_shop;
    private AffirmGoPayBean data;

    public static AffirmGoPayFragment getInstance(AffirmGoPayBean data) {
        AffirmGoPayFragment fragment = new AffirmGoPayFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            data = bundle.getParcelable("data");
        }
    }

    @Override
    protected void initData() {
        vsc_code.setType("2");
        tv_pay_type.setText("购买方式：" + (data.type == 0 ? "直接购买" : "存入虚拟仓"));
        tv_address.setText(TextUtils.isEmpty(data.address) ? "无" : data.address);
        JLogUtils.D(data.fp_content);
        tv_fp.setText(TextUtils.isEmpty(data.fp_content) ? "无" : data.fp_content);
        tv_price.setText("共" + data.count + "件商品，总计：￥" + data.price + "(包含运费)");
        tv_bei.setText("备注：" + (TextUtils.isEmpty(data.postscript) ? "无" : data.postscript));

        LinearLayoutManager manager = new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        ShopAdapter adapter = new ShopAdapter(getContext(), data.shops);
        rv_shop.setLayoutManager(manager);
        rv_shop.setAdapter(adapter);
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_affirm_gopay;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("确认发货单");
    }

    @OnClick(R.id.tv_submit)
    void submit() {
        final String code = vsc_code.getCode();
        if (TextUtils.isEmpty(code)) {
            MyToast.showToast("请输入验证码");
            return;
        }
        new ApiRequest<GoPayDoneBean>() {
            @Override
            protected Map<String, String> getMap() {
                Map<String, String> map = new HashMap<>();
                map.put("user_id", UserInfo.uid);
                map.put("sign_token", UserInfo.token);
                map.put("postscript", data.postscript);
                map.put("surplus", data.surplus);
                map.put("type", data.type + "");
                map.put("address_id", data.address_id);
                map.put("inv_type", data.inv_type);
                map.put("code", code);
                if (data.need_inv == 1) {
                    map.put("need_inv", data.need_inv + "");
                    map.put("inv_content", data.inv_content);
                    map.put("inv_payee", data.inv_payee);
                }
                map.put("act", "done");
                return map;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.FLOW;
            }

            @Override
            protected boolean getShowSucces() {
                return false;
            }

            @Override
            protected Context getContext() {
                return AffirmGoPayFragment.this.getContext();
            }

            @Override
            protected Class<GoPayDoneBean> getClx() {
                return GoPayDoneBean.class;
            }
        }.setOnRequestListeren(new OnSingleRequestListener<GoPayDoneBean>() {

            @Override
            public void succes(boolean isWrite, GoPayDoneBean bean) {
                RxBus.get().post("addFragment", new AddFragmentBean(PayFragment.getInstance(bean.data.order_id, bean.data.order_amount, data.count)));
            }

            @Override
            public void error(boolean isWrite, GoPayDoneBean bean, String msg) {

            }
        }).post(new TipLoadingBean("正在提交...", "", ""));
    }
}
