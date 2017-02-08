package com.naiqiao.mall.bean;

import base.bean.BaseBean;

/**
 * Created by dengmingzhi on 2017/2/8.
 */

public class GoPayDoneBean extends BaseBean<GoPayDoneBean.Data> {
    public static class Data{
        public String order_amount;
        public String order_id;
    }
}
