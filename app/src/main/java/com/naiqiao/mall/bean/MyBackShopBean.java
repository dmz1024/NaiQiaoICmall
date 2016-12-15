package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class MyBackShopBean extends ListBaseBean<ArrayList<MyBackShopBean.Data>> {
    public static class Data {
        public int type;
    }

    @Override
    public ArrayList<Data> getData() {
        for (int i = 0; i < data.size(); i++) {
            data.get(i).type = i % 4;
        }
        return data;
    }
}
