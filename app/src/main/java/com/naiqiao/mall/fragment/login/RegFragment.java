package com.naiqiao.mall.fragment.login;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.controller.AccountController;
import com.naiqiao.mall.controller.VerificationCodeController;
import com.naiqiao.mall.interfaces.SingleTextWatcher;

import java.util.ArrayList;
import java.util.List;

import base.bean.SingleBaseBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import interfaces.OnSingleRequestListener;
import util.RxBus;
import util.SharedPreferenUtil;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/29.
 */

public class RegFragment extends NotNetWorkBaseFragment {
    @BindViews({R.id.et_name, R.id.et_password, R.id.et_password_again, R.id.et_code})
    List<EditText> ets;
    @BindViews({R.id.tv_xieyi, R.id.tv_have})
    List<TextView> tvs;
    @BindViews({R.id.bt_reg, R.id.bt_code})
    List<Button> bts;
    @BindView(R.id.iv_choose)
    ImageView iv_choose;

    private boolean isAgree;

    @Override
    protected void initData() {
        regCode = new VerificationCodeController(getContext(), bts.get(1), "reg") {
            @Override
            protected void printTime() {
                bts.get(1).setText("获取验证码");
            }

            @Override
            protected void printTime(int time) {
                bts.get(1).setText("重新获取" + time + "S");
            }

            @Override
            protected boolean getEnable() {
                return ets.get(0).getText().toString().length() == 11;
            }
        };

        regCode.check();
    }

    @Override
    protected void initView() {
        ets.get(0).addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ets.get(0).getText().toString().length() == 11) {
                    bts.get(1).setEnabled(true);
                    bts.get(1).setAlpha(1f);
                } else {
                    bts.get(1).setEnabled(false);
                    bts.get(1).setAlpha(0.5f);
                }

                if (ets.get(0).getText().toString().length() != 11) {
                    ets.get(0).setError("手机号为11位");
                }

                yanzheng();
            }
        });

        ets.get(1).addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ets.get(1).getText().toString().length() < 6) {
                    ets.get(1).setError("密码不少于6位");
                }
                yanzheng();
            }
        });

        ets.get(2).addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.equals(ets.get(2).getText().toString(), ets.get(1).getText().toString())) {
                    ets.get(2).setError("两次密码不一致");
                }
                yanzheng();
            }
        });

        ets.get(3).addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ets.get(3).getText().toString().length() != 6) {
                    ets.get(3).setError("验证码为6位");
                }
                yanzheng();
            }
        });


    }

    private VerificationCodeController regCode;

    private void yanzheng() {

        if (isAgree && ets.get(0).getText().toString().length() == 11
                && (ets.get(1).getText().toString().length() >= 6
                && (TextUtils.equals(ets.get(1).getText().toString(), ets.get(2).getText().toString())) && ets.get(3).getText().toString().length() == 6)) {
            bts.get(0).setEnabled(true);
            bts.get(0).setAlpha(1f);
        } else {
            bts.get(0).setEnabled(false);
            bts.get(0).setAlpha(0.5f);
        }

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_reg;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBarView = (DefaultTitleBarView) getTitleBar();
        titleBarView.setTitleContent("注册");
    }

    @OnClick({R.id.tv_xieyi, R.id.tv_have})
    void tvOnClick(View view) {

    }

    @OnClick({R.id.bt_reg, R.id.bt_code})
    void btOnClick(View view) {
        if (view.getId() == R.id.bt_reg)
            reg();
        else
            code();

    }

    @OnClick(R.id.iv_choose)
    void choose() {
        iv_choose.setImageResource((isAgree = !isAgree) ? R.mipmap.icon_achecked : R.mipmap.icon_acheck);
        yanzheng();
    }

    /**
     * 获取验证码
     */
    private void code() {

        new AccountController(getContext()).setOnRequestListeren(new OnSingleRequestListener<SingleBaseBean>() {
            @Override
            public void succes(boolean isWrite, SingleBaseBean bean) {
                regCode.write();
            }

            @Override
            public void error(boolean isWrite, SingleBaseBean bean, String msg) {

            }
        }).code(ets.get(0).getText().toString(), "reg");
    }

    /**
     * 注册
     */
    private void reg() {

        new AccountController(getContext()).setOnRequestListeren(new OnSingleRequestListener<SingleBaseBean>() {
            @Override
            public void succes(boolean isWrite, SingleBaseBean bean) {
                regCode.write(0);
                RxBus.get().post("addFragment",new AddFragmentBean(new RegSuccessFragment()));
            }

            @Override
            public void error(boolean isWrite, SingleBaseBean bean, String msg) {


            }
        }).reg(ets.get(0).getText().toString(), ets.get(1).getText().toString(), ets.get(3).getText().toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        regCode = null;
    }
}
