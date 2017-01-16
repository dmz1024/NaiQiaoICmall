package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.naiqiao.mall.adapter.XiaoLiangPHAdapter;
import com.naiqiao.mall.bean.XiaoLiangPHBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.bean.BaseBean;
import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/30.
 */

public class XiaoLiangPaiHangFragment extends ListNetWorkBaseFragment<XiaoLiangPHBean> {
    private int type;

    public static XiaoLiangPaiHangFragment getInstance(int type) {
        XiaoLiangPaiHangFragment fragment = new XiaoLiangPaiHangFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt("type");
        }
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new XiaoLiangPHAdapter(getContext(), (ArrayList<XiaoLiangPHBean.Data>) totalList);
    }


    @Override
    protected String url() {
        return ApiConstant.SALE;
    }

    @Override
    protected Map<String, String> map() {
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("act", "index");
        if (type == 2) {
            map.put("type", 2 + "");
        }
        return super.map();
    }

    @Override
    protected Class<XiaoLiangPHBean> getTClass() {
        return XiaoLiangPHBean.class;
    }

    @Override
    protected String getBackColor() {
        return "#ffffff";
    }

    @Override
    protected boolean getLoadMore() {
        return false;
    }


    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBarView = (DefaultTitleBarView) getTitleBar();
        titleBarView.setTitleContent(type!=2?"单品销量排行":"分类销量排行");
    }
}
