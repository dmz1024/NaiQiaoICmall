package com.naiqiao.mall.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.view.RightImageTitleBarView;

import java.util.List;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import interfaces.OnTitleBarListener;
import util.DrawableUtil;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class AllShopContentFragment extends NotNetWorkBaseFragment implements OnTitleBarListener {
    @BindViews({R.id.tv_xiaoliang, R.id.tv_kucun, R.id.tv_price})
    List<TextView> tvs;
    @BindViews({R.id.fg_xiaoliang, R.id.fg_kucun, R.id.fg_price})
    List<FrameLayout> fgs;
    public boolean isVertical = true;

    @Override
    protected void initData() {
        dra = DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_asc));
        draed = DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_asc_check));
        color = Color.parseColor("#666666");
        colored = Color.parseColor("#f53f5f");
    }

    private AllShopFragment allShopFragment;

    @Override
    protected void initView() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, allShopFragment = new AllShopFragment()).commit();
    }

    @Override
    protected View getTitleBarView() {
        return new RightImageTitleBarView(getContext());
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_all_shop;
    }

    private RightImageTitleBarView titleBarView;

    @Override
    protected void initTitleView() {
        titleBarView = (RightImageTitleBarView) getTitleBar();
        titleBarView.setOnTitleBarListener(this).setTitleContent("全部商品");
    }

    @Override
    public void left() {

    }

    @Override
    public void right() {
        if (allShopFragment != null && allShopFragment.right(!isVertical)) {
            titleBarView.setRightImage((isVertical = !isVertical) ? R.mipmap.icon_display_list : R.mipmap.icon_display_block);
        }

    }

    @Override
    public void center() {

    }


    @OnClick({R.id.tv_change, R.id.tv_send})
    void tvsOnclick(View view) {

    }

    private String type;

    @OnClick({R.id.fg_xiaoliang, R.id.fg_kucun, R.id.fg_price})
    void filterChange(View view) {
        switch (view.getId()) {
            case R.id.fg_xiaoliang:
                type = TextUtils.equals("sale", type) ? "" : "sale";
                break;
            case R.id.fg_kucun:
                type = TextUtils.equals("num", type) ? "" : "num";
                break;
            case R.id.fg_price:
                type = TextUtils.equals("price", type) ? "" : "price";
                break;
        }

        changeBt();
        allShopFragment.filter(type);
    }

    private Drawable dra;
    private Drawable draed;
    private int color;
    private int colored;

    private void changeBt() {
        for (int i = 0; i < tvs.size(); i++) {
            tvs.get(i).setTextColor(color);
            tvs.get(i).setCompoundDrawables(null, null, dra, null);
        }
        int typeed = -1;
        switch (type) {
            case "sale":
                typeed = 0;
                break;
            case "num":
                typeed = 1;
                break;
            case "price":
                typeed = 2;
                break;
        }

        if (typeed != -1) {
            tvs.get(typeed).setTextColor(colored);
            tvs.get(typeed).setCompoundDrawables(null, null, draed, null);
        }

    }
}
