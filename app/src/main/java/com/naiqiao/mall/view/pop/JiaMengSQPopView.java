package com.naiqiao.mall.view.pop;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.fragment.jiameng.JiaMengGsJBQKFragment;
import com.naiqiao.mall.fragment.jiameng.JiaMengJiBenQKFragment;

import util.RxBus;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class JiaMengSQPopView extends TitleBasePopView {
    public JiaMengSQPopView(Context ctx) {
        super(ctx);
    }

    @Override
    protected View getChildView() {
        View view = View.inflate(ctx, R.layout.pop_shen_qing_jia_meng, null);
        Button bt_geren = (Button) view.findViewById(R.id.bt_geren);
        Button bt_qiye = (Button) view.findViewById(R.id.bt_qiye);
        bt_geren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                RxBus.get().post("addFragment",new AddFragmentBean(new JiaMengJiBenQKFragment()));
            }
        });

        bt_qiye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                RxBus.get().post("addFragment",new AddFragmentBean(new JiaMengGsJBQKFragment()));
            }
        });
        return view;
    }

    @Override
    protected String getTitle() {
        return "申请加盟";
    }
}
