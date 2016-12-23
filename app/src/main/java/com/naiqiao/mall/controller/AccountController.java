package com.naiqiao.mall.controller;

import android.content.Context;

import com.naiqiao.mall.bean.UserLoginInfo;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.HashMap;
import java.util.Map;

import api.ApiRequest;
import base.bean.SingleBaseBean;
import base.bean.TipLoadingBean;
import interfaces.OnRequestListener;

/**
 * Created by dengmingzhi on 2016/11/29.
 */

public class AccountController {
    private Context ctx;

    public AccountController(Context ctx) {
        this.ctx = ctx;
    }

    /**
     * 登录
     *
     * @param name
     * @param password
     */
    public void login(final String name, final String password) {
        new ApiRequest<UserLoginInfo>() {
            @Override
            protected Map<String, String> getMap() {
                Map<String, String> map = new HashMap<>();
                map.put("act", "user_login");
                map.put("username", name);
                map.put("password", password);
                return map;
            }

            @Override
            protected Context getContext() {
                return ctx;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.USER;
            }

            @Override
            protected Class<UserLoginInfo> getClx() {
                return UserLoginInfo.class;
            }
        }.setOnRequestListeren(onRequestListeren).get(new TipLoadingBean("正在登录...", "登录成功", ""));
    }


    /**
     * 修改用户信息
     *
     * @param map
     */
    public void updateUserInfo(final Map<String, String> map) {
        new ApiRequest<SingleBaseBean>() {
            @Override
            protected Map<String, String> getMap() {
                map.put("act", "index");
                map.put("user_id", UserInfo.uid);
                map.put("sign_token", UserInfo.token);
                return map;
            }

            @Override
            protected Context getContext() {
                return ctx;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.PROFILE;
            }

            @Override
            protected Class<SingleBaseBean> getClx() {
                return SingleBaseBean.class;
            }
        }.setOnRequestListeren(onRequestListeren).post(new TipLoadingBean("提交中...", "提交成功", ""));
    }


    /**
     * 注册
     *
     * @param name
     * @param password
     * @param code
     */
    public void reg(final String name, final String password, final String code) {
        new ApiRequest<SingleBaseBean>() {
            @Override
            protected Map<String, String> getMap() {
                Map<String, String> map = new HashMap<>();
                map.put("act", "user_register");
                map.put("mobile_phone", name);
                map.put("password", password);
                map.put("type", "reg");
                map.put("code", code);
                return map;
            }

            @Override
            protected Context getContext() {
                return ctx;
            }

            @Override
            protected String getUrl() {
                return ApiConstant.USER;
            }

            @Override
            protected Class<SingleBaseBean> getClx() {
                return SingleBaseBean.class;
            }
        }.setOnRequestListeren(onRequestListeren).get(new TipLoadingBean("正在注册...", "注册成功", ""));
    }

    private OnRequestListener onRequestListeren;

    public AccountController setOnRequestListeren(OnRequestListener onRequestListeren) {
        this.onRequestListeren = onRequestListeren;
        return this;
    }

    /**
     * 获取验证码
     */
    public void code(final String name, final String type) {
        new ApiRequest<SingleBaseBean>() {
            @Override
            protected Map<String, String> getMap() {
                Map<String, String> map = new HashMap<>();
                map.put("act", "get_sms");
                map.put("mobile_phone", name);
                map.put("type", type);
                return map;
            }

            @Override
            protected Context getContext() {
                return ctx;
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

}
