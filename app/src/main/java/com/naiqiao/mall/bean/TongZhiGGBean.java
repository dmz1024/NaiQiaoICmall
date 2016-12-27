package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/2.
 */

public class TongZhiGGBean extends ListBaseBean<ArrayList<TongZhiGGBean.Data>> {

    public static class Data {
        public String id;
        public String title;
        public String short_title;
        public String add_time;
        public String content;
    }
}
