package com.naiqiao.mall.fragment.login;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.interfaces.SingleTextWatcher;

import java.util.List;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/29.
 */

public class UpdatePasswordFragment extends NotNetWorkBaseFragment {
    @BindViews({R.id.et_password, R.id.et_again_password})
    List<EditText> ets;
    @BindView(R.id.bt_update)
    Button bt_update;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ets.get(0).addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (ets.get(0).getText().toString().length() < 6) {
                    ets.get(0).setError("请输入至少6位密码");
                    bt_update.setAlpha(0.5f);
                    bt_update.setEnabled(false);
                } else {
                    if (TextUtils.equals(ets.get(0).getText().toString(), ets.get(1).getText().toString())) {
                        bt_update.setAlpha(1f);
                        bt_update.setEnabled(true);
                    } else {
                        bt_update.setAlpha(0.5f);
                        bt_update.setEnabled(false);
                    }
                }

            }
        });

        ets.get(1).addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.equals(ets.get(0).getText().toString(), ets.get(1).getText().toString())) {
                    ets.get(1).setError("两次密码不一致");
                    bt_update.setAlpha(0.5f);
                    bt_update.setEnabled(false);
                } else {
                    if (ets.get(0).getText().toString().length() >= 6) {
                        bt_update.setAlpha(1f);
                        bt_update.setEnabled(true);
                    } else {
                        bt_update.setAlpha(0.5f);
                        bt_update.setEnabled(false);
                    }
                }

            }
        });

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_update_password;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBarView = (DefaultTitleBarView) getTitleBar();
        titleBarView.setTitleContent("修改密码");
    }

    @OnClick(R.id.bt_update)
    void update() {

    }
}
