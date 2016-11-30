package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/24.
 */

public class TwoLeftBean extends ListBaseBean<ArrayList<TwoLeftBean.Data>> {

    public static class Data {
        public String color;
        public String id;
        public String name;
        public String othername;
        public int type;
        public ArrayList<Cat> data;

        public static class Cat {
            public String name;
            public String id;
            public String othername;
        }
    }

    @Override
    public ArrayList<Data> getData() {
        ArrayList<Data> dataNew = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            data.get(i).type = 1;
            dataNew.add(data.get(i));
            for (int j = 0; j < data.get(i).data.size(); j++) {
                Data bean = new Data();
                bean.type = 2;
                bean.name = data.get(i).data.get(j).name;
                bean.id = data.get(i).data.get(j).id;
                bean.othername = data.get(i).data.get(j).othername;
                dataNew.add(bean);
            }
        }
        return dataNew;
    }
}
