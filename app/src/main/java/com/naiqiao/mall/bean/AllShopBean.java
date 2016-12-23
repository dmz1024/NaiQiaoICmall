package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/14.
 * 全部商品
 */

public class AllShopBean extends ListBaseBean<ArrayList<AllShopBean.Data>> {
    public static class Data{
        public String id;
        public String goods_id;
        public String goods_name;
        public String goods_price;
        public String goods_thumb;
        public String warn;
        public String sale;
        public String goods_number;
        public String goods_attr;
    }
}
