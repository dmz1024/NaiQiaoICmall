package com.naiqiao.mall.fragment.jiameng;

import android.widget.Button;

import com.naiqiao.mall.R;

import base.activity.BaseActivity;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import util.ContextUtil;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/12.
 */

public class JiaMengSubmitSuccessFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.bt_skip)
    Button bt_skip;

    @Override
    protected void initData() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_jiameng_submit_success;
    }


    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("提交");
    }

    @OnClick(R.id.bt_skip)
    void skip() {
        int count = ((BaseActivity) ContextUtil.getAct()).getSupportFragmentManager().getBackStackEntryCount();
        for (int i = 0; i < count; i++) {
            bt_skip.postDelayed(new Runnable() {
                @Override
                public void run() {
                    RxBus.get().post("back", "back");
                }
            }, 100 * (i + 1));
        }
    }
}
