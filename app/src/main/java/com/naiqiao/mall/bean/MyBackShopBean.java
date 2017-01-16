package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class MyBackShopBean extends ListBaseBean<ArrayList<MyBackShopBean.Data>> {
    public static class Data {
        public String back_id;
        public String status;
        public String order_id;
        public String shipping_fee;
        public String order_status;
        public String pay_status;
        public String integral;
        public String amount;
        public String order_time;
        public String total_fee;
        public String money_paid;
        public String shipping_status;
        public String order_sn;
        public String ostatus;
        public String pay_id;
        public String surplus;
        public String handler;
        public int type;
    }


}
