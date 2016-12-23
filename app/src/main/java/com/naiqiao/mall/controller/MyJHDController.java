package com.naiqiao.mall.controller;

import android.content.Context;

import com.naiqiao.mall.bean.MyJHDChangeBean;
import com.naiqiao.mall.bean.rxbus.MyJHDRxBus;
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

public class MyJHDController {
    public static MyJHDController getInstance() {
        return new MyJHDController();
    }

    public void changeNum(final MyJHDRxBus rxBus) {
        final Map<String, String> map = new HashMap<>();
        map.put("act", "change_cart");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("rec_id", rxBus.id);
        map.put("goods_num", rxBus.num + "");
        new ApiRequest<MyJHDChangeBean>() {
            @Override
            protected Map<String, String> getMap() {
                return map;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.CART;
            }

            @Override
            protected Context getContext() {
                return ContextUtil.getCtx();
            }

            @Override
            protected Class<MyJHDChangeBean> getClx() {
                return MyJHDChangeBean.class;
            }
        }.setOnRequestListeren(new OnSingleRequestListener<MyJHDChangeBean>() {
            @Override
            public void succes(boolean isWrite, MyJHDChangeBean bean) {
                rxBus.total = bean.data.subtotal;
                RxBus.get().post("myjhd", rxBus);
            }

            @Override
            public void error(boolean isWrite, MyJHDChangeBean bean, String msg) {
                rxBus.num = rxBus.num - (rxBus.isAdd ? 1 : -1);
                rxBus.isSuccess=false;
                RxBus.get().post("myjhd", rxBus);

            }

            @Override
            public void onFailed(Exception e) {
                super.onFailed(e);
                rxBus.num = rxBus.num - (rxBus.isAdd ? 1 : -1);
                rxBus.isSuccess=false;
                RxBus.get().post("myjhd", rxBus);
            }
        }).post();
    }

}
