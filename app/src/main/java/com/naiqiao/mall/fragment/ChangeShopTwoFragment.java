package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.ChooseChangeShopOneAdapter;
import com.naiqiao.mall.adapter.ChooseChangeShopTwoAdapter;
import com.naiqiao.mall.bean.ChangeShopBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;
import util.MyToast;
import util.SharedPreferenUtil;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class ChangeShopTwoFragment extends ListNetWorkBaseFragment<ChangeShopBean> {

    @Override
    protected RecyclerView.Adapter getAdapter() {
        ChooseChangeShopTwoAdapter adapter = new ChooseChangeShopTwoAdapter(getContext(), (ArrayList<ChangeShopBean.Data>) totalList) {
            @Override
            public void choose() {
                double price = 0;
                boolean isChoose = true;
                ArrayList<ChangeShopBean.Data> totalList = (ArrayList<ChangeShopBean.Data>) ChangeShopTwoFragment.this.totalList;
                for (ChangeShopBean.Data data : totalList) {
                    if (data.isChoose) {
                        price += data.goods_price * data.count;
                    } else {
                        isChoose = false;
                    }
                }
                ((ChangeShopTwoContentFragment) getParentFragment()).setChoose(isChoose, price);
            }
        };
        return adapter;
    }


    @Override
    protected String url() {
        return ApiConstant.EXGOODS;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "change_two");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    protected Class<ChangeShopBean> getTClass() {
        return ChangeShopBean.class;
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
    protected View getNoDataView() {
        View view = View.inflate(getContext(), R.layout.view_no_data_change_shop, null);
        return view;
    }

    public boolean saveChange() {
        if (mAdapter != null) {
            ArrayList<ChangeShopBean.Data> totalList = (ArrayList<ChangeShopBean.Data>) this.totalList;
            StringBuffer oneStr = new StringBuffer();
            int chooseCount = 0;
            double price = 0;
            for (ChangeShopBean.Data data : totalList) {
                if (data.isChoose && data.count > 0) {
                    oneStr.append(data.goods_id).append("|").append(data.count);
                    chooseCount += data.count;
                    price += data.goods_price * data.count;
                    oneStr.append(",");
                }
            }
            if (TextUtils.isEmpty(oneStr.toString())) {
                MyToast.showToast("请选择进货商品");
                return false;
            }
            Log.d("进货", oneStr.substring(0,oneStr.length()-1));

            new SharedPreferenUtil(getContext(), "changeGoods").setData(new String[]{"two", oneStr.substring(0,oneStr.length()-1), "two_price", price + "", "two_count", chooseCount + ""});
            return true;
        }
        return false;
    }


    public double choose(boolean isChoose) {
        if (mAdapter == null) {
            return -1;
        }
        double price = 0;
        ArrayList<ChangeShopBean.Data> totalList = (ArrayList<ChangeShopBean.Data>) this.totalList;
        for (ChangeShopBean.Data data : totalList) {
            data.isChoose = isChoose;
            if (data.isChoose) {
                price += data.goods_price * data.count;
            }
        }
        mAdapter.notifyDataSetChanged();
        return price;
    }

}
