package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.ListBaseBean;

/**
 * Created by dengmingzhi on 2016/11/30.
 */

public class XiaoLiangPHBean extends ListBaseBean<ArrayList<XiaoLiangPHBean.Data>> {
    public static class Data {
        public int length;
    }


    @Override
    public ArrayList<Data> getData() {
        for (int i = 0; i < data.size(); i++) {

            data.get(i).length = 100 - (i * 10)<=0?0:100 - (i * 10);
        }
        return data;
    }
}
