package com.naiqiao.mall.view.pop;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.naiqiao.mall.R;
import base.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.fragment.TuiFragment;

import util.RxBus;

/**
 * Created by dengmingzhi on 2016/12/13.
 */

public class ChooseShouhouCountPopView extends TitleBasePopView {
    public ChooseShouhouCountPopView(Context ctx) {
        super(ctx);
    }

    @Override
    protected View getChildView() {
        View view = View.inflate(ctx, R.layout.pop_choose_shouhou_count, null);
        LinearLayout ll_shop = (LinearLayout) view.findViewById(R.id.ll_shop);
        creatShop(ll_shop);
        Button bt_sq= (Button) view.findViewById(R.id.bt_sq);
        bt_sq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                RxBus.get().post("addFragment",new AddFragmentBean(new TuiFragment()));
            }
        });
        return view;
    }

    private void creatShop(LinearLayout ll_shop) {
        for (int i = 0; i < 5; i++) {
            ll_shop.addView(View.inflate(ctx, R.layout.item_choose_shouhou_count, null));
        }
    }

    @Override
    protected String getTitle() {
        return "选择售后商品数量";
    }
}
