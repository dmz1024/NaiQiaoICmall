package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;

import com.naiqiao.mall.adapter.TongZhiGGAdapter;
import com.naiqiao.mall.bean.TongZhiGGBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/2.
 */

public class TongzhiGGFragment extends ListNetWorkBaseFragment<TongZhiGGBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new TongZhiGGAdapter(getContext(), (ArrayList<TongZhiGGBean.Data>) totalList);
    }

    @Override
    protected String url() {
        return ApiConstant.NEWSCENTER;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "index");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    protected Class<TongZhiGGBean> getTClass() {
        return TongZhiGGBean.class;
    }

    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBarView = (DefaultTitleBarView) getTitleBar();
        titleBarView.setTitleContent("通知公告");
    }
}
