package com.naiqiao.mall.fragment.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.JiaoYi_JiFen_FanDianAdapter;
import com.naiqiao.mall.bean.JiaoYi_JiFen_FanDianBean;
import com.naiqiao.mall.view.JiaoYi_JiFen_FanDianTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.bean.TipLoadingBean;
import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public abstract class JiaoYiJiFenFanDianBaseFragment extends ListNetWorkBaseFragment<JiaoYi_JiFen_FanDianBean> {
    protected JiaoYi_JiFen_FanDianTitleBarView titleBarView;

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new JiaoYi_JiFen_FanDianAdapter(getContext(), (ArrayList<JiaoYi_JiFen_FanDianBean.Data>) totalList);
    }


    @Override
    protected Class<JiaoYi_JiFen_FanDianBean> getTClass() {
        return JiaoYi_JiFen_FanDianBean.class;
    }


    @Override
    protected View getTitleBarView() {
        return titleBarView = new JiaoYi_JiFen_FanDianTitleBarView(getContext());
    }

    @Override
    protected float top() {
        return 80;
    }
}
