package com.naiqiao.mall.bean;

import java.util.ArrayList;

import base.bean.BaseBean;

/**
 * Created by dengmingzhi on 2017/1/4.
 */

public class ProblemAnswerBean extends BaseBean<ProblemAnswerBean.Data> {
    public static class Data {
        public Info info;
        public ArrayList<HotProblemBean.Data> list;

        public static class Info {
            public String article_id;
            public String title;
            public String content;
        }

    }
}
