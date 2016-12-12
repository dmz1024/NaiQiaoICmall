package com.naiqiao.mall.fragment.base;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.util.ArrayList;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/7.
 */

public abstract class TabIndicatorBaseFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.tablayout)
    public TabLayout tab;
    @BindView(R.id.vp_content)
    ViewPager vp_content;
    ArrayList<Fragment> fragments;
    String[] tabTitles;

    @Override
    protected void initData() {
        vp_content.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabTitles[position];
            }
        });

        tab.setupWithViewPager(vp_content);
    }


    @Override
    protected void initView() {
        fragments = getFragments();
        tabTitles = getTabTitles();
        vp_content.setOffscreenPageLimit(fragments.size());

    }

    protected abstract ArrayList<Fragment> getFragments();

    protected abstract String[] getTabTitles();

    protected abstract String getTitleContent();

    @Override
    protected int getRId() {
        return R.layout.fragment_base_indicator;
    }

    @Override
    protected View getTitleBarView() {
        return new DefaultTitleBarView(getContext());
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent(getTitleContent());
    }
}
