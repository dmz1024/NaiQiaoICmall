package com.naiqiao.mall.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.ThingBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.fragment.base.WriteFpInfoBaseFragment;
import com.naiqiao.mall.interfaces.SingleTextWatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.ApiRequest;
import base.bean.TipLoadingBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import interfaces.OnSingleRequestListener;
import util.MyToast;
import view.pop.ChooseStringView;

import static com.naiqiao.mall.R.id.et_price;
import static com.naiqiao.mall.R.id.et_taitou;

/**
 * Created by dengmingzhi on 2017/2/6.
 */

public class WriteFpInfoPuFragment extends WriteFpInfoBaseFragment {
    @BindView(R.id.et_price)
    EditText et_price;
    @BindView(R.id.et_taitou)
    EditText et_taitou;
    @BindView(R.id.tv_content)
    TextView tv_content;

    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_write_fp_info_pu;
    }

    @Override
    protected EditText getEditView() {
        return et_price;
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
    protected void setShowContent(String string) {
        super.setShowContent(string);
        tv_content.setText(string);
    }

    @Override
    public String getInfo() {
        String price=et_price.getText().toString();
        if(TextUtils.isEmpty(price)||Integer.parseInt(price)<=0){
            et_price.setError("请输入正确的开票金额");
            return null;
        }
        String taitou=et_taitou.getText().toString();
        if(TextUtils.isEmpty(taitou)){
            et_price.setError("请输入发票抬头");
            return null;
        }
        if(TextUtils.isEmpty(content)){
            MyToast.showToast("请选择开具内容");
            tv_content.setError("请选择开具内容");
            return null;
        }
        StringBuffer sb=new StringBuffer("1").append(",")
                .append(content).append(",")
                .append("开票金额：").append(price).append("\n")
                .append("开票抬头：").append(taitou).append("\n");
        return sb.toString();
    }
}
