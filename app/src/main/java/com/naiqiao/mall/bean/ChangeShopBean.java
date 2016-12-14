package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class ChangeShopBean extends ListBaseBean<ArrayList<ChangeShopBean.Data>> {
    public static class Data{

    }

    @Override
    public ArrayList<Data> getData() {
        data.clear();
        return data;
    }
}
