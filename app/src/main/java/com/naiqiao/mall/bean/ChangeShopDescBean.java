package com.naiqiao.mall.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/15.
 */

public class ChangeShopDescBean extends ListBaseBean<ArrayList<ChangeShopDescBean.Data>> {
    public InfoBean info;

    public static class InfoBean {
        public String service_phone;
        public String pay_time;
        public String formated_order_amount;
        public String order_amount;
        public String status;
    }

    public static class Data {
        public int type;
        public CountBean count;
        public ArrayList<ShopBean> goods;
        public boolean isMore;

        public static class CountBean {
            public String total_fee;
            public int goods_count;
        }

//        public static class GoodsBean {
//            public String rec_id;
//            public String back_id;
//            public String goods_id;
//            public String goods_name;
//            public String goods_sn;
//            public String is_real;
//            public String goods_attr;
//            public String status_back;
//            public String goods_thumb;
//            public String goods_price;
//            public String goods_number;
//        }
    }
}
