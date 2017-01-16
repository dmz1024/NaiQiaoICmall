package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.ChangeShopDescBean;
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
    private String id;

    public static ChangeShopDescContentFragment getInstance(int type, String id) {
        ChangeShopDescContentFragment descContentFragment = new ChangeShopDescContentFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        bundle.putString("id", id);
        descContentFragment.setArguments(bundle);
        return descContentFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt("type");
            id = bundle.getString("id");
        }
    }

    @Override
    protected void initData() {
        ChangeShopDescFragment fragment = ChangeShopDescFragment.getInstance(id);
        fragment.setOnDataReturnListener(new ChangeShopDescFragment.OnDataReturnListener() {
            @Override
            public void data(ChangeShopDescBean.InfoBean info) {

                switch (type) {
                    case 0:
                        tv_content.setText("温馨提示:换货单正在进行审核,详情咨询客服" + info.service_phone);
                        break;
                    case 1:
                        tv_content.setText("温馨提示:换货单正在进行差价确认,详情咨询客服" + info.service_phone);
                        break;
                    case 2:
                        tv_content.setText("温馨提示:换货成功,详情咨询客服" + info.service_phone);
                        break;
                    case 3:
                        tv_content.setText("请在" + info.pay_time + "前完成差价" + info.formated_order_amount + "的支付");
                        break;
                    case 4:
                        tv_content.setText("温馨提示:换货单审核失败,详情咨询客服" + info.service_phone);
                        break;
                }
            }
        });
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, fragment).commit();
    }


    @Override
    protected void initView() {

        switch (type) {
            case 0:
                view_pro.setTitle("待审核");
                break;
            case 1:
                view_pro.setTitle("审核成功,已支付差价,待确认差价");
                break;
            case 2:
                view_pro.setTitle("审核成功,已支付差价,已确认差价,换货成功");
                break;
            case 3:
                bt_pay.setVisibility(View.VISIBLE);
                view_pro.setTitle("审核成功,支付差价");
                break;
            case 4:
                view_pro.setTitle("审核失败");
                break;
        }
        if (type != 0) {
            view_pro.setCurrentPosition(type);
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
