package com.naiqiao.mall.fragment.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/29.
 */

public class ForgetFragment extends NotNetWorkBaseFragment {
    @BindViews({R.id.et_name, R.id.et_code})
    List<EditText> ets;
    @BindViews({R.id.bt_next, R.id.bt_code})
    List<Button> bts;
    private VerificationCodeController regCode;
    @Override
    protected void initData() {
        regCode = new VerificationCodeController(getContext(), bts.get(1), "forget") {
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
                    ets.get(0).setError("手机号为11位");
                }


                if (ets.get(0).getText().toString().length() == 11 && ets.get(1).getText().toString().length() == 6) {
                    bts.get(0).setEnabled(true);
                    bts.get(0).setAlpha(1f);
                } else {
                    bts.get(0).setEnabled(false);
                    bts.get(0).setAlpha(0.5f);
                }


            }
        });

        ets.get(1).addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ets.get(0).getText().toString().length() == 11 && ets.get(1).getText().toString().length() == 6) {
                    bts.get(0).setEnabled(true);
                    bts.get(0).setAlpha(1f);
                } else {
                    bts.get(0).setEnabled(false);
                    bts.get(0).setAlpha(0.5f);
                }

                if (ets.get(1).getText().toString().length() != 6) {
                    ets.get(1).setError("验证码为6位");
                }
            }
        });


    }

    @Override
    protected int getRId() {
        return R.layout.fragment_forget;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBarView = (DefaultTitleBarView) getTitleBar();
        titleBarView.setTitleContent("修改密码");
    }

    @OnClick(R.id.bt_next)
    void next() {
        RxBus.get().post("addFragment", new AddFragmentBean(new UpdatePasswordFragment()));
    }

    @OnClick(R.id.bt_code)
    void code() {
        new AccountController(getContext()).setOnRequestListeren(new OnSingleRequestListener<SingleBaseBean>() {
            @Override
            public void succes(boolean isWrite, SingleBaseBean bean) {
                regCode.write();
            }

            @Override
            public void error(boolean isWrite, SingleBaseBean bean, String msg) {

            }
        }).code(ets.get(0).getText().toString(), "forget");
    }
}
