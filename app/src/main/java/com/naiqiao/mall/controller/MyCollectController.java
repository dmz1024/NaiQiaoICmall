package com.naiqiao.mall.controller;

import android.content.Context;

import com.naiqiao.mall.bean.rxbus.CollectRxbus;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.HashMap;
import java.util.Map;

import api.ApiRequest;
import base.bean.SingleBaseBean;
import base.bean.TipLoadingBean;
import interfaces.OnSingleRequestListener;
import util.ContextUtil;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/12/23.
 */

public class MyCollectController {
    public static MyCollectController getInstance() {
        return new MyCollectController();
    }

    public void collect(String id, final CollectRxbus rxbus) {
        final Map<String, String> map = new HashMap<>();
        map.put("goods_id", id);
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("act", rxbus.act);
        new ApiRequest<SingleBaseBean>() {
            @Override
            protected Map<String, String> getMap() {
                return map;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.SHOUCANG;
            }

            @Override
            protected Context getContext() {
                return ContextUtil.getCtx();
            }

            @Override
            protected Class<SingleBaseBean> getClx() {
                return SingleBaseBean.class;
            }
        }.setOnRequestListeren(new OnSingleRequestListener<SingleBaseBean>() {
            @Override
            public void succes(boolean isWrite, SingleBaseBean bean) {
                RxBus.get().post("collect", rxbus);
            }

            @Override
            public void error(boolean isWrite, SingleBaseBean bean, String msg) {

            }
        }).post(new TipLoadingBean("提交中...", "提交成功", ""));
    }

}
