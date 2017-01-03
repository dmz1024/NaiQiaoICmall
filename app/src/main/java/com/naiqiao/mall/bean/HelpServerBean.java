package com.naiqiao.mall.bean;

import android.support.v4.app.Fragment;

/**
 * Created by dengmingzhi on 2017/1/3.
 */

public class HelpServerBean {
    public Fragment fragment;
    public int rid;
    public String content;

    public HelpServerBean(Fragment fragment, int rid, String content) {
        this.fragment = fragment;
        this.rid = rid;
        this.content = content;
    }
}
