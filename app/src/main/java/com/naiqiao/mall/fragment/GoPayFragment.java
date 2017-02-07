package com.naiqiao.mall.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.ShopAdapter;
import com.naiqiao.mall.bean.AffirmGoPayBean;
import com.naiqiao.mall.bean.GoPayBean;
import com.naiqiao.mall.bean.ShopBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.interfaces.SingleTextWatcher;
import com.naiqiao.mall.pay.PayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import base.bean.TipLoadingBean;
import base.bean.rxbus.AddFragmentBean;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import util.DrawableUtil;
import util.JLogUtils;
import util.MyToast;
import util.RxBus;
import view.Color2Text;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2017/2/4.
 */

public class GoPayFragment extends SingleNetWorkBaseFragment<GoPayBean> {
    private String ids;
    @BindViews({R.id.tv_zhi, R.id.tv_cun})
    List<TextView> payTvs;
    @BindView(R.id.ll_address)
    LinearLayout ll_address;
    @BindView(R.id.ll_show_fp)
    LinearLayout ll_show_fp;
    @BindView(R.id.ll_fp)
    LinearLayout ll_fp;
    @BindView(R.id.tv_address)
    TextView tv_address;
    @BindView(R.id.tv_fp_no)
    TextView tv_fp_no;
    @BindView(R.id.tv_fp_yes)
    TextView tv_fp_yes;
    @BindView(R.id.tv_fp_type)
    TextView tv_fp_type;
    @BindView(R.id.tv_fp_info)
    TextView tv_fp_info;
    @BindView(R.id.tv_fan_num)
    TextView tv_fan_num;
    @BindView(R.id.tv_pay)
    TextView tv_pay;
    @BindView(R.id.tv_shop_info)
    TextView tv_shop_info;
    @BindView(R.id.rv_shop)
    RecyclerView rv_shop;
    @BindView(R.id.et_bei)
    EditText et_bei;
    @BindView(R.id.et_fan)
    EditText et_fan;
    @BindView(R.id.tv_price)
    Color2Text tv_price;
    @BindView(R.id.sv_root)
    ScrollView sv_root;

    public static GoPayFragment getInstance(String ids) {
        GoPayFragment goPayFragment = new GoPayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("ids", ids);
        goPayFragment.setArguments(bundle);
        return goPayFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            ids = bundle.getString("ids");
        }
    }

    @Override
    protected String url() {
        return ApiConstant.FLOW;
    }

    @Override
    protected Class<GoPayBean> getTClass() {
        return GoPayBean.class;
    }

    private String address_id;

    @Override
    protected Map<String, String> map() {
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("act", "checkout");
        map.put("rec_ids", ids);
        if (!TextUtils.isEmpty(addressId)) {
            map.put("address_id", addressId);
        }
        return super.map();
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_gopay_content, null);
        ButterKnife.bind(this, view);
        return view;
    }

    private GoPayBean bean;

    @Override
    protected void writeData(boolean isWrite, GoPayBean bean) {
        super.writeData(isWrite, bean);
        this.bean = bean;
        initShop(bean.data.data2);
        initAddress(bean.data.data1);
        initInfo(bean.data.data3);
        initAddressRxBus();
    }

    private boolean isGetDataing;
    private boolean isChangeIng;
    private String fan;

    /**
     * 其他信息
     *
     * @param data
     */
    private void initInfo(final GoPayBean.Data.Data3Bean data) {
        tv_shop_info.setText("￥" + data.amount + "\n" + data.will_get_integral + "\n" + data.weight + "g\n￥" + data.shipping_fee);

        tv_fan_num.setText("您的可用返点为：" + data.user_money);
        et_fan.addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (isChangeIng) {
                    return;
                }
                isChangeIng = true;
                fan = s.toString();
                if (fan.length() > 1) {
                    if (TextUtils.equals(fan.substring(0, 1), "0")) {
                        fan = fan.substring(1);
                        et_fan.setText(fan);
                        et_fan.setSelection(fan.length());
                    }

                } else if (TextUtils.isEmpty(fan)) {
                    fan = "0";
                }

                if (Integer.parseInt(fan) > data.user_money || Integer.parseInt(fan) > data.amount) {
                    if (data.user_money > data.amount) {
                        int price = (int) data.amount;
                        fan = price > data.amount ? (price - 1) + "" : price + "";
                    } else {
                        fan = data.user_money + "";
                    }
                    et_fan.setText(fan);
                    et_fan.setSelection(fan.length());
                }

                price=(data.amount - Integer.parseInt(fan))+"";
                tv_price.setContentNotChange("合计：￥" + price+ "(包含运费)\n");
                isChangeIng = false;

            }

        });

        et_fan.setText(fan);
        showFp();

    }
    private String price;

    /**
     * 收件人信息
     *
     * @param data
     */
    private void initAddress(GoPayBean.Data.Data1Bean data) {
        if (!TextUtils.isEmpty(data.address_id)) {
            address_id = data.address_id;
            tv_address.setLineSpacing(1, 1.3f);
            tv_address.setText(data.consignee + "    " + data.mobile + "\n" + data.address_short_name);
        }
    }

    /**
     * 确认商品信息
     *
     * @param data
     */
    private void initShop(ArrayList<ShopBean> data) {
        count = 0;
        LinearLayoutManager manager = new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        ShopAdapter adapter = new ShopAdapter(getContext(), data);
        rv_shop.setLayoutManager(manager);
        rv_shop.setAdapter(adapter);

        for (ShopBean shop : data) {
            count += shop.goods_number;
        }

        tv_price.setTextNotChange("共" + count + "件商品");

    }

    int count = 0;

    @Override
    protected boolean isCanRefresh() {
        return false;
    }

    private boolean payType;

    @OnClick({R.id.tv_zhi, R.id.tv_cun})
    void payType(View view) {
        if (view.getId() == R.id.tv_zhi && payType) {
            payType = false;
        } else if (view.getId() == R.id.tv_cun && !payType) {
            payType = true;
        } else {
            return;
        }

        payTvs.get(0).setTextColor(Color.parseColor(payType ? "#999999" : "#f73f5f"));
        payTvs.get(1).setTextColor(Color.parseColor(payType ? "#f73f5f" : "#999999"));
        payTvs.get(0).setBackgroundResource(payType ? R.drawable.shape_fff_b2b2b2_ra : R.drawable.shape_fff_f73f5f_ra);
        payTvs.get(1).setBackgroundResource(payType ? R.drawable.shape_fff_f73f5f_ra : R.drawable.shape_fff_b2b2b2_ra);

        ll_address.setVisibility(payType ? View.GONE : View.VISIBLE);
        ll_fp.setVisibility(payType ? View.GONE : View.VISIBLE);

    }


    @OnClick(R.id.tv_address)
    void address() {
        RxBus.get().post("addFragment", new AddFragmentBean(AddressFragment.getInstance(true)));
    }

    private boolean isFp = false;

    @OnClick(R.id.tv_fp_yes)
    void fgYes() {
        if (TextUtils.isEmpty(tv_fp_type.getText())) {
            initFpRxBus();
            RxBus.get().post("addFragment", new AddFragmentBean(new WriteFpInfoFragment()));
        } else {
            if (isFp) {
                return;
            }
            isFp = true;
            showFp();
        }
    }


    @OnClick(R.id.tv_fp_no)
    void fgNo() {
        if (!isFp) {
            return;
        }
        isFp = false;
        showFp();
    }

    @OnClick(R.id.tv_fp_type)
    void fgType() {
        RxBus.get().post("addFragment", new AddFragmentBean(new WriteFpInfoFragment()));
    }

    @OnClick(R.id.tv_pay)
    void goPay() {
        AffirmGoPayBean goPayBean = new AffirmGoPayBean();
        if (!payType) {
            if (TextUtils.isEmpty(address_id)) {
                MyToast.showToast("请选择收货地址");
                return;
            }
            goPayBean.address_id = address_id;
            goPayBean.address = new StringBuffer(bean.data.data1.consignee).append("   ").append(bean.data.data1.address_short_name).append("    ").append(bean.data.data1.mobile).toString();
        }
        if (isFp) {
            goPayBean.inv_type = TextUtils.equals("1", fpContent[0]) ? "增值税普通发票" : "增值税专票";
            goPayBean.inv_content = fpContent[1];
            goPayBean.fp_content = new StringBuffer("【")
                    .append(goPayBean.inv_type).append("】")
                    .append("  ")
                    .append(goPayBean.inv_content).append("\n")
                    .append(fpContent[2])
                    .toString();


            fpContent[2] = fpContent[2].replace("\n", "：");
            String[] fgInfo = fpContent[2].split("：");
            StringBuffer fpSb = new StringBuffer();
            for (int i = 1; i < fgInfo.length; i = i + 2) {
                JLogUtils.D(i + "");
                fpSb.append(fgInfo[i]).append("|");
            }

            goPayBean.inv_payee = fpSb.toString().substring(0, fpSb.toString().length() - 1);
            JLogUtils.D(goPayBean.inv_payee);
        }
        goPayBean.count = count;
        goPayBean.price = price;
        JLogUtils.D(goPayBean.price);
        goPayBean.type = payType ? 1 : 0;
        goPayBean.shops = bean.data.data2;
        goPayBean.postscript = et_bei.getText().toString();
        String fan = et_fan.getText().toString();
        goPayBean.surplus = TextUtils.isEmpty(fan) ? "0" : fan;
        RxBus.get().post("addFragment", new AddFragmentBean(new AffirmGoPayFragment()));
    }


    private void showFp() {
        ll_show_fp.setVisibility(isFp ? View.VISIBLE : View.GONE);
        tv_fp_yes.setCompoundDrawables(DrawableUtil.setBounds(getResources().getDrawable(isFp ? R.mipmap.icon_checked : R.mipmap.icon_check)), null, null, null);
        tv_fp_no.setCompoundDrawables(DrawableUtil.setBounds(getResources().getDrawable(!isFp ? R.mipmap.icon_checked : R.mipmap.icon_check)), null, null, null);
        tv_fp_yes.setTextColor(Color.parseColor(isFp ? "#f73f5f" : "#999999"));
        tv_fp_no.setTextColor(Color.parseColor(!isFp ? "#f73f5f" : "#999999"));
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("去付款");
    }

    private Observable<String> chooseAddressRxBus;
    private String addressId;

    private void initAddressRxBus() {
        if (chooseAddressRxBus == null) {
            chooseAddressRxBus = RxBus.get().register("chooseAddress", String.class);
            chooseAddressRxBus.subscribe(new Action1<String>() {
                @Override
                public void call(String id) {
                    addressId = id;
                    isShowLoading = true;
                    getData();
                }
            });
        }

    }

    private Observable<String> fpRxBus;
    private String[] fpContent;

    private void initFpRxBus() {
        if (fpRxBus == null) {
            fpRxBus = RxBus.get().register("fpInfoRxBus", String.class);
            fpRxBus.subscribe(new Action1<String>() {
                @Override
                public void call(String content) {
                    fpContent = content.split(",");
                    if (TextUtils.equals("1", fpContent[0])) {
                        tv_fp_type.setText("【增值税普通发票】" + fpContent[1]);
                    } else {
                        tv_fp_type.setText("【增值税专票】" + fpContent[1]);
                    }
                    tv_fp_info.setText(fpContent[2]);
                    fgYes();
                }
            });
        }

    }

    private boolean isShowLoading;

    @Override
    protected TipLoadingBean getTipLoadingBean() {
        return isShowLoading ? new TipLoadingBean("获取邮费", "", "") : super.getTipLoadingBean();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("chooseAddress", chooseAddressRxBus);
        RxBus.get().unregister("fpInfoRxBus", fpRxBus);
    }
}
