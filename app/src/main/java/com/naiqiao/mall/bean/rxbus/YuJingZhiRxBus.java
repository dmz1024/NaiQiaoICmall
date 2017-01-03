package com.naiqiao.mall.bean.rxbus;

/**
 * Created by dengmingzhi on 2016/12/23.
 */

public class YuJingZhiRxBus {
    public int position;
    public int num;
    public int oldNum;
    public String id;
    public boolean isAll;
    public boolean isSuccess=true;
    public YuJingZhiRxBus(int position, int num, String id,int oldNum) {
        this.position = position;
        this.num = num;
        this.id = id;
        this.oldNum = oldNum;
    }

    public YuJingZhiRxBus(int num,int oldNum) {
        this.num = num;
        this.oldNum = oldNum;
    }
}
