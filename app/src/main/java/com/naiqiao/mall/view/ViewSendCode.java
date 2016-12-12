package com.naiqiao.mall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.naiqiao.mall.R;

/**
 * Created by dengmingzhi on 2016/12/12.
 */

public class ViewSendCode extends LinearLayout {
    public ViewSendCode(Context context) {
        this(context, null);
    }

    public ViewSendCode(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_send_code, this);
    }
}
