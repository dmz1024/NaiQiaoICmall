package com.naiqiao.mall.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.Button;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.UserLoginInfo;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.view.ViewProgress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import api.ApiRequest;
import base.bean.SingleBaseBean;
import base.bean.TipLoadingBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import interfaces.OnSingleRequestListener;
import interfaces.OnTitleBarListener;
import util.RxBus;
import util.SharedPreferenUtil;
import view.DefaultTitleBarView;
import view.NoScrollViewPager;

/**
 * Created by dengmingzhi on 2016/12/14.
 */

public class ChangeShopRootFragment extends NotNetWorkBaseFragment implements OnTitleBarListener {
    @BindView(R.id.vp_content)
    NoScrollViewPager vp_content;
    @BindView(R.id.bt_next)
    Button bt_next;
    @BindView(R.id.view_pro)
    ViewProgress view_pro;

    @Override
    protected void initData() {

    }

    private ArrayList<Fragment> fragments;

    @Override
    protected void initView() {

        fragments = new ArrayList<>();
        fragments.add(new ChangeShopOneContentFragment());
        fragments.add(new ChangeShopTwoContentFragment());
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

        view_pro.setTitle("选择换货商品,选择进货商品,确认换货单,提交审核");
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_change_shop_root;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("申请换货").setOnTitleBarListener(this);
    }

    @OnClick(R.id.bt_next)
    void next() {
        switch (vp_content.getCurrentItem()) {
            case 0:
                if (((ChangeShopOneContentFragment) fragments.get(0)).saveChange()) {
                    setCurrent();
                }
                break;
            case 1:
                if (((ChangeShopTwoContentFragment) fragments.get(1)).saveChange()) {
                    setCurrent();
                }
                break;
            case 2:
                doneShop();
                break;
            case 3:
                RxBus.get().post("back", "back");
                break;
        }
    }

    private void setCurrent() {
        vp_content.setCurrentItem(vp_content.getCurrentItem() + 1, false);
        if (vp_content.getCurrentItem() == 1) {
            bt_next.setText("去确认换货单");
        } else if (vp_content.getCurrentItem() == 2) {
            bt_next.setText("提交审核");
        } else {
            bt_next.setText("返回");
        }

        view_pro.setCurrentPosition(vp_content.getCurrentItem());
    }

    /**
     * 提交换货
     */
    private void doneShop() {
        final Map<String, String> map = new SharedPreferenUtil(getContext(), "changeGoods").getData(new String[]{"goods_ids", "rec_ids"});
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("act", "done");
        new ApiRequest<SingleBaseBean>() {
            @Override
            protected Map<String, String> getMap() {
                return map;
            }

            @Override
            protected Context getContext() {
                return ChangeShopRootFragment.this.getContext();
            }

            @Override
            protected String getUrl() {
                return ApiConstant.EXGOODS;
            }

            @Override
            protected Class<SingleBaseBean> getClx() {
                return SingleBaseBean.class;
            }

            @Override
            protected boolean getShowSucces() {
                return false;
            }
        }.setOnRequestListeren(new OnSingleRequestListener<SingleBaseBean>() {
            @Override
            public void succes(boolean isWrite, SingleBaseBean bean) {
                setCurrent();
            }

            @Override
            public void error(boolean isWrite, SingleBaseBean bean, String msg) {

            }
        }).get(new TipLoadingBean("正在申请换货...", "", ""));

    }

    @Override
    public void left() {
        if (vp_content.getCurrentItem() == 3 || vp_content.getCurrentItem() == 0) {
            RxBus.get().post("back", "back");
        } else {
            vp_content.setCurrentItem(vp_content.getCurrentItem() - 1,false);
            view_pro.setCurrentPosition(vp_content.getCurrentItem());
        }
    }

    @Override
    public void right() {

    }

    @Override
    public void center() {

    }
}
