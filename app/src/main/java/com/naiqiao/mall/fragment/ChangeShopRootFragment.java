package com.naiqiao.mall.fragment;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;

import java.util.ArrayList;
import java.util.List;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import util.DrawableUtil;
import view.DefaultTitleBarView;
import view.NoScrollViewPager;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class ChangeShopRootFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.vp_content)
    NoScrollViewPager vp_content;
    @BindView(R.id.bt_next)
    Button bt_next;
    @BindViews({R.id.tv_title_1, R.id.tv_title_2, R.id.tv_title_3, R.id.tv_title_4})
    List<TextView> tvTitles;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ChangeShopContentFragment());
        fragments.add(new ChangeShopContentFragment());
        fragments.add(new AffirmChangeShopFragment());
        fragments.add(new ChangeShopSuccessFragment());
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

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_change_shop_root;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("申请换货");
    }

    @OnClick(R.id.bt_next)
    void next() {
        vp_content.setCurrentItem(vp_content.getCurrentItem() + 1, false);
        if (vp_content.getCurrentItem() == 1) {
            bt_next.setText("去确认换货单");
        } else if (vp_content.getCurrentItem() == 2) {
            bt_next.setText("提交审核");
        } else {
            bt_next.setVisibility(View.GONE);
        }

        tvTitles.get(vp_content.getCurrentItem()).setTextColor(Color.parseColor("#f53f5f"));
        tvTitles.get(vp_content.getCurrentItem()).setCompoundDrawables(null, null, null, DrawableUtil.setBounds(getResources().getDrawable(R.mipmap.icon_checked)));
    }

}
