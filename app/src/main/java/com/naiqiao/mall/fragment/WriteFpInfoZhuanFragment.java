package com.naiqiao.mall.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.fragment.base.WriteFpInfoBaseFragment;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import util.MyToast;

/**
 * Created by dengmingzhi on 2017/2/6.
 */

public class WriteFpInfoZhuanFragment extends WriteFpInfoBaseFragment {
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.et_price)
    EditText et_price;
    @BindView(R.id.et_taitou)
    EditText et_taitou;
    @BindView(R.id.et_sn)
    EditText et_sn;
    @BindView(R.id.et_address)
    EditText et_address;
    @BindView(R.id.et_tel)
    EditText et_tel;
    @BindView(R.id.et_bank)
    EditText et_bank;

    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_write_fp_info_zhuan;
    }


    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected String getBackColor() {
        return "#00000000";
    }

    @OnClick(R.id.tv_content)
    void content() {
        getContent();
    }

    @Override
    protected EditText getEditView() {
        return et_price;
    }

    @Override
    protected void setShowContent(String string) {
        super.setShowContent(string);
        tv_content.setText(string);
    }

    @Override
    public String getInfo() {
        String price = et_price.getText().toString();
        if (TextUtils.isEmpty(price) || Integer.parseInt(price) <= 0) {
            et_price.setError("请输入正确的开票金额");
            return null;
        }
        String taitou = et_taitou.getText().toString();
        if (TextUtils.isEmpty(taitou)) {
            et_price.setError("请输入发票抬头");
            return null;
        }
        String sn = et_sn.getText().toString();
        if (TextUtils.isEmpty(sn)) {
            et_sn.setError("请输入纳税人识别号");
            return null;
        }
        String address = et_address.getText().toString();
        if (TextUtils.isEmpty(sn)) {
            et_address.setError("请输入注册地址");
            return null;
        }
        String tel = et_tel.getText().toString();
        if (TextUtils.isEmpty(sn)) {
            et_tel.setError("请输入注册电话");
            return null;
        }
        String bank = et_bank.getText().toString();
        if (TextUtils.isEmpty(sn)) {
            et_bank.setError("请输入开户银行");
            return null;
        }

        if (TextUtils.isEmpty(content)) {
            MyToast.showToast("请选择开具内容");
            tv_content.setError("请选择开具内容");
            return null;
        }
        StringBuffer sb = new StringBuffer("0").append(",")
                .append(content).append(",")
                .append("开票金额：").append(price).append("\n")
                .append("开票抬头：").append(taitou).append("\n")
                .append("纳税人识别号：").append(sn).append("\n")
                .append("注册地址：").append(address).append("\n")
                .append("注册电话：").append(tel).append("\n")
                .append("开户银行：").append(bank).append("\n");
        return sb.toString();
    }
}
