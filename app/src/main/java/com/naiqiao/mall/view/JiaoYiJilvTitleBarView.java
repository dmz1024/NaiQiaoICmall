package com.naiqiao.mall.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.naiqiao.mall.R;

import interfaces.OnTitleBarListener;

/**
 * Created by dengmingzhi on 2016/11/22.
 */

public class JiaoYiJilvTitleBarView extends FrameLayout implements View.OnClickListener {
    private ImageView title_bar_iv_left;
    private ImageView title_bar_iv_right;
    private TextView title_bar_tv_title;
    private View title_bar_view;
    private FrameLayout title_bar_fg_left;
    private TextView title_bar_tv_total_price;

    public JiaoYiJilvTitleBarView(Context context) {
        this(context, null);
    }

    public JiaoYiJilvTitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.title_bar_jiaoyijilv, this);
        title_bar_iv_left = (ImageView) findViewById(R.id.title_bar_iv_left);
        title_bar_iv_right = (ImageView) findViewById(R.id.title_bar_iv_right);
        title_bar_tv_title = (TextView) findViewById(R.id.title_bar_tv_title);
        title_bar_tv_total_price = (TextView) findViewById(R.id.title_bar_tv_total_price);
        title_bar_view = findViewById(R.id.title_bar_view);
        title_bar_fg_left = (FrameLayout) findViewById(R.id.title_bar_fg_left);
    }


    private OnTitleBarListener onTitleBarListener;

    public JiaoYiJilvTitleBarView setOnTitleBarListener(OnTitleBarListener onTitleBarListener) {
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


    public JiaoYiJilvTitleBarView setLeftImage(@DrawableRes int rid) {
        title_bar_iv_left.setImageResource(rid);
        return this;
    }


    public JiaoYiJilvTitleBarView setTitleContent(String content) {
        title_bar_tv_title.setText(content);
        return this;
    }

    public JiaoYiJilvTitleBarView setTitleColor(String color) {
        title_bar_tv_title.setTextColor(Color.parseColor(color));
        return this;
    }


    public JiaoYiJilvTitleBarView setTitleSize(int size) {
        title_bar_tv_title.setTextSize(size);
        return this;
    }

    public JiaoYiJilvTitleBarView setPrice(String price) {
        title_bar_tv_total_price.setText(price);
        return this;
    }


    public JiaoYiJilvTitleBarView showVisiView(int visi) {
        title_bar_view.setVisibility(visi);
        return this;
    }

    public JiaoYiJilvTitleBarView showVisiLeft(int visi) {
        title_bar_fg_left.setVisibility(visi);
        return this;
    }

}
