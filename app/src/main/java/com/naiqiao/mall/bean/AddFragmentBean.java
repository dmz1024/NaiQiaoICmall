package com.naiqiao.mall.bean;

import android.support.v4.app.Fragment;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class AddFragmentBean {
    private static int backTag = 0;
    private String backName = "backName" + (backTag = backTag + 1);
    private Fragment fragment;
    private int inAnimation;
    private int outAnimation;

    public AddFragmentBean() {
    }

    public AddFragmentBean(String backName, Fragment fragment, int inAnimation, int outAnimation) {
        this.backName = backName;
        this.fragment = fragment;
        this.inAnimation = inAnimation;
        this.outAnimation = outAnimation;
    }

    public AddFragmentBean(Fragment fragment, int inAnimation, int outAnimation) {
        this.fragment = fragment;
        this.inAnimation = inAnimation;
        this.outAnimation = outAnimation;
    }

    public AddFragmentBean(Fragment fragment) {
        this.fragment = fragment;
    }

    public static int getBackTag() {
        return backTag;
    }

    public static void setBackTag(int backTag) {
        AddFragmentBean.backTag = backTag;
    }

    public String getBackName() {
        return backName;
    }

    public void setBackName(String backName) {
        this.backName = backName;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public int getInAnimation() {
        return inAnimation==0? com.mall.naiqiao.mylibrary.R.anim.in_from_right:inAnimation;
    }

    public void setInAnimation(int inAnimation) {
        this.inAnimation = inAnimation;
    }

    public int getOutAnimation() {
        return outAnimation==0? com.mall.naiqiao.mylibrary.R.anim.out_from_left:outAnimation;
    }

    public void setOutAnimation(int outAnimation) {
        this.outAnimation = outAnimation;
    }
}
