package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2017/1/5.
 */

public class MyJIFenBean extends ListBaseBean<ArrayList<MyJIFenBean.Data>> {
    public String rank_points;
    public static class Data{
        public String add_time;
        public String admin_note;
        public String amount;
        public String change_desc;
        public String change_time;
        public String change_type;
        public String frozen_money;
        public String log_id;
        public String pay_points;
        public String rank_points;
        public String user_money;
    }
}
