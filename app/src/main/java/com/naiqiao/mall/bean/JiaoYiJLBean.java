package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2017/1/5.
 */

public class JiaoYiJLBean extends ListBaseBean<ArrayList<JiaoYiJLBean.Data>> {
    public String amount;
    public static class Data{
        public String order_id;
        public String order_sn;
        public String pay_status;
        public String type;
        public String add_time;
        public String money_paid;
        public String surplus;
        public String user_id;
        public String money;
    }
}
