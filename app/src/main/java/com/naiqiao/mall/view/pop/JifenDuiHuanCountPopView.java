package com.naiqiao.mall.view.pop;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.fragment.JiFenWriteOrderFragment;

import api.TestConstant;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/12/13.
 */

public class JifenDuiHuanCountPopView extends TitleBasePopView {
    public JifenDuiHuanCountPopView(Context ctx) {
        super(ctx);
    }

    @Override
    protected View getChildView() {
        View view = View.inflate(ctx, R.layout.pop_jifen_duihuan, null);
        ImageView iv_img= (ImageView) view.findViewById(R.id.iv_img);
        Glide.with(ctx).load(TestConstant.IMAGE).into(iv_img);
        Button bt_pay= (Button) view.findViewById(R.id.bt_pay);
        bt_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                RxBus.get().post("addFragment",new AddFragmentBean(new JiFenWriteOrderFragment()));
            }
        });
        return view;
    }

    @Override
    protected String getTitle() {
        return "兑换数量";
    }
}
