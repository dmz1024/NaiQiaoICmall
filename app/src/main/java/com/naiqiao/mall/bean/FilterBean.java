package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.BaseBean;
import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/20.
 */

public class FilterBean extends BaseBean<ArrayList<FilterBean.Data>> {
    public static class Data {
        public String brand_id;
        public String brand_name;
    }

}
