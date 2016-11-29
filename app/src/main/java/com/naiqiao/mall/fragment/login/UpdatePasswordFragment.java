package com.naiqiao.mall.fragment.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;

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
