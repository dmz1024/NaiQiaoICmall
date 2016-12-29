package com.naiqiao.mall.fragment;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.canyinghao.canphotos.CanPhotoHelper;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.ShopInfoDescBean;
import com.naiqiao.mall.bean.rxbus.CollectRxbus;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.controller.MyCollectController;
import com.naiqiao.mall.fragment.login.LoginFragment;
import com.naiqiao.mall.view.ShopDescTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.bean.TipLoadingBean;
import base.bean.rxbus.AddFragmentBean;
import base.bean.rxbus.PhotoRxbus;
import base.fragment.SingleNetWorkBaseFragment;
import base.fragment.WebViewFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import util.DrawableUtil;
import util.RxBus;
import util.Util;
import view.CustomScrollView;
import view.DragSwitchLayout;

/**
 * Created by dengmingzhi on 2016/12/26.
 */

public class ShopInfoDescRootFragment extends SingleNetWorkBaseFragment<ShopInfoDescBean> {
    private String id;
    private String title;
    @BindView(R.id.sc_root)
    CustomScrollView sc_root;
    @BindView(R.id.tv_load)
    TextView tv_load;
    @BindView(R.id.ds_root)
    DragSwitchLayout ds_root;
    @BindView(R.id.wv_desc)
    FrameLayout wv_desc;
    @BindView(R.id.tv_desc)
    TextView tv_desc;
    @BindView(R.id.tv_shop)
    TextView tv_shop;
    @BindView(R.id.view_change)
    View view_change;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_collect)
    TextView tv_collect;
    @BindView(R.id.tv_page)
    TextView tv_page;
    @BindView(R.id.vp_content)
    ViewPager vp_content;
    @BindView(R.id.ll_price)
    LinearLayout ll_price;
    @BindView(R.id.tv_price)
    TextView tv_price;
    @BindView(R.id.tv_tips)
    TextView tv_tips;
    @BindView(R.id.tv_login_tips)
    TextView tv_login_tips;
    @BindView(R.id.tv_no_login_tips)
    TextView tv_no_login_tips;

    public static ShopInfoDescRootFragment getInstance(String id, String title) {
        ShopInfoDescRootFragment shopInfoDescRootFragment = new ShopInfoDescRootFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putString("title", title);
        shopInfoDescRootFragment.setArguments(bundle);
        return shopInfoDescRootFragment;
    }

    @Override
    protected String url() {
        return ApiConstant.INDEX;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "goods_if");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        map.put("goods_id", id);
        return super.map();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");
            title = bundle.getString("title");
        }
    }

    @OnClick(R.id.tv_collect)
    void collect() {
        initCollectRxBus();
        MyCollectController.getInstance().collect(id, new CollectRxbus(data.collect == 0 ? "add" : "cancel", -1));
    }

    @OnClick(R.id.tv_no_login_tips)
    void login() {
        RxBus.get().post("addFragment", new AddFragmentBean(new LoginFragment()));
    }

    private Observable<CollectRxbus> collect;

    private void initCollectRxBus() {
        if (collect == null) {
            collect = RxBus.get().register("collect", CollectRxbus.class);
            collect.subscribe(new Action1<CollectRxbus>() {
                @Override
                public void call(CollectRxbus rxbus) {
                    switch (rxbus.act) {
                        case "cancel":
                            data.collect = 0;
                            break;
                        case "add":
                            data.collect = 1;
                    }
                    initCollect();
                }
            });
        }
    }

    @Override
    protected Class<ShopInfoDescBean> getTClass() {
        return ShopInfoDescBean.class;
    }

    private boolean isFirst;

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_shop_info_desc_root, null);
        ButterKnife.bind(this, view);
        if (!TextUtils.isEmpty(title)) {
            tv_title.setText(title);
        }

        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) vp_content.getLayoutParams();
        layoutParams.height = Util.getWidth();
        vp_content.setLayoutParams(layoutParams);
        return view;
    }

    private void initScroll() {
        ds_root.setDragSwitchListener(new DragSwitchLayout.DragSwitchListener() {
            @Override
            public void onDragToBottomView() {
                if (!isFirst) {
                    isFirst = true;
                    getChildFragmentManager().beginTransaction().add(R.id.wv_desc, WebViewFragment.getInstance(data.h5_url, false)).commit();
                }
                changeTopView(1);
            }

            @Override
            public void onDragToTopView() {
                changeTopView(0);
            }
        });
    }

    private ShopInfoDescBean.Data data;

    @Override
    protected void writeData(boolean isWrite, ShopInfoDescBean bean) {
        super.writeData(isWrite, bean);
        this.data = bean.data;
        initBanner();
        initScroll();
        goodsInfo();
        initCollect();
    }

    /**
     * 初始化轮播图
     */
    private void initBanner() {

        final int count = data.gallery_arr.size();
        tv_page.setText("1/" + count);
        final ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fragments.add(ImageFragment.getInstance(data.gallery_arr.get(i)));
        }
        fragments.add(new ImageTextFragment());
        vp_content.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return count + 1;
            }
        });

        vp_content.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == fragments.size() - 1) {
                    goBottom();
                    vp_content.setCurrentItem(fragments.size() - 2);
                } else {
                    tv_page.setText((position + 1) + "/" + count);
                }
            }
        });
    }


    /**
     * 判断是否收藏
     */
    private void initCollect() {
        tv_collect.setCompoundDrawables(null, DrawableUtil.setBounds(getResources().getDrawable(data.collect == 1 ? R.mipmap.icon_detail_collected : R.mipmap.icon_detail_collect)), null, null);

    }

    /**
     * 商品信息
     */
    private void goodsInfo() {
        ShopInfoDescBean.Data.GoodsInfoBean goods_info = data.goods_info;
        tv_price.setText(goods_info.promote_price);
        tv_tips.setText(goods_info.goods_brief);
        if (data.is_login == 1) {
            ArrayList<ShopInfoDescBean.Data.UserRankPricesBean> user_rank_prices = data.user_rank_prices;
            for (int i = 0; i < user_rank_prices.size(); i++) {
                ShopInfoDescBean.Data.UserRankPricesBean userRankPricesBean = user_rank_prices.get(i);
                View view = View.inflate(getContext(), R.layout.item_shop_desc_price, null);
                TextView tv_price = (TextView) view.findViewById(R.id.tv_price);
                TextView tv_level = (TextView) view.findViewById(R.id.tv_level);
                tv_level.setText(userRankPricesBean.rank_name);
                tv_price.setText(userRankPricesBean.price);
                ll_price.addView(view);
            }
            ll_price.setVisibility(View.VISIBLE);
            tv_login_tips.setVisibility(View.VISIBLE);
            tv_no_login_tips.setVisibility(View.GONE);
        }
    }


    @OnClick(R.id.tv_shop)
    void goTop() {
        ds_root.showTop();
    }

    @OnClick(R.id.tv_desc)
    void goBottom() {
        ds_root.showBottom();
    }

    private ArrayList<String> urls = new ArrayList<>();

    @OnClick(R.id.tv_order)
    void order() {
        initPhotoRxBus();
        CanPhotoHelper.getInstance().gotoPhotoSelect(getActivity(), urls, 5);
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }

    @Override
    protected View getTitleBarView() {
        return new ShopDescTitleBarView(getContext());
    }

    @Override
    protected float top() {
        return 0;
    }

    private int currentType = 0;

    private void changeTopView(int type) {
        if (currentType == type) {
            return;
        }
        if (type == 0) {
            tv_shop.setTextColor(Color.parseColor("#f73f5f"));
            tv_desc.setTextColor(Color.parseColor("#a1a1a1"));
            ObjectAnimator.ofFloat(view_change, "translationX", view_change.getX(), 0).setDuration(300).start();
        } else {
            tv_desc.setTextColor(Color.parseColor("#f73f5f"));
            tv_shop.setTextColor(Color.parseColor("#a1a1a1"));
            ObjectAnimator.ofFloat(view_change, "translationX", view_change.getX(), tv_desc.getX() - tv_shop.getX()).setDuration(300).start();
        }
        currentType = type;
    }

    @Override
    protected ShowCurrentViewENUM getDefaultView() {
        return ShowCurrentViewENUM.VIEW_HAVE_DATA;
    }

    private Observable<PhotoRxbus> photoRxBus;

    private void initPhotoRxBus() {
        if (photoRxBus == null) {
            photoRxBus = RxBus.get().register("photoRxBus", PhotoRxbus.class);
            photoRxBus.subscribe(new Action1<PhotoRxbus>() {
                @Override
                public void call(PhotoRxbus photoRxbus) {
                    if (photoRxbus.index) {
                        urls.clear();
                        urls.addAll(((ArrayList<String>) photoRxbus.result));
                        for (String url : urls) {
                            Log.d("相册", url);
                        }
                    }
                }
            });
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (photoRxBus != null) {
            RxBus.get().unregister("photoRxBus", photoRxBus);
        }
        if (collect != null) {
            RxBus.get().unregister("collect", collect);
        }
    }

    @Override
    protected TipLoadingBean getTipLoadingBean() {
        return new TipLoadingBean();
    }
}
