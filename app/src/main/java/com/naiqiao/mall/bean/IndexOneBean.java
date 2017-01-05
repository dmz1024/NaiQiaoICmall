package com.naiqiao.mall.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import base.bean.ListBaseBean;
import interfaces.ImageUrlBaseBean;

/**
 * Created by dengmingzhi on 2016/12/19.
 */

public class IndexOneBean extends ListBaseBean<ArrayList<IndexOneBean.Data>> {
    public ArrayList<HeaderBean> header;
    public static class HeaderBean {
        public int type;
        public ArrayList<Data1Bean> data1;
        public ArrayList<IndexOneNavigationBean> data2;
        public ArrayList<Data3Bean> data3;
        public ArrayList<GoodsBean> data4;
        public Data5Bean data5;

        public static class Data5Bean {
            public String pic;
            public ArrayList<GoodsBean> goods;
        }

        public static class Data1Bean extends ImageUrlBaseBean {
            public String src;
            public String url;
            public String text;
            public String sort;

            @Override
            public String getUrl() {
                return src;
            }
        }

        public static class Data3Bean {
            public String act_id;
            public String act_name;
            public String start_time;
            public String end_time;
            public String user_rank;
            public String min_amount;
            public String max_amount;
            public String act_type;
            public String act_type_ext;
            public String sort_order;
            public String thumb;
            public int time;
        }

    }

    public static class Data {
        public String name;
        public String othername;
        public String color;
        public String color1;
        public String pid;
        public String url;
        public String id;
        public ArrayList<GoodsBean> goods;
    }
}
