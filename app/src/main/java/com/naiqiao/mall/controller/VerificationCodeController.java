package com.naiqiao.mall.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import util.SharedPreferenUtil;

/**
 * Created by dengmingzhi on 2016/11/29.
 */

public class VerificationCodeController {
    private Context ctx;
    private String type;
    private View view;
    private Handler mHandler;
    private int anInt;

    public VerificationCodeController(Context ctx, View view, String type) {
        this.ctx = ctx;
        this.type = type;
        this.view = view;

    }

    public void write(int time) {
        new SharedPreferenUtil(ctx, "smsCode").setData(type, time);
        check();
    }

    public void write() {
        new SharedPreferenUtil(ctx, "smsCode").setData(type, 60);
        check();
    }

    public void check() {
        anInt = new SharedPreferenUtil(ctx, "smsCode").getInt(type);
        if (anInt <= 0) {
            if (getEnable()) {
                view.setAlpha(1f);
                view.setEnabled(true);
            } else {
                view.setAlpha(0.5f);
                view.setEnabled(false);
            }
        } else {
            view.setAlpha(0.5f);
            view.setEnabled(false);
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    new SharedPreferenUtil(ctx, "smsCode").setData(type, anInt);
                    if (anInt <= 0) {
                        printTime();
                        check();
                    } else {
                        anInt--;
                        printTime(anInt);

                        sendEmptyMessageDelayed(0, 1000);

                    }
                }
            };
            mHandler.sendEmptyMessageDelayed(0, 1000);
            printTime(anInt);
        }

    }

    protected void printTime(int time) {

    }

    protected void printTime() {

    }

    protected boolean getEnable() {
        return true;
    }

}
