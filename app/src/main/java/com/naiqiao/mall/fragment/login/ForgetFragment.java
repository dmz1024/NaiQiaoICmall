package com.naiqiao.mall.fragment.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;

import java.util.ArrayList;
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

public class ForgetFragment extends NotNetWorkBaseFragment {
    @BindViews({R.id.et_name, R.id.et_code})
    List<EditText> ets;
    @BindView(R.id.bt_next)
    Button bt_next;

    @Override
    protected void initData() {

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
}
