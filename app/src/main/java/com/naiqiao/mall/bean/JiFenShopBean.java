package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class JiFenShopBean extends ListBaseBean<ArrayList<JiFenShopBean.Data>> {
    public static class Data{
        public String watermark_img;
        public String goods_id;
        public String goods_name;
        public String goods_number;
        public String market_price;
        public String name;
        public String exchange_integral;
        public String goods_thumb;
        public String attr;
        public String shop_price;
        public String attr_id;
    }
}
