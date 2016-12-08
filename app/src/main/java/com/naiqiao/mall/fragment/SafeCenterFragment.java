package com.naiqiao.mall.fragment;

import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.SafeCenterBean;

import java.util.Map;

import base.fragment.SingleNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class SafeCenterFragment extends SingleNetWorkBaseFragment<SafeCenterBean> {
    @Override
    protected String url() {
        return "http://www.ediancha.com/app.php";
    }

    @Override
    protected Map<String, String> map() {
        map.put("c", "chahui");
        map.put("a", "index");
        return super.map();
    }

    @Override
    protected Class<SafeCenterBean> getTClass() {
        return SafeCenterBean.class;
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_safe_center, null);

        return view;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("安全中心");
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }
}
