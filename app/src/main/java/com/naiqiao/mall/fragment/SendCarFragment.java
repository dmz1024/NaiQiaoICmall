package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.SendCarAdapter;
import com.naiqiao.mall.bean.AllShopBean;
import com.naiqiao.mall.bean.SendCarBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.ListNetWorkBaseFragment;
import util.MyToast;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class SendCarFragment extends ListNetWorkBaseFragment<AllShopBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new SendCarAdapter(getContext(), (ArrayList<AllShopBean.Data>) totalList);
    }


    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected String url() {
        return ApiConstant.VIRTUAL;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "index");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    protected Class<AllShopBean> getTClass() {
        return AllShopBean.class;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }

    public void sendCar() {
        if (mAdapter != null && totalList.size() > 0) {
            ArrayList<AllShopBean.Data> datas = new ArrayList<>();
            for (AllShopBean.Data data : ((ArrayList<AllShopBean.Data>) totalList)) {
                if (data.currenTcount > 0) {
                    datas.add(data);
                }
            }
            if (datas.size() > 0) {
                RxBus.get().post("addFragment", new AddFragmentBean(SendMonadContentFragment.getInstance(datas)));
            } else {
                MyToast.showToast("请选择发货数量");
            }
        }
    }
}
