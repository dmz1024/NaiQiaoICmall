package com.naiqiao.mall.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.interfaces.OnJiaoYi_JiFen_FanDianTitleBarListener;

import interfaces.OnTitleBarListener;

/**
 * Created by dengmingzhi on 2016/11/22.
 */

public class RightImageTitleBarView extends FrameLayout implements View.OnClickListener {
    private ImageView title_bar_iv_left;
    private ImageView title_bar_iv_right;
    private TextView title_bar_tv_title;
    private View title_bar_view;
    private FrameLayout title_bar_fg_left;

    public RightImageTitleBarView(Context context) {
        this(context, null);
    }

    public RightImageTitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.title_bar_right_image, this);
        title_bar_iv_left = (ImageView) findViewById(R.id.title_bar_iv_left);
        title_bar_iv_right = (ImageView) findViewById(R.id.title_bar_iv_right);
        title_bar_tv_title = (TextView) findViewById(R.id.title_bar_tv_title);
        title_bar_view = findViewById(R.id.title_bar_view);
        title_bar_fg_left = (FrameLayout) findViewById(R.id.title_bar_fg_left);
    }


    private OnTitleBarListener onTitleBarListener;

    public RightImageTitleBarView setOnTitleBarListener(OnTitleBarListener onTitleBarListener) {
        if (onTitleBarListener != null) {
            title_bar_fg_left.setOnClickListener(this);
            title_bar_iv_right.setOnClickListener(this);
            title_bar_tv_title.setOnClickListener(this);
            this.onTitleBarListener = onTitleBarListener;
        }
        return this;
    }

    @Override
    public void onClick(View v) {
        if (title_bar_iv_left == v) {
            onTitleBarListener.left();
        } else if (title_bar_iv_right == v) {
            onTitleBarListener.right();
        } else if (title_bar_fg_left == v) {
            onTitleBarListener.center();
        }
    }


    public RightImageTitleBarView setLeftImage(@DrawableRes int rid) {
        title_bar_iv_left.setImageResource(rid);
        return this;
    }

    public RightImageTitleBarView setRightImage(@DrawableRes int rid) {
        title_bar_iv_right.setImageResource(rid);
        return this;
    }


    public RightImageTitleBarView setTitleContent(String content) {
        title_bar_tv_title.setText(content);
        return this;
    }

    public RightImageTitleBarView setTitleColor(String color) {
        title_bar_tv_title.setTextColor(Color.parseColor(color));
        return this;
    }


    public RightImageTitleBarView setTitleSize(int size) {
        title_bar_tv_title.setTextSize(size);
        return this;
    }


    public RightImageTitleBarView showVisiView(int visi) {
        title_bar_view.setVisibility(visi);
        return this;
    }

    public RightImageTitleBarView showVisiLeft(int visi) {
        title_bar_fg_left.setVisibility(visi);
        return this;
    }


}
