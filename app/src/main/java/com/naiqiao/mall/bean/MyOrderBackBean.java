package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/13.
 */

public class MyOrderBackBean extends ListBaseBean<ArrayList<MyOrderBackBean.Data>> {
    public static class Data {
        public ArrayList<ShopBean> shops=new ArrayList<>();
    }

    @Override
    public ArrayList<Data> getData() {
        for (int i = 0; i <data.size() ; i++) {
            data.get(i).shops.add(new ShopBean());
            data.get(i).shops.add(new ShopBean());
        }
        return data;
    }
}
