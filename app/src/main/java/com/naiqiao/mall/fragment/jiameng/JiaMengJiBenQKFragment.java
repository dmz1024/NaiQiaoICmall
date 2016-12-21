package com.naiqiao.mall.fragment.jiameng;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.naiqiao.mall.R;

import java.util.List;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class JiaMengJiBenQKFragment extends NotNetWorkBaseFragment {
    @BindViews({R.id.et_name, R.id.et_address_desc, R.id.et_tel, R.id.et_wechat, R.id.et_qq, R.id.et_email})
    List<EditText> ets;
    @BindView(R.id.tv_address)
    TextView tv_address;

    @BindView(R.id.bt_next)
    Button bt_next;

    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_jiameng_jibenqk;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("基本情况");
    }


    @OnClick(R.id.bt_next)
    void next() {
        RxBus.get().post("addFragment",new AddFragmentBean(new ShenFenZMFragment()));
    }
}
