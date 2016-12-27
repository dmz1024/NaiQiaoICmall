package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class JiaoYi_JiFen_FanDianBean extends ListBaseBean<ArrayList<JiaoYi_JiFen_FanDianBean.Data>> {
    public static class Data {
        public String change_time;
        public String change_desc;
        public String log_id;
        public String user_money;
    }
}
