package com.naiqiao.mall.activity;

//import com.squareup.leakcanary.LeakCanary;

import base.activity.MyApplication;

/**
 * Created by dengmingzhi on 2016/12/27.
 */

public class MyApp extends MyApplication {
    @Override
    public void onCreate() {
        super.onCreate();
//        LeakCanary.install(this);//检测内存泄漏

    }
}
