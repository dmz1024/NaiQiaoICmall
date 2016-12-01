package com.naiqiao.mall.bean;
import java.util.ArrayList;
import java.util.List;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/24.
 */

public class TwoRightBean extends ListBaseBean<ArrayList<TwoRightBean.Data>> {

    public static class Data {
        public int type;
        public String title;
        public String othername;
        public ArrayList<Data1Bean> data1;
        public ArrayList<Data2Bean> data2;
        public ArrayList<Data3Bean> data3;
        public boolean isCreat;

        public static class Data1Bean {
            public String ad_image;
        }

        public static class Data2Bean {
            public String brand_id;
            public String brand_name;
            public String brand_logo;

        }

        public static class Data3Bean {
            public String id;
            public String name;
            public String othername;
            public String cat_image;
        }
    }
}
