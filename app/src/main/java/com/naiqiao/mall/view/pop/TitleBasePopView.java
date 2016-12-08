package com.naiqiao.mall.view.pop;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;

import base.other.PopBaseView;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public abstract class TitleBasePopView extends PopBaseView {
    public TitleBasePopView(Context ctx) {
        super(ctx);
    }

    @Override
    protected View getView() {
        LinearLayout view = (LinearLayout) View.inflate(ctx, R.layout.pop_title_base, null);
        view.addView(getChildView());
        TextView tv_title= (TextView) view.findViewById(R.id.tv_title);
        tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        tv_title.setText(getTitle());
        return view;
    }



    @Override
    protected int width() {
        return 60;
    }

    /**
     * 内容布局
     * @return
     */
    protected abstract View getChildView();

    /**
     * 标题
     * @return
     */
    protected abstract String getTitle();
}
