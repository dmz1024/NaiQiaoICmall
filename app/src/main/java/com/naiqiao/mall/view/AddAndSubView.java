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

public class AddAndSubView extends LinearLayout implements View.OnClickListener {
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
        fg_sub = findViewById(R.id.fg_add_and_sub_sub);
        fg_add = findViewById(R.id.fg_add_and_sub_add);
        tv_count = (TextView) findViewById(R.id.tv_add_and_sub_count);
    }

    private OnChangeListener onChangeListener;

    public AddAndSubView setOnChangeListener(OnChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
        if (this.onChangeListener != null) {
            fg_sub.setOnClickListener(this);
            fg_add.setOnClickListener(this);
        }
        return this;
    }

    private int min = 1;
    private int max = Integer.MAX_VALUE;
    private int index = 1;

    public AddAndSubView setIndex(int index) {
        this.index = index;
        return this;
    }

    public AddAndSubView setCount(int count) {
        if (count < min) {
            tv_count.setText(min + "");
        } else if (count > max) {
            tv_count.setText(max + "");
        } else {
            tv_count.setText(count + "");
        }
        return this;
    }

    public int getCount() {
        return Integer.parseInt(tv_count.getText().toString());
    }


    public AddAndSubView setMin(int min) {
        this.min = min;
        return this;
    }


    public AddAndSubView setMax(int max) {
        this.max = max;
        return this;
    }

    private boolean isCanChange = true;

    public AddAndSubView setCanChange(boolean isCanChange) {
        this.isCanChange = isCanChange;
        return this;
    }

    @Override
    public void onClick(View v) {
        if (!isCanChange) {
            return;
        }
        switch (v.getId()) {
            case R.id.fg_add_and_sub_sub:
                if (Integer.parseInt(tv_count.getText().toString()) - 1 < min) {
                    return;
                }
                onChangeListener.sub();
                tv_count.setText((Integer.parseInt(tv_count.getText().toString()) - index) + "");
                break;
            case R.id.fg_add_and_sub_add:
                if (Integer.parseInt(tv_count.getText().toString()) + 1 > max) {
                    return;
                }
                onChangeListener.add();
                tv_count.setText((Integer.parseInt(tv_count.getText().toString()) + index) + "");
                break;
        }
    }

    public interface OnChangeListener {
        void add();

        void sub();
    }
}
