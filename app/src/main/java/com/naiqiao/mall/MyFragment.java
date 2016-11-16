package com.naiqiao.mall;

import android.view.View;
import android.widget.Button;

import base.BaseFragment;
import butterknife.BindView;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class MyFragment extends BaseFragment {
    private Button bt_send;

    @Override
    protected void initData() {
        bt_send.setText("刷新成功");
        setStopRefresh();
    }

    @Override
    protected void initView(View view) {
        bt_send= (Button) view.findViewById(R.id.bt_send);
    }

    @Override
    protected View getShowView() {
        return View.inflate(getContext(), R.layout.activity_main, null);
    }
}
