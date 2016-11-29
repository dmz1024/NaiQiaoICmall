package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.BaseBean;

/**
 * Created by dengmingzhi on 2016/11/28.
 */

public class IndexSearchHistory {
    public ArrayList<Data> data;

    public IndexSearchHistory(ArrayList<Data> data) {
        this.data = data;
    }

    public static class Data {
        public String content;

        public Data(String content) {
            this.content = content;
        }

        public Data() {
        }
    }

}
