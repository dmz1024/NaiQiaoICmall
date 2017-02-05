package com.naiqiao.mall.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import base.bean.BaseBean;

/**
 * Created by dengmingzhi on 2017/2/4.
 */

public class GoPayBean extends BaseBean<GoPayBean.Data> {

    public static class Data {
        public Data1Bean data1;
        public Data3Bean data3;
        public ArrayList<ShopBean> data2;

        public static class Data1Bean {
            public String address_id;
            public String consignee;
            public String mobile;
            public String country;
            public String province;
            public String city;
            public String district;
            public String address;
            public String zipcode;
            public String address_short_name;
        }

        public static class Data3Bean {

            public double goods_price;
            public double market_price;
            public double shipping_fee;
            public String shipping_fee_formated;
            public double amount;
            public int will_get_integral;
            public String amount_formated;
            public String formated_goods_price;
            public String formated_market_price;
            public int weight;
            public int user_money;
            public String rank_points;
        }

    }
}
