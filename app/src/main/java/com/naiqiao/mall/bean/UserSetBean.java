package com.naiqiao.mall.bean;

import base.bean.BaseBean;

/**
 * Created by dengmingzhi on 2016/12/7.
 */

public class UserSetBean extends BaseBean<UserSetBean.Data> {
    public static class Data {
        public String addr;
        public String avatar;
        public String email;
        public String mobile_phone;
        public String user_name;
        public String user_rank;
        public int type;
        public String company;
        public String name;
        public String company_tel;
    }
}
