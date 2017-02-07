package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;
import interfaces.OnStringInterface;

/**
 * Created by dengmingzhi on 2017/2/6.
 */

public class ThingBean extends ListBaseBean<ArrayList<ThingBean.Data>> {
    public static class Data implements OnStringInterface{
        public String title;
        @Override
        public String getString() {
            return title;
        }
    }
}
