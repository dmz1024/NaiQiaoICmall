package com.naiqiao.mall.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;

import interfaces.OnTitleBarListener;
import view.TextImage;

/**
 * Created by dengmingzhi on 2016/11/24.
 */

public class OneAndTwoTitleBarView extends RelativeLayout implements View.OnClickListener {
    private EditText title_bar_ed_search;
    private TextView title_bar_tv_left;
    private TextView title_bar_tv_right;
    private View title_bar_view;
    public OneAndTwoTitleBarView(Context context) {
        this(context, null);
    }

    public OneAndTwoTitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.title_bar_one_two, this);
        title_bar_ed_search = (EditText) findViewById(R.id.title_bar_ed_search);
        title_bar_tv_left = (TextView) findViewById(R.id.title_bar_tv_left);
        title_bar_tv_right = (TextView) findViewById(R.id.title_bar_tv_right);
        title_bar_view = findViewById(R.id.title_bar_view);
    }



    private OnTitleBarListener onTitleBarListener;

    public OneAndTwoTitleBarView setOnTitleBarListener(OnTitleBarListener onTitleBarListener) {
        if (onTitleBarListener != null) {
            title_bar_tv_left.setOnClickListener(this);
            title_bar_tv_right.setOnClickListener(this);
            title_bar_ed_search.setOnClickListener(this);
            this.onTitleBarListener = onTitleBarListener;
        }
        return this;
    }

    @Override
    public void onClick(View v) {
        if (title_bar_tv_left == v) {
            onTitleBarListener.left();
        }  else if (title_bar_tv_right == v) {
            onTitleBarListener.right();
        }else if(title_bar_ed_search==v){
            onTitleBarListener.center();
            title_bar_ed_search.clearFocus();
        }
    }






    public OneAndTwoTitleBarView setBackColor(String color) {
        setBackgroundColor(Color.parseColor(color));
        return this;
    }

    public OneAndTwoTitleBarView setRightColor(String color) {
        title_bar_tv_right.setTextColor(Color.parseColor(color));
        return this;
    }


}
