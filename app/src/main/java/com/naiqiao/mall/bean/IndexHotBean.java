package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.BaseBean;
import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/28.
 */

public class IndexHotBean extends ListBaseBean<ArrayList<IndexHotBean.Data>> {
    public static class Data{
        public String name;
    }
}
