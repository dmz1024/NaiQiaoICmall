package com.naiqiao.mall.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import util.DrawableUtil;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class ChangeShopOneContentFragment extends NotNetWorkBaseFragment {
    private boolean isChoose;
    @BindView(R.id.tv_choose)
    TextView tv_choose;
    private ChangeShopOneFragment fragment;

    @Override
    protected void initData() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, fragment = new ChangeShopOneFragment()).commit();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_change_shop_content;
    }

    @Override
    protected View getTitleBarView() {
        return null;
    }


    public boolean saveChange() {
        if (fragment != null) {
            return fragment.saveChange();
        }
        return false;
    }

    private Drawable dra;
    private Drawable draed;

    @OnClick(R.id.tv_choose)
    void choose() {
        if (dra == null) {
            dra = getResources().getDrawable(R.mipmap.icon_check);
        }
        if (draed == null) {
            draed = getResources().getDrawable(R.mipmap.icon_checked);
        }

        if (fragment != null && fragment.choose(!isChoose)) {
            tv_choose.setCompoundDrawables(DrawableUtil.setBounds((isChoose = !isChoose) ? draed : dra), null, null, null);
        }
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        this.isChoose = choose;
        if (dra == null) {
            dra = getResources().getDrawable(R.mipmap.icon_check);
        }
        if (draed == null) {
            draed = getResources().getDrawable(R.mipmap.icon_checked);
        }
        tv_choose.setCompoundDrawables(DrawableUtil.setBounds(this.isChoose ? draed : dra), null, null, null);
    }
}
