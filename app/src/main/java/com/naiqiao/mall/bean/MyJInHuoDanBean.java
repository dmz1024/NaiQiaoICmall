package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/5.
 */

public class MyJinHuoDanBean extends ListBaseBean<ArrayList<MyJinHuoDanBean.Data>> {
    public static class Data {
        public boolean isChoose;
        public String rec_id;
        public String goods_thumb;
        public String goods_name;
        public int goods_number;
        public String goods_attr;
        public String market_price;
        public String goods_price;
        public double n_goods_price;
        public int stock;
        public String subtotal;
        public String goods_id;
        public String give_integral;
        public boolean isChange = true;

    }


}
