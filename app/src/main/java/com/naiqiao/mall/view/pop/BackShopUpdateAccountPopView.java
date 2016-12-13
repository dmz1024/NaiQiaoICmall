package com.naiqiao.mall.view.pop;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;

import util.DrawableUtil;

/**
 * Created by dengmingzhi on 2016/12/13.
 */

public class BackShopUpdateAccountPopView extends TitleBasePopView implements View.OnClickListener {
    private int type = 1;
    private TextView tv_private;
    private TextView tv_public;
    private LinearLayout ll_public;
    private LinearLayout ll_private;

    public BackShopUpdateAccountPopView(Context ctx) {
        super(ctx);
    }

    @Override
    protected View getChildView() {
        View view = View.inflate(ctx, R.layout.pop_back_shop_update_account, null);
        tv_private = (TextView) view.findViewById(R.id.tv_private);
        tv_public = (TextView) view.findViewById(R.id.tv_public);
        ll_public = (LinearLayout) view.findViewById(R.id.ll_public);
        ll_private = (LinearLayout) view.findViewById(R.id.ll_private);
        tv_private.setOnClickListener(this);
        tv_public.setOnClickListener(this);
        return view;
    }

    @Override
    protected String getTitle() {
        return "修改收款账号";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_private:
                type = 1;
                chooseType();
                break;
            case R.id.tv_public:
                type = 2;
                chooseType();
                break;
        }
    }

    private void chooseType() {
        ll_public.setVisibility(View.GONE);
        ll_private.setVisibility(View.GONE);
        tv_private.setCompoundDrawables(DrawableUtil.setBounds(ctx.getResources().getDrawable(R.mipmap.icon_check)), null, null, null);
        tv_public.setCompoundDrawables(DrawableUtil.setBounds(ctx.getResources().getDrawable(R.mipmap.icon_check)), null, null, null);
        if (type == 1) {
            ll_private.setVisibility(View.VISIBLE);
            tv_private.setCompoundDrawables(DrawableUtil.setBounds(ctx.getResources().getDrawable(R.mipmap.icon_checked)), null, null, null);
        } else {
            ll_public.setVisibility(View.VISIBLE);
            tv_public.setCompoundDrawables(DrawableUtil.setBounds(ctx.getResources().getDrawable(R.mipmap.icon_checked)), null, null, null);
        }

    }
}
