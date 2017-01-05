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

public class JiaoYi_JiFen_FanDianTitleBarView extends FrameLayout implements View.OnClickListener {
    private ImageView title_bar_iv_left;
    private ImageView title_bar_iv_right;
    private TextView title_bar_tv_title;
    private View title_bar_view;
    private FrameLayout title_bar_fg_left;
    private TextView title_bar_tv_total_price;
    private Button title_bar_bt;

    public JiaoYi_JiFen_FanDianTitleBarView(Context context) {
        this(context, null);
    }

    public JiaoYi_JiFen_FanDianTitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.title_bar_jy_jf_fd, this);
        title_bar_iv_left = (ImageView) findViewById(R.id.title_bar_iv_left);
        title_bar_iv_right = (ImageView) findViewById(R.id.title_bar_iv_right);
        title_bar_tv_title = (TextView) findViewById(R.id.title_bar_tv_title);
        title_bar_tv_total_price = (TextView) findViewById(R.id.title_bar_tv_total_price);
        title_bar_view = findViewById(R.id.title_bar_view);
        title_bar_bt = (Button) findViewById(R.id.title_bar_bt);
        title_bar_fg_left = (FrameLayout) findViewById(R.id.title_bar_fg_left);
    }


    private OnJiaoYi_JiFen_FanDianTitleBarListener onTitleBarListener;

    public JiaoYi_JiFen_FanDianTitleBarView setOnTitleBarListener(OnJiaoYi_JiFen_FanDianTitleBarListener onTitleBarListener) {
        if (onTitleBarListener != null) {
            title_bar_fg_left.setOnClickListener(this);
            title_bar_iv_right.setOnClickListener(this);
            title_bar_tv_title.setOnClickListener(this);
            title_bar_bt.setOnClickListener(this);
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
        } else if (title_bar_bt == v) {
            onTitleBarListener.rightBt();
        }
    }


    public JiaoYi_JiFen_FanDianTitleBarView setLeftImage(@DrawableRes int rid) {
        title_bar_iv_left.setImageResource(rid);
        return this;
    }


    public JiaoYi_JiFen_FanDianTitleBarView setTitleContent(String content) {
        title_bar_tv_title.setText(content);
        return this;
    }

    public JiaoYi_JiFen_FanDianTitleBarView setTitleColor(String color) {
        title_bar_tv_title.setTextColor(Color.parseColor(color));
        return this;
    }


    public JiaoYi_JiFen_FanDianTitleBarView setTitleSize(int size) {
        title_bar_tv_title.setTextSize(size);
        return this;
    }

    public JiaoYi_JiFen_FanDianTitleBarView setPrice(String price) {
        title_bar_tv_total_price.setText(price);
        title_bar_tv_total_price.setVisibility(VISIBLE);
        if (!TextUtils.isEmpty(title_bar_bt.getText().toString())) {
            title_bar_bt.setVisibility(VISIBLE);
        }
        return this;
    }


    public JiaoYi_JiFen_FanDianTitleBarView showVisiView(int visi) {
        title_bar_view.setVisibility(visi);
        return this;
    }

    public JiaoYi_JiFen_FanDianTitleBarView showVisiLeft(int visi) {
        title_bar_fg_left.setVisibility(visi);
        return this;
    }

    public JiaoYi_JiFen_FanDianTitleBarView setButtonTitle(String title) {
        title_bar_bt.setText(title);
        return this;
    }

}
