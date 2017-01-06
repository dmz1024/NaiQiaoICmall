package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/5.
 */

public class YuCunHuoBean extends ListBaseBean<ArrayList<YuCunHuoBean.Data>> {
    public static class Data {
        public String order_id;
        public String ostatus;
        public String order_sn;
        public String surplus;
        public String integral;
        public String pay_status;
        public String shipping_status;
        public String pay_id;
        public String money_paid;
        public String order_time;
        public String order_status;
        public String shipping_fee;
        public String total_fee;
        public int status;
        public ArrayList<ShopBean> goods;
    }



}
