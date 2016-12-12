package com.naiqiao.mall.fragment.jiameng;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/12.
 */

public class JiaMengGsJBQKFragment extends NotNetWorkBaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_jiameng_gs_jiben_qk;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("公司基本情况");
    }

    @OnClick(R.id.bt_next)
    void next(){
        RxBus.get().post("addFragment",new AddFragmentBean(new JiaMengGsLinkManFragment()));
    }
}
