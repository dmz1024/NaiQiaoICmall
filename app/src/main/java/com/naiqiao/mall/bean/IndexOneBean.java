package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/12/19.
 */

public class IndexOneBean extends ListBaseBean<ArrayList<IndexOneBean.Data>> {
    public static class Data {
        public int type;

    }

    @Override
    public ArrayList<Data> getData() {
        data.clear();
        for (int i = 0; i < 7; i++) {
            data.add(new Data());
            data.get(i).type = i;
        }
        return data;
    }
}
