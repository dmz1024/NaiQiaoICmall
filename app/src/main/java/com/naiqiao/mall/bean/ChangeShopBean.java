package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class ChangeShopBean extends ListBaseBean<ArrayList<ChangeShopBean.Data>> {
    public Info info;

    public static class Data {
        public String format_goods_price;
        public String goods_id;
        public String goods_name;
        public int goods_number;
        public double goods_price;
        public String goods_sn;
        public String goods_thumb;
        public String id;
        public int count;
        public boolean isChoose;
    }

    public static class Info {
        public String rebate_stock;
        public double stockprice;
    }

}
