package com.naiqiao.mall.view.pop;

import android.content.Context;
import android.view.View;

import com.naiqiao.mall.R;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class PaiZhaoYQPopView extends TitleBasePopView {
    public PaiZhaoYQPopView(Context ctx) {
        super(ctx);
    }

    @Override
    protected View getChildView() {
        View view = View.inflate(ctx, R.layout.pop_pai_zhao_yao_qiu, null);
        return view;
    }

    @Override
    protected String getTitle() {
        return "拍照要求";
    }
}
