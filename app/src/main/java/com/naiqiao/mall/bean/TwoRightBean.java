package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/24.
 */

public class TwoRightBean extends ListBaseBean<ArrayList<TwoRightBean.Data>> {

    public static class Data {
        public int type;
        public Data1 data1;
        public Data2 data2;
        public Data3 data3;

        public static class Data1 {

        }

        public static class Data2 {
            public ArrayList<Data2Data> data2;

            public static class Data2Data {

            }
        }

        public static class Data3 {
            public ArrayList<Data3Data> data3;
            public static class Data3Data {

            }
        }
    }

}
