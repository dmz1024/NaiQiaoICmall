package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class YuJingZhiSetBean extends ListBaseBean<ArrayList<YuJingZhiSetBean.Data>> {
    public static class Data {
        public String id;
        public String goods_id;
        public String goods_sn;
        public String goods_name;
        public String goods_price;
        public String goods_thumb;
        public String attr;
        public int goods_number;
        public int warn;
        public String sale;
        public boolean isChange= true;
    }
}
