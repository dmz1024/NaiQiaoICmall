package shop.haoshi.client.bean;

import android.support.v4.app.Fragment;

/**
 * Created by dengmingzhi on 2017/1/17.
 */

public class GeneralBean {
    public String title;
    public int rid;
    public Fragment fragment;
    public int num;
    public String content;
    public int type;

    public GeneralBean(String title, int rid, Fragment fragment, int num, String content, int type) {
        this.title = title;
        this.rid = rid;
        this.fragment = fragment;
        this.num = num;
        this.content = content;
        this.type = type;
    }

    public GeneralBean(String title, Fragment fragment, int type) {
        this.title = title;
        this.fragment = fragment;
        this.type = type;
    }

    public GeneralBean(String title, int num, int type) {
        this.title = title;
        this.num = num;
        this.type = type;
    }

    public GeneralBean(String title, int rid, Fragment fragment, int num, int type) {
        this.title = title;
        this.rid = rid;
        this.fragment = fragment;
        this.num = num;
        this.type = type;
    }

    public GeneralBean(String title, int rid, Fragment fragment, String content, int type) {
        this.title = title;
        this.rid = rid;
        this.fragment = fragment;
        this.content = content;
        this.type = type;
    }

    public GeneralBean(String title, int rid, Fragment fragment, int type) {
        this.title = title;
        this.rid = rid;
        this.fragment = fragment;
        this.type = type;
    }

    public GeneralBean(String title, Fragment fragment, int type, String content) {
        this.title = title;
        this.fragment = fragment;
        this.type = type;
        this.content = content;
    }public GeneralBean(String title, Fragment fragment, String content,int type) {
        this.title = title;
        this.fragment = fragment;
        this.type = type;
        this.content = content;
    }

    public GeneralBean(String title, int type) {
        this.title = title;
        this.type = type;
    }
    public GeneralBean(int type) {
        this.type = type;
    }
}
