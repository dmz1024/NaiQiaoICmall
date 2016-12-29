package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.MyCollectAdapter;
import com.naiqiao.mall.bean.MyCollectBean;
import com.naiqiao.mall.bean.rxbus.CollectRxbus;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.view.RightImageTitleBarView;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import interfaces.OnTitleBarListener;
import rx.Observable;
import rx.functions.Action1;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class MyCollectFragment extends ListNetWorkBaseFragment<MyCollectBean> implements OnTitleBarListener {
    public boolean isVertical = true;

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyCollectAdapter(getContext(), (ArrayList<MyCollectBean.Data>) totalList);
    }


    @Override
    protected View getTitleBarView() {
        return new RightImageTitleBarView(getContext());
    }

    @Override
    protected String url() {
        return ApiConstant.SHOUCANG;
    }


    private Observable<CollectRxbus> collect;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (collect == null) {
            collect = RxBus.get().register("collect", CollectRxbus.class);
            collect.subscribe(new Action1<CollectRxbus>() {
                @Override
                public void call(CollectRxbus rxbus) {
                    switch (rxbus.act) {
                        case "cancel":
                            if (mAdapter != null && rxbus.position >= 0) {
                                mAdapter.remove(rxbus.position);
                            }
                            break;
                    }

                }
            });
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("collect", collect);
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "collect");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    protected Class<MyCollectBean> getTClass() {
        return MyCollectBean.class;
    }

//    @Override
//    protected LinearLayoutManager getLayoutManager() {
//        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
//        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return isVertical ? 2 : 1;
//            }
//        });
//        return layoutManager;
//    }

    private RightImageTitleBarView titleBarView;

    @Override
    protected void initTitleView() {
        titleBarView = (RightImageTitleBarView) getTitleBar();
        titleBarView.setOnTitleBarListener(this).setTitleContent("我的收藏");
    }


    @Override
    public void left() {

    }

    /**
     * 切换视图
     */
    @Override
    public void right() {
        if (mAdapter == null) {
            return;
        }
        titleBarView.setRightImage((isVertical = !isVertical) ? R.mipmap.icon_display_list : R.mipmap.icon_display_block);
        ((MyCollectAdapter) mAdapter).setVertical(isVertical ? 1 : 2);
        int firstVisiItem = layoutManager.findFirstVisibleItemPosition();
        recyclerView.setLayoutManager(layoutManager = (isVertical ? new LinearLayoutManager(getContext()) : new GridLayoutManager(getContext(), 2)));
        mAdapter.notifyDataSetChanged();
        layoutManager.scrollToPosition(firstVisiItem);
    }

    @Override
    public void center() {

    }

}
