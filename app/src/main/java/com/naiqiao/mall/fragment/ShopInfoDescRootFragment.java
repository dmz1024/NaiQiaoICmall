package com.naiqiao.mall.fragment;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.canyinghao.canphotos.CanPhotoHelper;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.CollectRxbus;
import com.naiqiao.mall.controller.MyCollectController;
import com.naiqiao.mall.view.ShopDescTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.bean.SingleBaseBean;
import base.bean.TipLoadingBean;
import base.bean.rxbus.PhotoRxbus;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import util.RxBus;
import view.CustomScrollView;
import view.DragSwitchLayout;

import static android.app.Activity.RESULT_OK;

/**
 * Created by dengmingzhi on 2016/12/26.
 */

public class ShopInfoDescRootFragment extends SingleNetWorkBaseFragment<SingleBaseBean> {
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
        return "http://www.ediancha.com/app.php";
    }

    @Override
    protected Map<String, String> map() {
        map.put("c", "chahui");
        map.put("a", "index");
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
        MyCollectController.getInstance().collect(id, new CollectRxbus("add", -1));
    }

    @Override
    protected Class<SingleBaseBean> getTClass() {
        return SingleBaseBean.class;
    }

    private boolean isFirst;

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_shop_info_desc_root, null);
        ButterKnife.bind(this, view);
        initScroll();
        if (!TextUtils.isEmpty(title)) {
            tv_title.setText(title);
        }
        return view;
    }

    private void initScroll() {
        ds_root.setDragSwitchListener(new DragSwitchLayout.DragSwitchListener() {
            @Override
            public void onDragToBottomView() {
                if (!isFirst) {
                    isFirst = true;
                    getChildFragmentManager().beginTransaction().add(R.id.wv_desc, new AddressFragment()).commit();
                }
                changeTopView(1);
            }

            @Override
            public void onDragToTopView() {
                changeTopView(0);
            }
        });
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
    }

    @Override
    protected TipLoadingBean getTipLoadingBean() {
        return new TipLoadingBean();
    }
}
