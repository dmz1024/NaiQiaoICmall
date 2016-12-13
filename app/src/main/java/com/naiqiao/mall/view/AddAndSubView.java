package com.naiqiao.mall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;

/**
 * Created by dengmingzhi on 2016/12/13.
 */

public class AddAndSubView extends LinearLayout {
    private View fg_sub;
    private View fg_add;
    private TextView tv_count;
    public AddAndSubView(Context context) {
        this(context, null);
    }

    public AddAndSubView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.view_add_and_sub, this);
        fg_sub=findViewById(R.id.fg_add_and_sub_sub);
        fg_add=findViewById(R.id.fg_add_and_sub_add);
        tv_count= (TextView) findViewById(R.id.tv_add_and_sub_count);
    }
}
