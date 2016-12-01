package com.naiqiao.mall.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.FilterShopListAdapter;
import com.naiqiao.mall.view.pop.FilterShopPopView;

import java.util.List;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import util.DrawableUtil;

/**
 * Created by dengmingzhi on 2016/12/1.
 */

public class FilterShopContentFragment extends NotNetWorkBaseFragment {
    @BindViews({R.id.tv_filter, R.id.tv_price, R.id.tv_count})
    List<TextView> tvs;
    @BindViews({R.id.fg_price, R.id.fg_count})
    List<FrameLayout> fgs;

    @Override
    protected void initData() {

    }

    private FilterShopListFragment shopListFragment;

    @Override
    protected void initView() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, shopListFragment = new FilterShopListFragment()).commit();
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_filter_shop_list;
    }


    @OnClick({R.id.tv_filter, R.id.fg_price, R.id.fg_count})
    void tvOnClick(View view) {
        switch (view.getId()) {
            case R.id.tv_filter:
                filter();
                break;
            case R.id.fg_price:
                price();
                break;
            case R.id.fg_count:
                count();
                break;
        }
    }


    private int price = 0;
    private int count = 0;

    /**
     * 销量
     */
    private void count() {
        price = 0;
        count = changeZhi(count);
        changeColorAndDra();
    }


    /**
     * 价格
     */
    private void price() {
        count = 0;
        price = changeZhi(price);
        changeColorAndDra();
    }

    /**
     * 分类
     */
    private void filter() {
        new FilterShopPopView(getContext(), 1) {
            @Override
            protected boolean isAlpha() {
                return false;
            }
        }.showAsDropDown(tvs.get(0), false);
    }

    private int changeZhi(int zhi) {
        if (zhi == 0 || zhi == 2) {
            zhi = 1;
        } else {
            zhi = 2;
        }
        return zhi;
    }

    private void changeColorAndDra() {

        int[] i = {price, count};

        for (int j = 0; j < 2; j++) {
            switch (i[j]) {
                case 0:
                    tvs.get(j + 1).setTextColor(Color.parseColor("#666666"));
                    tvs.get(j + 1).setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_updown)), null);
                    break;
                case 1:
                    tvs.get(j + 1).setTextColor(Color.parseColor("#f54262"));
                    tvs.get(j + 1).setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_updown_up)), null);
                    break;
                case 2:
                    tvs.get(j + 1).setTextColor(Color.parseColor("#f54262"));
                    tvs.get(j + 1).setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_updown_down)), null);
                    break;
            }
        }
    }
}
