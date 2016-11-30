package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/30.
 */

public class SendMonadBean extends ListBaseBean<ArrayList<SendMonadBean.Data>> {
    public static class Data {
        public boolean isChoose = true;
        public int count;
    }
}
