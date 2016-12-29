package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/15.
 */

public class UserCenter extends ListBaseBean<UserCenter.Data> {

    public static class Data {
       public String zaitu;
       public String news;
       public String notice;
       public String stock_goods;
       public String booking_goods;
       public String integral;
       public String avatar;
       public String user_rank;
       public String user_name;
    }

}
