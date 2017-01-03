package com.naiqiao.mall.controller;

import android.content.Context;
import android.text.TextUtils;

import com.naiqiao.mall.bean.MyJHDChangeBean;
import com.naiqiao.mall.bean.rxbus.MyJHDRxBus;
import com.naiqiao.mall.bean.rxbus.YuJingZhiRxBus;
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

public class YuJingZhiController {
    public static YuJingZhiController getInstance() {
        return new YuJingZhiController();
    }

    public void changeNum(final YuJingZhiRxBus rxBus) {
        final Map<String, String> map = new HashMap<>();
        map.put("act", "notice_less_set");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        if (!TextUtils.isEmpty(rxBus.id)) {
            map.put("id", rxBus.id);
        } else {
            rxBus.isAll = true;
        }
        map.put("warn", rxBus.num + "");
        new ApiRequest<SingleBaseBean>() {
            @Override
            protected Map<String, String> getMap() {
                return map;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.NEWSCENTER;
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
                RxBus.get().post("yjz", rxBus);
            }

            @Override
            public void error(boolean isWrite, SingleBaseBean bean, String msg) {
                rxBus.num = rxBus.oldNum;
                RxBus.get().post("yjz", rxBus);

            }

            @Override
            public void onFailed(Exception e) {
                super.onFailed(e);
                rxBus.num = rxBus.oldNum;
                RxBus.get().post("yjz", rxBus);
            }
        }).post();
    }
}
