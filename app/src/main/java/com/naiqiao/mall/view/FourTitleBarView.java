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

public class FourTitleBarView extends RelativeLayout implements View.OnClickListener {

    private ImageView title_bar_iv_left;
    private TextView title_bar_tv_right;
    private TextView title_bar_tv_title;
    private RelativeLayout title_bar_rl_right;

    public FourTitleBarView(Context context) {
        this(context, null);
    }

    public FourTitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.title_bar_four, this);
        title_bar_iv_left = (ImageView) findViewById(R.id.title_bar_iv_left);
        title_bar_tv_right = (TextView) findViewById(R.id.title_bar_tv_right);
        title_bar_tv_title = (TextView) findViewById(R.id.title_bar_tv_title);
        title_bar_rl_right = (RelativeLayout) findViewById(R.id.title_bar_rl_right);
    }


    private OnTitleBarListener onTitleBarListener;

    public FourTitleBarView setOnTitleBarListener(OnTitleBarListener onTitleBarListener) {
        if (onTitleBarListener != null) {
            title_bar_rl_right.setOnClickListener(this);
            title_bar_iv_left.setOnClickListener(this);
            title_bar_tv_title.setOnClickListener(this);
            this.onTitleBarListener = onTitleBarListener;
        }
        return this;
    }

    @Override
    public void onClick(View v) {
        if (title_bar_iv_left == v) {
            onTitleBarListener.left();
        } else if (title_bar_rl_right == v) {
            onTitleBarListener.right();
        } else if (title_bar_tv_title == v) {
            onTitleBarListener.center();
        }
    }


    public FourTitleBarView setLeftImage(Bitmap bitmap) {
        title_bar_iv_left.setImageBitmap(bitmap);
        return this;
    }


    public FourTitleBarView setRightContent(String content) {
        if (TextUtils.equals(content, "0") || TextUtils.isEmpty(content)) {
            title_bar_tv_right.setVisibility(GONE);
        } else {
            title_bar_tv_right.setVisibility(VISIBLE);
            title_bar_tv_right.setText(content);
        }
        return this;
    }

    public FourTitleBarView setTitleContent(String content) {
        title_bar_tv_title.setText(content);
        return this;
    }

    public FourTitleBarView setTitleColor(String color) {
        title_bar_tv_title.setTextColor(Color.parseColor(color));
        return this;
    }

    public FourTitleBarView setBackColor(String color) {
        setBackgroundColor(Color.parseColor(color));
        return this;
    }

    public FourTitleBarView setRightColor(String color) {
        title_bar_tv_right.setTextColor(Color.parseColor(color));
        return this;
    }

    public FourTitleBarView setTitleSize(int size) {
        title_bar_tv_title.setTextSize(size);
        return this;
    }


    public FourTitleBarView showVisiLeft(int visi) {
        title_bar_iv_left.setVisibility(visi);
        return this;
    }

    public FourTitleBarView showVisiRight(int visi) {
        title_bar_rl_right.setVisibility(visi);
        return this;
    }

}
