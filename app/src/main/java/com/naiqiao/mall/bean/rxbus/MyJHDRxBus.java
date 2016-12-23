package com.naiqiao.mall.bean.rxbus;

/**
 * Created by dengmingzhi on 2016/12/23.
 */

public class MyJHDRxBus {
    public boolean isAdd;
    public int position;
    public int num;
    public String id;
    public String total;
    public boolean isSuccess=true;
    public MyJHDRxBus(boolean isAdd, int position, int num, String id) {
        this.isAdd = isAdd;
        this.position = position;
        this.num = num;
        this.id = id;
    }
}
