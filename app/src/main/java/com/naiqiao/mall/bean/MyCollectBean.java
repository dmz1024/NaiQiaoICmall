package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/30.
 */

public class MyCollectBean extends ListBaseBean<ArrayList<MyCollectBean.Data>> {
    public static class Data {
        public String goods_id;
        public String goods_name;
        public String shop_price;
        public String goods_thumb;
        public String goods_img;
        public String goods_attr;
    }
}
