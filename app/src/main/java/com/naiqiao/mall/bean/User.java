package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/15.
 */

public class User extends ListBaseBean<ArrayList<User.Data>> {

    public static class Data {
        public Data2 data2;
        public int r;
    }

    public static class Data2 {
        public String name;
    }

}