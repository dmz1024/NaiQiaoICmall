package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/24.
 */

public class TwoLeftBean extends ListBaseBean<ArrayList<TwoLeftBean.Data>> {

    public static class Data {
        public String name;
        public int type;
        public ArrayList<CityBean> city;

        public static class CityBean {
            public String name;
        }
    }

    @Override
    public ArrayList<Data> getData() {
        ArrayList<Data> dataNew = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            data.get(i).type = 1;

            dataNew.add(data.get(i));
            for (int j = 0; j < data.get(i).city.size(); j++) {
                Data bean = new Data();
                bean.type = 2;
                bean.name = data.get(i).city.get(j).name;
                dataNew.add(bean);
            }
        }
        return dataNew;
    }
}
