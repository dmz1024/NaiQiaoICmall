package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class HotProblemBean extends ListBaseBean<ArrayList<HotProblemBean.Data>> {
    public static class Data {
        public String title;
        public String article_id;
    }
}
