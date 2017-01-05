package com.naiqiao.mall.fragment;

import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.view.RightImageTitleBarView;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import interfaces.OnTitleBarListener;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class AllShopContentFragment extends NotNetWorkBaseFragment implements OnTitleBarListener {

    public boolean isVertical = true;

    @Override
    protected void initData() {

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
}
