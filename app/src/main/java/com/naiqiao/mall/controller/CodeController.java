package com.naiqiao.mall.controller;

import android.content.Context;

import com.naiqiao.mall.constant.ApiConstant;

import java.util.HashMap;
import java.util.Map;

import api.ApiRequest;
import base.bean.BaseBean;
import base.bean.SingleBaseBean;
import base.bean.TipLoadingBean;
import interfaces.OnRequestListener;

/**
 * Created by dengmingzhi on 2017/2/8.
 */

public class CodeController {
    private Context context;

    public static CodeController getInstance() {
        return new CodeController();
    }

    public CodeController setContext(Context ctx) {
        this.context = ctx;
        return this;
    }

    public void getCode(final String tel, final String type){
        new ApiRequest<SingleBaseBean>() {
            @Override
            protected Map<String, String> getMap() {
                Map<String, String> map = new HashMap<>();
                map.put("act", "get_sms");
                map.put("mobile_phone", tel);
                map.put("type", type);
                return map;
            }

            @Override
            protected Context getContext() {
                return context;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.USER;
            }

            @Override
            protected Class<SingleBaseBean> getClx() {
                return SingleBaseBean.class;
            }
        }.setOnRequestListeren(onRequestListeren).get(new TipLoadingBean("正在获取验证码...", "验证码已发送", ""));
    }

    private OnRequestListener onRequestListeren;

    public CodeController setOnRequestListeren(OnRequestListener<SingleBaseBean> onRequestListeren) {
        this.onRequestListeren = onRequestListeren;
        return this;
    }
}
