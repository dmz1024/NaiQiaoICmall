package com.naiqiao.mall.fragment;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import util.DrawableUtil;
import view.Color2Text;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class ChangeShopTwoContentFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.tv_total_price)
    Color2Text tv_total_price;
    @BindView(R.id.tv_can_choose_price)
    TextView tv_can_choose_price;
    @BindView(R.id.tv_choose)
    TextView tv_choose;
    private ChangeShopTwoFragment fragment;

    @Override
    protected void initData() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, fragment = new ChangeShopTwoFragment()).commit();
    }

    @Override
    protected void initView() {
        tv_can_choose_price.setVisibility(View.GONE);
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_change_shop_content;
    }

    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }


    public void saveChange() {
        if (fragment != null) {
            fragment.saveChange();
        }
    }

    public void setPrice() {

    }

    private boolean isChoose;

    @OnClick(R.id.tv_choose)
    void choose() {
        double price = fragment.choose(!isChoose);
        if (price != -1) {
            tv_total_price.setTextNotChange(price + "元");
            initDra();
            tv_choose.setCompoundDrawables(DrawableUtil.setBounds((isChoose = !isChoose) ? draed : dra), null, null, null);
        }
    }

    private Drawable dra;
    private Drawable draed;

    private void initDra() {
        if (dra == null) {
            dra = getResources().getDrawable(R.mipmap.icon_check);
        }
        if (draed == null) {
            draed = getResources().getDrawable(R.mipmap.icon_checked);
        }
    }


    public void setChoose(boolean choose, double price) {
        isChoose = choose;
        initDra();
        tv_choose.setCompoundDrawables(DrawableUtil.setBounds(isChoose ? draed : dra), null, null, null);
        tv_total_price.setTextNotChange(price + "元");
    }
}
