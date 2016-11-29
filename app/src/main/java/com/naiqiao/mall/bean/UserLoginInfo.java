package com.naiqiao.mall.bean;

import base.bean.BaseBean;

/**
 * Created by dengmingzhi on 2016/11/29.
 */

public class UserLoginInfo extends BaseBean<UserLoginInfo.Data> {
    public static class Data{
        public String user_id;
        public String user_name;
        public String nikename;
        public String sign_token;
    }
}
