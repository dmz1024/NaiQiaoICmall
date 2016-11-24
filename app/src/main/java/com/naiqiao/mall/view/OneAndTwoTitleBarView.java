package com.naiqiao.mall.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;

import interfaces.OnTitleBarListener;

/**
 * Created by dengmingzhi on 2016/11/24.
 */

public class OneAndTwoTitleBarView extends RelativeLayout implements View.OnClickListener {


    public OneAndTwoTitleBarView(Context context) {
        this(context, null);
    }

    public OneAndTwoTitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.title_bar_one_two, this);
    }

    @Override
    public void onClick(View v) {

    }


//    private OnTitleBarListener onTitleBarListener;

//    public OneAndTwoTitleBarView setOnTitleBarListener(OnTitleBarListener onTitleBarListener) {
//        if (onTitleBarListener != null) {
//            title_bar_rl_right.setOnClickListener(this);
//            title_bar_iv_left.setOnClickListener(this);
//            title_bar_tv_title.setOnClickListener(this);
//            this.onTitleBarListener = onTitleBarListener;
//        }
//        return this;
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (title_bar_iv_left == v) {
//            onTitleBarListener.left();
//        } else if (title_bar_rl_right == v) {
//            onTitleBarListener.right();
//        } else if (title_bar_tv_title == v) {
//            onTitleBarListener.center();
//        }
//    }
//
//
//    public OneAndTwoTitleBarView setLeftImage(Bitmap bitmap) {
//        title_bar_iv_left.setImageBitmap(bitmap);
//        return this;
//    }
//
//
//    public OneAndTwoTitleBarView setRightContent(String content) {
//        if (TextUtils.equals(content, "0") || TextUtils.isEmpty(content)) {
//            title_bar_tv_right.setVisibility(GONE);
//        } else {
//            title_bar_tv_right.setVisibility(VISIBLE);
//            title_bar_tv_right.setText(content);
//        }
//        return this;
//    }
//
//    public OneAndTwoTitleBarView setTitleContent(String content) {
//        title_bar_tv_title.setText(content);
//        return this;
//    }
//
//    public OneAndTwoTitleBarView setTitleColor(String color) {
//        title_bar_tv_title.setTextColor(Color.parseColor(color));
//        return this;
//    }
//
//    public OneAndTwoTitleBarView setBackColor(String color) {
//        setBackgroundColor(Color.parseColor(color));
//        return this;
//    }
//
//    public OneAndTwoTitleBarView setRightColor(String color) {
//        title_bar_tv_right.setTextColor(Color.parseColor(color));
//        return this;
//    }
//
//    public OneAndTwoTitleBarView setTitleSize(int size) {
//        title_bar_tv_title.setTextSize(size);
//        return this;
//    }
//
//
//    public OneAndTwoTitleBarView showVisiLeft(int visi) {
//        title_bar_iv_left.setVisibility(visi);
//        return this;
//    }
//
//    public OneAndTwoTitleBarView showVisiRight(int visi) {
//        title_bar_rl_right.setVisibility(visi);
//        return this;
//    }

}
