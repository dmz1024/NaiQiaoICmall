package com.naiqiao.mall.bean;

import base.bean.ListBaseBean;
import interfaces.OnChooseAreaIntenface;

/**
 * Created by dengmingzhi on 2017/2/13.
 */

public class ChooseAreaBean extends ListBaseBean<ChooseAreaBean.Data> {
    public static class Data implements OnChooseAreaIntenface {
        public String name;
        public String id;

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getId() {
            return id;
        }
    }
}
