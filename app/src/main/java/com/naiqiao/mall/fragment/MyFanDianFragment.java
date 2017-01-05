package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.naiqiao.mall.adapter.MyFanDianAdapter;
import com.naiqiao.mall.bean.MyFanDianBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.fragment.base.JiaoYiJiFenFanDianBaseFragment;

import java.util.ArrayList;
import java.util.Map;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.WebViewFragment;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class MyFanDianFragment extends JiaoYiJiFenFanDianBaseFragment<MyFanDianBean> {

    @Override
    protected String url() {
        return ApiConstant.USER;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "account_detail");
        return super.map();
    }

    @Override
    protected Class<MyFanDianBean> getTClass() {
        return MyFanDianBean.class;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyFanDianAdapter(getContext(), (ArrayList<MyFanDianBean.Data>) totalList);
    }


    @Override
    protected void initTitleView() {
        super.initTitleView();
        titleBarView.setTitleContent("我的返点");
        titleBarView.setButtonTitle("返点规则");
    }

    private String url;

    @Override
    protected void writeData(boolean isWrite, MyFanDianBean bean) {
        super.writeData(isWrite, bean);
        titleBarView.setPrice("返点余额：" + bean.surplus_amount);
        url = bean.h5_url;
    }


    @Override
    public void rightBt() {
        if(!TextUtils.isEmpty(url)){
            RxBus.get().post("addFragment",new AddFragmentBean(WebViewFragment.getInstance(url)));
        }
    }
}
