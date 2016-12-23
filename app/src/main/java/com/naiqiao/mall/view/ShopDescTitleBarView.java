package com.naiqiao.mall.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;

import interfaces.OnTitleBarListener;
import util.DrawableUtil;

/**
 * Created by dengmingzhi on 2016/11/24.
 */

public class ShopDescTitleBarView extends RelativeLayout implements View.OnClickListener {
    private FrameLayout title_bar_fg_left;
    private TextView title_bar_tv_right;
    public ShopDescTitleBarView(Context context) {
        this(context, null);
    }

    public ShopDescTitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.title_bar_shop_desc, this);
        title_bar_fg_left = (FrameLayout) findViewById(R.id.title_bar_fg_left);
        title_bar_tv_right = (TextView) findViewById(R.id.title_bar_tv_right);
    }



    private OnTitleBarListener onTitleBarListener;

    public ShopDescTitleBarView setOnTitleBarListener(OnTitleBarListener onTitleBarListener) {
        if (onTitleBarListener != null) {
            title_bar_fg_left.setOnClickListener(this);
            title_bar_tv_right.setOnClickListener(this);
            this.onTitleBarListener = onTitleBarListener;
        }
        return this;
    }

    @Override
    public void onClick(View v) {
        if (title_bar_fg_left == v) {
            onTitleBarListener.left();
        }  else if (title_bar_tv_right == v) {
            onTitleBarListener.right();
        }
    }

    public ShopDescTitleBarView setRightImage(@DrawableRes int rid) {
        title_bar_tv_right.setCompoundDrawables(null, DrawableUtil.setBounds(getResources().getDrawable(rid)),null,null);
        return this;
    }
    public ShopDescTitleBarView setBackColor(String color) {
        setBackgroundColor(Color.parseColor(color));
        return this;
    }



}
