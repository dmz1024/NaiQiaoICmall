package com.naiqiao.mall.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import base.bean.BaseBean;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class BackShopDescBean extends BaseBean<BackShopDescBean.Data> {

    public static class Data {

        public BackOrderBean back_order;
        public KuaidiBean kuaidi;
        public double amount;
        public ArrayList<BackGoodsBean> back_goods;

        public static class BackOrderBean {
            public String refund_type;
            public String money;
            public int back_type;
            public String bank_no;
            public int status;
            public int status_a;
            public String pay_status;
            public String delivery_sn;
            public String back_reason;
            public String pic1;
            public String pic2;
            public String pic3;
        }

        public static class KuaidiBean {
            public String shipping_name;
            public String invoice_no;
        }

        public static class BackGoodsBean {
            public String rec_id;
            public String goods_name;
            public String goods_thumb;
            public String goods_sn;
            public String back_id;
            public String goods_id;
            public String send_number;
            public String goods_price;
        }
    }
}
