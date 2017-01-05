package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2017/1/5.
 */

public class MyFanDianBean extends ListBaseBean<ArrayList<MyFanDianBean.Data>> {
    public String surplus_amount;
    public String h5_url;
    public static class Data{
        public String change_desc;
        public String change_time;
        public String change_type;
        public String frozen_money;
        public String log_id;
        public String pay_points;
        public String rank_points;
        public String short_change_desc;
        public String type;
        public String user_money;
    }
}
