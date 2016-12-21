package com.naiqiao.mall.fragment.jiameng;

import com.naiqiao.mall.R;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/9.
 */

public class JiaMengGRSubmitFragment extends NotNetWorkBaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_jiameng_gr_submit;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("运营情况");
    }


    @OnClick(R.id.bt_submit)
    void submit(){
        RxBus.get().post("addFragment",new AddFragmentBean(new JiaMengSubmitSuccessFragment()));
    }
}
