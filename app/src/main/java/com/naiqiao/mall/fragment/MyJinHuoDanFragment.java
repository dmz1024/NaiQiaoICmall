package com.naiqiao.mall.fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.MyJinHuoDanAdapter;
import com.naiqiao.mall.bean.MyJinHuoDanBean;
import com.naiqiao.mall.bean.SendCarBean;
import com.naiqiao.mall.bean.rxbus.CollectRxbus;
import com.naiqiao.mall.bean.rxbus.MyJHDRxBus;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import rx.Observable;
import rx.functions.Action1;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class MyJinHuoDanFragment extends ListNetWorkBaseFragment<MyJinHuoDanBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyJinHuoDanAdapter(getContext(), (ArrayList<MyJinHuoDanBean.Data>) totalList);
    }


    private Observable<MyJHDRxBus> myjhd;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (myjhd == null) {
            myjhd = RxBus.get().register("myjhd", MyJHDRxBus.class);
            myjhd.subscribe(new Action1<MyJHDRxBus>() {
                @Override
                public void call(MyJHDRxBus rxbus) {
                    ((ArrayList<MyJinHuoDanBean.Data>) totalList).get(rxbus.position).goods_number = rxbus.num;
                    if (rxbus.isSuccess) {
                        ((ArrayList<MyJinHuoDanBean.Data>) totalList).get(rxbus.position).subtotal = rxbus.total;
                    }
                    ((ArrayList<MyJinHuoDanBean.Data>) totalList).get(rxbus.position).isChange = true;
                    mAdapter.notifyItemChanged(rxbus.position);
                }
            });
        }
    }

    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected String url() {
        return ApiConstant.CART;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "cart_list");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    protected Class<MyJinHuoDanBean> getTClass() {
        return MyJinHuoDanBean.class;
    }


    @Override
    protected View getNoDataView() {
        View view = View.inflate(getContext(), R.layout.view_no_data_jin_huo_dan, null);
        TextView tv_guangguang = (TextView) view.findViewById(R.id.tv_guangguang);
        tv_guangguang.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tv_guangguang.getPaint().setAntiAlias(true);//抗锯齿
        return view;
    }
}
