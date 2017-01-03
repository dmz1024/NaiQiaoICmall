package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.AddressAdapter;
import com.naiqiao.mall.adapter.YuJingZhiSetAdapter;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.MyJinHuoDanBean;
import com.naiqiao.mall.bean.YuJingZhiSetBean;
import com.naiqiao.mall.bean.rxbus.AddressRxBus;
import com.naiqiao.mall.bean.rxbus.MyJHDRxBus;
import com.naiqiao.mall.bean.rxbus.YuJingZhiRxBus;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import rx.Observable;
import rx.functions.Action1;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class YuJingZhiSetListFragment extends ListNetWorkBaseFragment<YuJingZhiSetBean> {

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new YuJingZhiSetAdapter(getContext(), (ArrayList<YuJingZhiSetBean.Data>) totalList);
    }

    private Observable<YuJingZhiRxBus> yjz;

    private void initRxBus() {
        if (yjz == null) {
            yjz = RxBus.get().register("yjz", YuJingZhiRxBus.class);
            yjz.subscribe(new Action1<YuJingZhiRxBus>() {
                @Override
                public void call(YuJingZhiRxBus rxbus) {
                    if (!rxbus.isAll) {
                        ArrayList<YuJingZhiSetBean.Data> totalList = (ArrayList<YuJingZhiSetBean.Data>) YuJingZhiSetListFragment.this.totalList;
                        totalList.get(rxbus.position).warn = rxbus.num;
                        totalList.get(rxbus.position).isChange = true;
                        mAdapter.notifyItemChanged(rxbus.position);
                    }
                }
            });
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRxBus();
    }

    @Override
    protected String url() {
        return ApiConstant.NEWSCENTER;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "notice_less_open");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }


    @Override
    protected Class<YuJingZhiSetBean> getTClass() {
        return YuJingZhiSetBean.class;
    }


    @Override
    protected View getTitleBarView() {
        return null;
    }


    public void setCountChange(int num) {
        if (mAdapter != null) {
            ArrayList<YuJingZhiSetBean.Data> totalList = (ArrayList<YuJingZhiSetBean.Data>) this.totalList;
            for (YuJingZhiSetBean.Data data : totalList) {
                data.warn = num;
            }
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("yjz", yjz);
    }
}
