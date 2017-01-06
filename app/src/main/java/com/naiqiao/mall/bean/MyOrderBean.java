package com.naiqiao.mall.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/5.
 */

public class MyOrderBean extends ListBaseBean<ArrayList<MyOrderBean.Data>> {

    public static class Data {

        public String order_id;
        public int ostatus;
        public String order_sn;
        public String surplus;
        public String integral;
        public int pay_status;
        public int status;
        public int shipping_status;
        public String pay_id;
        public String money_paid;
        public String order_time;
        public String order_status;
        public String shipping_fee;
        public String total_fee;
        public String handler;
        public ArrayList<ShopBean> goods;

    }
}
