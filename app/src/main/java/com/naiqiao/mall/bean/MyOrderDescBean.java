package com.naiqiao.mall.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import base.bean.BaseBean;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class MyOrderDescBean extends BaseBean<MyOrderDescBean.Data> {

    public static class Data {
        public Data1Bean data1;
        public ArrayList<ShopBean> data2;
        public Wuliu data3;

        public static class Data1Bean {
            public String order_id;
            public String order_sn;
            public String pay_time;
            public String order_status;
            public String shipping_status;
            public String pay_status;
            public String country;
            public String province;
            public String city;
            public String address;
            public String zipcode;
            public String mobile;
            public String formated_shipping_fee;
            public String formated_total_fee;
            public String group_address;
            public String consignee;
        }

        public static class Wuliu {
            public String shipping_name;
            public String no;
            public ArrayList<Info> info;

            public static class Info {
                public String qsname;
                public String time;
            }
        }

    }
}
