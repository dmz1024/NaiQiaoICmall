package com.naiqiao.mall.fragment.login;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.UserLoginInfo;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.controller.AccountController;
import com.naiqiao.mall.interfaces.SingleTextWatcher;

import java.util.List;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import interfaces.OnSingleRequestListener;
import interfaces.OnTitleBarListener;
import util.RxBus;
import util.SharedPreferenUtil;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/29.
 */

public class LoginFragment extends NotNetWorkBaseFragment implements OnTitleBarListener {
    @BindViews({R.id.et_name, R.id.et_password})
    List<EditText> ets;
    @BindViews({R.id.tv_reg, R.id.tv_forget})
    List<TextView> tvs;
    @BindView(R.id.bt_login)
    Button bt_login;

    @Override
    protected void initData() {

    }

    //15031262907
    @Override
    protected void initView() {
        ets.get(0).addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ets.get(0).getText().toString().length() == 11 && ets.get(1).getText().toString().length() >= 6) {
                    bt_login.setEnabled(true);
                    bt_login.setAlpha(1f);
                } else {
                    bt_login.setEnabled(false);
                    bt_login.setAlpha(0.5f);
                }

                if (ets.get(0).getText().toString().length() != 11) {
                    ets.get(0).setError("手机号为11位");
                }
            }
        });

        ets.get(1).addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ets.get(0).getText().toString().length() == 11 && ets.get(1).getText().toString().length() >= 6) {
                    bt_login.setEnabled(true);
                    bt_login.setAlpha(1f);
                } else {
                    bt_login.setEnabled(false);
                    bt_login.setAlpha(0.5f);
                }


                if (ets.get(1).getText().toString().length() < 6) {
                    ets.get(1).setError("密码至少为6位");
                }
            }
        });


    }

    @Override
    protected int getRId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBarView = (DefaultTitleBarView) getTitleBar();
        titleBarView.setTitleContent("登录").setOnTitleBarListener(this);
    }

    @OnClick({R.id.tv_reg, R.id.tv_forget})
    void tvOnClick(View view) {
        if (view.getId() == R.id.tv_reg) {
            RxBus.get().post("addFragment", new AddFragmentBean(new RegFragment()));
        } else {
            RxBus.get().post("addFragment", new AddFragmentBean(new ForgetFragment()));
        }
    }

    @OnClick(R.id.bt_login)
    void login() {
        new AccountController(getContext()).setOnRequestListeren(new OnSingleRequestListener<UserLoginInfo>() {
            @Override
            public void succes(boolean isWrite, UserLoginInfo bean) {
                Log.d("登录", bean.data.nikename);
                Log.d("登录", bean.data.sign_token);
                Log.d("登录", bean.data.user_name);
                Log.d("登录", bean.data.user_id);
                UserInfo.uid = bean.data.user_id;
                UserInfo.token = bean.data.sign_token;
                new SharedPreferenUtil(getContext(), "userLogin").setData(new String[]{"uid", UserInfo.uid, "token", UserInfo.token});
                RxBus.get().post("userChange", "userChange");
                RxBus.get().post("back", "back");
            }

            @Override
            public void error(boolean isWrite, UserLoginInfo bean, String msg) {

            }
        }).login(ets.get(0).getText().toString(), ets.get(1).getText().toString());
    }

    @Override
    public void left() {
        RxBus.get().post("back", "back");
    }

    @Override
    public void right() {

    }

    @Override
    public void center() {

    }
}
