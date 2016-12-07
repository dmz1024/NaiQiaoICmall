package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class YiFaHuoBean extends ListBaseBean<ArrayList<YiFaHuoBean.Data>> {
    public static class Data {
        public boolean isChoose;
        public ArrayList<ShopBean> shops=new ArrayList<>();
    }

    @Override
    public ArrayList<YiFaHuoBean.Data> getData() {
        for (int i = 0; i < data.size(); i++) {
            data.get(i).shops.add(new ShopBean());
            data.get(i).shops.add(new ShopBean());
        }
        return data;
    }
}
