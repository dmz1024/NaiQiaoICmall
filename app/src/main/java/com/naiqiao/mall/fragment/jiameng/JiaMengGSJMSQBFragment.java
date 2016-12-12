package com.naiqiao.mall.fragment.jiameng;

import android.text.Html;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/12.
 */

public class JiaMengGSJMSQBFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.tv_1)
    TextView tv_1;
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        tv_1.setText(Html.fromHtml("请您到电脑端下载：<font color='#f73f5f'><b>企业代理商加盟申请表</b></font>,并认真填写,我们将对您的所有资料保密。请认真详细填写,以备我公司对您的代理资格进行审核。我们参阅完以上资料后会尽快与您联系洽谈,谢谢!<br/><br/>"));
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_jiameng_gs_submit;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("加盟申请表");
    }

    @OnClick(R.id.bt_next)
    void next(){
        RxBus.get().post("addFragment",new AddFragmentBean(new JiaMengSubmitSuccessFragment()));
    }
}
