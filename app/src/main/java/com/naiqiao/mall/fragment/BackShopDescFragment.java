package com.naiqiao.mall.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.BackShopDescBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.HashMap;
import java.util.Map;

import api.ApiRequest;
import base.bean.SingleBaseBean;
import base.bean.TipLoadingBean;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interfaces.OnSingleRequestListener;
import util.DrawableUtil;
import util.MyToast;
import view.Color2Text;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class BackShopDescFragment extends SingleNetWorkBaseFragment<BackShopDescBean> {
    @BindView(R.id.ll_shop)
    LinearLayout ll_shop;


    @BindView(R.id.tv_total_price)
    TextView tv_total_price;
    @BindView(R.id.tv_submit_info)
    TextView tv_submit_info;
    @BindView(R.id.tv_2)
    TextView tv_2;
    @BindView(R.id.tv_3)
    TextView tv_3;
    @BindView(R.id.rl_wuliu)
    RelativeLayout rl_wuliu;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;
    @BindView(R.id.tv_shenhe)
    Color2Text tv_shenhe;
    @BindView(R.id.ll_write_wuliu)
    LinearLayout ll_write_wuliu;
    @BindView(R.id.view_3)
    View view_3;
    @BindView(R.id.tv_caiwu_tip)
    TextView tv_caiwu_tip;
    @BindView(R.id.et_wl_name)
    EditText et_wl_name;
    @BindView(R.id.et_wl_sn)
    EditText et_wl_sn;
    @BindView(R.id.tv_wuliu_gs)
    TextView tv_wuliu_gs;
    @BindView(R.id.tv_wuliu_sn)
    TextView tv_wuliu_sn;
    @BindView(R.id.tv_caiwu_title)
    Color2Text tv_caiwu_title;

    public static BackShopDescFragment getInstance(String id) {
        BackShopDescFragment fragment = new BackShopDescFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @OnClick(R.id.bt_wl_write)
    void writeWl() {
        final String name = et_wl_name.getText().toString();
        if (TextUtils.isEmpty(name)) {
            MyToast.showToast("请填写物流名称");
            return;
        }
        final String sn = et_wl_sn.getText().toString();
        if (TextUtils.isEmpty(sn)) {
            MyToast.showToast("请填写物流单号");
            return;
        }

        new ApiRequest<SingleBaseBean>() {
            @Override
            protected Map<String, String> getMap() {
                Map<String, String> map = new HashMap<>();
                map.put("act", "ok_shipping");
                map.put("back_id", id);
                map.put("user_id", UserInfo.uid);
                map.put("shipping_name", name);
                map.put("invoice_no", sn);
                map.put("sign_token", UserInfo.token);
                return map;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.FLOW;
            }

            @Override
            protected Class<SingleBaseBean> getClx() {
                return SingleBaseBean.class;
            }

            @Override
            protected Context getContext() {
                return BackShopDescFragment.this.getContext();
            }

        }.setOnRequestListeren(new OnSingleRequestListener<SingleBaseBean>() {

            @Override
            public void succes(boolean isWrite, SingleBaseBean bean) {
                getData();
            }

            @Override
            public void error(boolean isWrite, SingleBaseBean bean, String msg) {

            }
        }).post(new TipLoadingBean("提交物流信息", "提交成功", ""));
    }


    private String id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");
        }
    }

    @Override
    protected String url() {
        return ApiConstant.FLOW;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "return_detail");
        map.put("back_id", id);
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    private int status;

    @Override
    protected Class<BackShopDescBean> getTClass() {
        return BackShopDescBean.class;
    }

    private BackShopDescBean bean;

    @Override
    protected void writeData(boolean isWrite, BackShopDescBean bean) {
        super.writeData(isWrite, bean);
        this.bean = bean;
        initStatus();
        creatShop();
        initInfo();
    }

    private void initStatus() {
        if(bean.data.back_order.back_type==2){
            switch (bean.data.back_order.status_a) {
                case 0:
                    tv_shenhe.setVisibility(View.VISIBLE);
                    tv_2.setText("正在审核");
                    tv_2.setTextColor(Color.parseColor("#666666"));
                    tv_2.setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_path_no)), null);
                    break;
                case 2:
                    tv_2.setText("审核失败");
                    tv_shenhe.setContentNotChange("退货申请审核失败，详情请");
                    rl_wuliu.setVisibility(View.VISIBLE);
                    rl_back.setVisibility(View.VISIBLE);
                    break;
                case 5:
                    tv_2.setText("审核通过\n填写物流");
                    ll_write_wuliu.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    tv_2.setText("审核通过");
                    rl_wuliu.setVisibility(View.VISIBLE);
                    rl_back.setVisibility(View.VISIBLE);
                    tv_wuliu_gs.setText("物流公司："+bean.data.kuaidi.shipping_name);
                    tv_wuliu_gs.setText("物流单号："+bean.data.kuaidi.invoice_no);
                    tv_3.setText("财务审核");
                    tv_caiwu_tip.setVisibility(View.VISIBLE);
                    view_3.setVisibility(View.VISIBLE);

                    break;
                case 9:
                    view_3.setVisibility(View.VISIBLE);
                    tv_3.setText("财务拒绝");
                    tv_2.setText("审核通过");
                    rl_wuliu.setVisibility(View.VISIBLE);
                    rl_back.setVisibility(View.VISIBLE);
                    view_3.setBackgroundColor(Color.parseColor("#f73f5f"));
                    tv_caiwu_title.setContentNotChange("财务审核失败，详情请");
                    tv_3.setTextColor(Color.parseColor("#f73f5f"));
                    tv_3.setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_checked)), null);
                    break;
                case 3:
                    view_3.setBackgroundColor(Color.parseColor("#f73f5f"));
                    tv_3.setText("财务通过");
                    tv_2.setText("审核通过");
                    tv_caiwu_tip.setVisibility(View.VISIBLE);
                    tv_caiwu_title.setContentNotChange("财务审核成功，详情请");
                    tv_3.setTextColor(Color.parseColor("#f73f5f"));
                    tv_3.setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_checked)), null);
                    view_3.setVisibility(View.VISIBLE);
                    rl_wuliu.setVisibility(View.VISIBLE);
                    rl_back.setVisibility(View.VISIBLE);
                    break;

            }
        }else {
            switch (bean.data.back_order.status_a) {
                case 0:
                    tv_shenhe.setVisibility(View.VISIBLE);
                    tv_2.setText("正在审核");
                    tv_2.setTextColor(Color.parseColor("#666666"));
                    tv_2.setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_path_no)), null);
                    break;
                case 2:
                    tv_2.setText("审核失败");
                    tv_shenhe.setContentNotChange("退货申请审核失败，详情请");
                    rl_wuliu.setVisibility(View.VISIBLE);
                    rl_back.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    tv_2.setText("审核通过");
                    rl_back.setVisibility(View.VISIBLE);
                    tv_3.setText("财务审核");
                    tv_caiwu_tip.setVisibility(View.VISIBLE);
                    view_3.setVisibility(View.VISIBLE);
                    tv_3.setTextColor(Color.parseColor("#666666"));
                    tv_3.setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_path_no)), null);
                    break;
                case 9:
                    view_3.setVisibility(View.VISIBLE);
                    tv_3.setText("财务拒绝");
                    tv_2.setText("审核通过");
                    tv_3.setTextColor(Color.parseColor("#f73f5f"));
                    tv_3.setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_checked)), null);
                    rl_back.setVisibility(View.VISIBLE);
                    view_3.setBackgroundColor(Color.parseColor("#f73f5f"));
                    tv_caiwu_title.setContentNotChange("财务审核失败，详情请");
                    break;
                case 3:
                    view_3.setBackgroundColor(Color.parseColor("#f73f5f"));
                    tv_3.setText("财务通过");
                    tv_2.setText("审核通过");
                    tv_caiwu_tip.setVisibility(View.VISIBLE);
                    tv_3.setTextColor(Color.parseColor("#f73f5f"));
                    tv_3.setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_checked)), null);
                    tv_caiwu_title.setContentNotChange("财务审核成功，详情请");
                    view_3.setVisibility(View.VISIBLE);
                    rl_back.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }

    private void initInfo() {
        BackShopDescBean.Data.BackOrderBean data = bean.data.back_order;
        tv_total_price.setText("合计金额：￥" + bean.data.amount + "元");
        tv_submit_info.setText(new StringBuffer()
                .append("售后类型：").append(data.back_type == 1 ? "仅退款" : "退款/退货").append("\n")
                .append("退款类型：").append(data.refund_type).append("\n")
                .append("退款金额：").append(data.money).append("元").append("\n")
                .append("收款账号：").append(data.bank_no).append("\n")
                .append("退款说明：").append(data.back_reason)
                .toString());
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_back_shop_desc, null);
        ButterKnife.bind(this, view);
        return view;
    }

    private void creatShop() {
        int count = bean.data.back_goods.size();
        for (int i = 0; i < count; i++) {
            BackShopDescBean.Data.BackGoodsBean data = bean.data.back_goods.get(i);
            View view = View.inflate(getContext(), R.layout.item_only_back_money, null);
            if (i == count - 1) {
                view.findViewById(R.id.view_line).setVisibility(View.GONE);
            }
            ImageView iv_img = (ImageView) view.findViewById(R.id.iv_img);
            TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
            TextView tv_price = (TextView) view.findViewById(R.id.tv_price);
            TextView tv_count = (TextView) view.findViewById(R.id.tv_count);
            Glide.with(getContext()).load(data.goods_thumb).into(iv_img);
            tv_title.setText(data.goods_name);
            tv_price.setText("￥" + data.goods_price);
            tv_count.setText("X" + data.send_number);
            ll_shop.addView(view);
        }


    }


    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("退货详情");
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }


}
