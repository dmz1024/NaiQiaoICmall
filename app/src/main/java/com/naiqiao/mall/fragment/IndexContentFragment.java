package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naiqiao.mall.MyFragmentRefresh;
import com.naiqiao.mall.R;

import java.util.ArrayList;

import base.BaseFragment;
import butterknife.BindView;
import rx.Observable;
import rx.functions.Action1;
import util.RxBus;
import view.NoScrollViewPager;

/**
 * Created by dengmingzhi on 2016/11/22.
 */

public class IndexContentFragment extends BaseFragment {
    @BindView(R.id.vp_content)
    NoScrollViewPager vp_content;
    ArrayList<Fragment> fragments;
    Observable<Integer> indexBottomTabChange;

    @Override
    protected int getRId() {
        return R.layout.no_scroll_view_pager;
    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new MyFragmentRefresh());
        fragments.add(new MyFragmentRefresh());
        fragments.add(new MyFragmentRefresh());
        fragments.add(new MyFragmentRefresh());
        vp_content.setOffscreenPageLimit(fragments.size());
        vp_content.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        changePager();
    }


    private void changePager() {
        indexBottomTabChange = RxBus.get().register("indexBottomTabChange", Integer.class);
        indexBottomTabChange.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                vp_content.setCurrentItem(integer, false);
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("indexBottomTabChange", indexBottomTabChange);
    }
}
