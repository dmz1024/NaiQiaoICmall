package com.naiqiao.mall.controller;

import android.content.Context;

import com.naiqiao.mall.bean.UserLoginInfo;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.pay.PayUtil;

import java.util.HashMap;
import java.util.Map;

import api.ApiRequest;
import base.bean.SingleBaseBean;
import base.bean.TipLoadingBean;
import interfaces.OnRequestListener;
import interfaces.OnSingleRequestListener;

/**
 * Created by dengmingzhi on 2016/11/29.
 */

public class PayController {
    private Context ctx;

    public static PayController getInstance() {
        return new PayController();
    }

    public PayController setCtx(Context ctx) {
        this.ctx = ctx;
        return this;
    }

    public void wechat(final String id) {
        new ApiRequest<PayUtil.WechatInfo>() {
            @Override
            protected Map<String, String> getMap() {
                Map<String, String> map = new HashMap<>();
                map.put("order_id", id);
                return map;
            }

            @Override
            protected String getUrl() {

                return ApiConstant.WEIXINAPP;
            }

            @Override
            protected Context getContext() {
                return ctx;
            }

            @Override
            protected boolean getShowSucces() {
                return false;
            }

            @Override
            protected Class<PayUtil.WechatInfo> getClx() {
                return PayUtil.WechatInfo.class;
            }
        }.setOnRequestListeren(new OnSingleRequestListener<PayUtil.WechatInfo>() {

            @Override
            public void succes(boolean isWrite, PayUtil.WechatInfo bean) {
                PayUtil.getInstance().setContext(ctx).weChatPay(bean.data);
            }

            @Override
            public void error(boolean isWrite, PayUtil.WechatInfo bean, String msg) {

            }
        }).post(new TipLoadingBean("获取支付信息", "", ""));
    }

    public void ali(final String id) {
        new ApiRequest<PayUtil.AliPayInfo>() {
            @Override
            protected Map<String, String> getMap() {
                Map<String, String> map = new HashMap<>();
                map.put("order_id", id);
                return map;
            }

            @Override
            protected String getUrl() {

                return ApiConstant.ALIPAY;
            }

            @Override
            protected boolean getShowSucces() {
                return false;
            }

            @Override
            protected Context getContext() {
                return ctx;
            }

            @Override
            protected Class<PayUtil.AliPayInfo> getClx() {
                return PayUtil.AliPayInfo.class;
            }
        }.setOnRequestListeren(new OnSingleRequestListener<PayUtil.AliPayInfo>() {

            @Override
            public void succes(boolean isWrite, PayUtil.AliPayInfo bean) {
                PayUtil.getInstance().setContext(ctx).aliPay(bean.data);
            }

            @Override
            public void error(boolean isWrite, PayUtil.AliPayInfo bean, String msg) {

            }


        }).post(new TipLoadingBean("获取支付信息", "", ""));
    }
}
