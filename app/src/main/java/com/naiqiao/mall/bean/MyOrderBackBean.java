package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/13.
 */

public class MyOrderBackBean extends ListBaseBean<ArrayList<MyOrderBackBean.Data>> {
    public static class Data {
        public String back_id;
        public String status;
        public String finance_time;
        public String update_price;
        public String order_id;
        public String pay_status;
        public String amount;
        public String pic1;
        public String back_reason;
        public String back_type;
        public String refund_type;
        public String money;
        public String money_paid;
        public String user_id;
        public String order_sn;
        public String add_time;
        public String pic3;
        public String pic2;
        public String type;
        public ArrayList<ShopBean> goods;
    }

}
