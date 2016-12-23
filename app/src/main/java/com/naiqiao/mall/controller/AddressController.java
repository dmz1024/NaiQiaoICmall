package com.naiqiao.mall.controller;

import android.content.Context;
import android.text.TextUtils;

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

public class AddressController {
    public static AddressController getInstance() {
        return new AddressController();
    }

    public void addOrUpdate(final Map<String, String> map) {
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("act", "creataddress");
        new ApiRequest<SingleBaseBean>() {
            @Override
            protected Map<String, String> getMap() {
                return map;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.AREA;
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
                RxBus.get().post("address", TextUtils.isEmpty(map.get("address_id")) ? "add" : "update");
                RxBus.get().post("back", "back");
            }

            @Override
            public void error(boolean isWrite, SingleBaseBean bean, String msg) {

            }
        }).post(new TipLoadingBean("提交中...", "提交成功", ""));
    }

    public void setDef(String id, final boolean isFromEdit) {
        final Map<String, String> map = new HashMap<>();
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("act", "default_address");
        map.put("address_id", id);
        new ApiRequest<SingleBaseBean>() {
            @Override
            protected Map<String, String> getMap() {
                return map;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.AREA;
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
                RxBus.get().post("address", "def");
                if (isFromEdit) {
                    RxBus.get().post("back", "back");
                }
            }

            @Override
            public void error(boolean isWrite, SingleBaseBean bean, String msg) {

            }
        }).post(new TipLoadingBean("提交中...", "提交成功", ""));
    }

    public void delete(String id) {
        final Map<String, String> map = new HashMap<>();
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("act", "drop_address");
        map.put("address_id", id);
        new ApiRequest<SingleBaseBean>() {
            @Override
            protected Map<String, String> getMap() {
                return map;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.AREA;
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
                RxBus.get().post("address", "delete");
            }

            @Override
            public void error(boolean isWrite, SingleBaseBean bean, String msg) {

            }
        }).post(new TipLoadingBean("删除中...", "删除成功", ""));
    }
}
