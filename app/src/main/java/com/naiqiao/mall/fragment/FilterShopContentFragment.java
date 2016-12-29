package com.naiqiao.mall.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.FilterShopListAdapter;
import com.naiqiao.mall.bean.FilterBean;
import com.naiqiao.mall.bean.TwoRightBean;
import com.naiqiao.mall.view.pop.FilterShopPopView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import util.DrawableUtil;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/1.
 */

public class FilterShopContentFragment extends NotNetWorkBaseFragment {
    @BindViews({R.id.tv_filter, R.id.tv_price, R.id.tv_count})
    List<TextView> tvs;
    @BindViews({R.id.fg_price, R.id.fg_count})
    List<FrameLayout> fgs;
    private ArrayList<FilterBean.Data> filters = new ArrayList<>();
    private int select = -1;
    private String id;
    private int type = 0;
    private String title;

    public static FilterShopContentFragment getInstance(String id, int type, String title) {
        FilterShopContentFragment fragment = new FilterShopContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putInt("type", type);
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");
            type = bundle.getInt("type");
            title = bundle.getString("title");
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent(title);
    }

    private FilterShopListFragment shopListFragment;
    private Map<String, String> filterMap = new ArrayMap<>();

    @Override
    protected void initView() {
        tvs.get(0).setText(type == 0 ? "品牌" : "分类");
        shopListFragment = new FilterShopListFragment();
        filterMap.put(type == 0 ? "cat_id" : "brand_id", id);
        filterMap.put("act", type == 0 ? "get_cat_info" : "get_brand_info");
        shopListFragment.setFilterMap(filterMap);
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, shopListFragment).commit();
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
        count = count == 0 ? 2 : 0;
        changeColorAndDra();
        startFilter();
    }


    /**
     * 价格
     */
    private void price() {
        count = 0;
        price = price == 0 ? 1 : (price == 1 ? 2 : 1);
        changeColorAndDra();
        startFilter();

    }

    private int changeZhi(int zhi) {
        if (zhi == 0 || zhi == 2) {
            zhi = 1;
        } else {
            zhi = 2;
        }
        return zhi;
    }

    /**
     * 分类
     */
    private void filter() {
        new FilterShopPopView(getContext(), id, type, select, filters) {
            @Override
            protected boolean isAlpha() {
                return false;
            }

            @Override
            protected void setData(ArrayList<FilterBean.Data> datas) {
                filters.addAll(datas);
            }

            @Override
            protected void ok(int position) {
                select = position;
                if (select == -1) {
                    price = 0;
                    count = 0;
                }
                startFilter();


            }
        }.showAsDropDown(tvs.get(0), false);
    }

    private void startFilter() {
        if (select == -1) {
            filterMap.clear();
        } else {
            filterMap.put(type == 0 ? "brand_id" : "cat_id", filters.get(select).brand_id);
        }
        changeColorAndDra();
        filterMap.put(type == 0 ? "cat_id" : "brand_id", id);
        filterMap.put("act", type == 0 ? "get_cat_info" : "get_brand_info");
        filterMap.put("price_sort", price == 0 ? "" : price + "");
        filterMap.put("saled_sort", count == 0 ? "" : count + "");
        shopListFragment.setFilterMap(filterMap);
        shopListFragment.startRefresh();
    }


    private void changeColorAndDra() {
        tvs.get(1).setTextColor(Color.parseColor(price == 0 ? "#666666" : "#f54262"));
        tvs.get(1).setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(price == 0 ? R.mipmap.icon_updown : (price == 1 ? R.mipmap.icon_updown_up : R.mipmap.icon_updown_down))), null);
        tvs.get(2).setTextColor(Color.parseColor(count == 0 ? "#666666" : "#f54262"));
        tvs.get(2).setCompoundDrawables(null, null, DrawableUtil.setBounds(getResources().getDrawable(count == 0 ? R.mipmap.icon_asc : R.mipmap.icon_asc_check)), null);
        tvs.get(0).setBackgroundColor(Color.parseColor(select == -1 ? "#f5f5f5" : "#ffffff"));
        tvs.get(0).setTextColor(Color.parseColor(select == -1 ? "#666666" : "#f73f5f"));
    }
}
