package com.naiqiao.mall.activity;

import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.fragment.index.IndexFragment;

import java.util.Map;

import base.activity.BaseActivity;
import base.bean.rxbus.AddFragmentBean;
import util.RxBus;
import util.SharedPreferenUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void initData() {
        initUserInfo();
        sendFragment();
    }

    private void initUserInfo() {
        Map<String, String> map = new SharedPreferenUtil(this, "userLogin").getData(new String[]{"uid", "token"});
        UserInfo.uid = map.get("uid");
        UserInfo.token = map.get("token");
    }

    private void sendFragment() {
        AddFragmentBean addFragmentBean = new AddFragmentBean(new IndexFragment());
        addFragmentBean.setAddBack(true);
        addFragmentBean.setHaveAnima(true);
        RxBus.get().post("addFragment", addFragmentBean);
    }

}
