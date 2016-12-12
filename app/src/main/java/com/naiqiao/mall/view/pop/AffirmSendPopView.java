package com.naiqiao.mall.view.pop;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.naiqiao.mall.R;

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by dengmingzhi on 2016/12/12.
 */

public class AffirmSendPopView extends TitleBasePopView {
    private LinearLayout ll_shop;
    public AffirmSendPopView(Context ctx) {
        super(ctx);
    }

    @Override
    protected View getChildView() {
        View view=View.inflate(ctx, R.layout.pop_affirm_send,null);
        ll_shop= (LinearLayout) view.findViewById(R.id.ll_shop);
        creatShop();
        return view;
    }

    private void creatShop() {
        for (int i = 0; i <2 ; i++) {
            ll_shop.addView(View.inflate(ctx,R.layout.item_affirm_send,null));
        }
    }

    @Override
    protected String getTitle() {
        return "确认发货单";
    }
}
