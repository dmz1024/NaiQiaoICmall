package com.naiqiao.mall.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;

/**
 * Created by dengmingzhi on 2016/11/28.
 */

public class IndexSearchTitleBarView extends RelativeLayout implements TextWatcher, View.OnClickListener {
    private TextView title_bar_tv_right;
    private AutoCompleteTextView title_bar_ed_search;

    public IndexSearchTitleBarView(Context context) {
        this(context, null);
    }

    public IndexSearchTitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View.inflate(context, R.layout.title_bar_index_search, this);
        title_bar_tv_right = (TextView) findViewById(R.id.title_bar_tv_right);
        title_bar_ed_search = (AutoCompleteTextView) findViewById(R.id.title_bar_ed_search);
        title_bar_ed_search.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.equals("取消", title_bar_tv_right.getText().toString())) {
            onIndexSearchTitleBarListener.cancel();
        } else {
            onIndexSearchTitleBarListener.content(title_bar_ed_search.getText().toString());
        }

    }


    public interface OnIndexSearchTitleBarListener {
        void content(String content);

        void cancel();
    }

    private OnIndexSearchTitleBarListener onIndexSearchTitleBarListener;

    public void setOnIndexSearchTitleBarListener(OnIndexSearchTitleBarListener onIndexSearchTitleBarListener) {
        this.onIndexSearchTitleBarListener = onIndexSearchTitleBarListener;
        title_bar_tv_right.setOnClickListener(this);
    }

    public IndexSearchTitleBarView setEdHint(String hint) {
        title_bar_ed_search.setHint(hint);
        return this;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        title_bar_tv_right.setText(s.toString().length() > 0 ? "搜索" : "取消");
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
