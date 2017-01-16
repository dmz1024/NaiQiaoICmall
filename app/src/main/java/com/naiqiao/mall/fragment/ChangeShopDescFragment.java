package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.AddressAdapter;
import com.naiqiao.mall.adapter.ChangeShopDescAdapter;
import com.naiqiao.mall.bean.AddressBean;
import com.naiqiao.mall.bean.ChangeShopBean;
import com.naiqiao.mall.bean.ChangeShopDescBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class ChangeShopDescFragment extends ListNetWorkBaseFragment<ChangeShopDescBean> {
    private String id;

    public static ChangeShopDescFragment getInstance(String id) {
        ChangeShopDescFragment fragment = new ChangeShopDescFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            id = bundle.getString("id");
        }
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new ChangeShopDescAdapter(getContext(), (ArrayList<ChangeShopDescBean.Data>) totalList);
    }


    @Override
    protected String url() {
        return ApiConstant.EXGOODS;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "change_detail");
        map.put("back_id", id);
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    protected Class<ChangeShopDescBean> getTClass() {
        return ChangeShopDescBean.class;
    }


    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }

    @Override
    protected boolean getLoadMore() {
        return false;
    }

    @Override
    protected void writeData(boolean isWrite, ChangeShopDescBean bean) {
        super.writeData(isWrite, bean);
        if (onDataReturnListener != null) {
            onDataReturnListener.data(bean.info);
        }
    }

    private OnDataReturnListener onDataReturnListener;

    public void setOnDataReturnListener(OnDataReturnListener onDataReturnListener) {
        this.onDataReturnListener = onDataReturnListener;
    }

    public interface OnDataReturnListener {
        void data(ChangeShopDescBean.InfoBean info);
    }
}
