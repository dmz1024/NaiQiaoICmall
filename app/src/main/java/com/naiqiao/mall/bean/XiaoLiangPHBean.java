package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/30.
 */

public class XiaoLiangPHBean extends ListBaseBean<ArrayList<XiaoLiangPHBean.Data>> {
    public static class Data {
        public String name;
        public int a_sale;
        public int max_sale;
    }


}
