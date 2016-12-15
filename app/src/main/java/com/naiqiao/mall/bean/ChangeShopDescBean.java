package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/15.
 */

public class ChangeShopDescBean extends ListBaseBean<ArrayList<ChangeShopDescBean.Data>> {
    public static class Data {
        public String title;
        public boolean isMore;
        public ArrayList<ShopBean> shops = new ArrayList<>();
    }


    @Override
    public ArrayList<Data> getData() {
        for (int i = 0; i < data.size(); i++) {
            data.get(i).title = i % 2 == 0 ? "虚拟仓商品" : "新进商品";
            data.get(i).shops.clear();
            for (int j = 0; j < (i % 2 == 0 ? 5 : 2); j++) {
                data.get(i).shops.add(new ShopBean());
            }
        }

        return data;
    }
}
