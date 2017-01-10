package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.ChooseChangeShopOneAdapter;
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

public class ChangeShopOneFragment extends ListNetWorkBaseFragment<ChangeShopBean> implements ChooseChangeShopOneAdapter.OnChangeShopChooseListener {

    @Override
    protected RecyclerView.Adapter getAdapter() {
        ChooseChangeShopOneAdapter adapter = new ChooseChangeShopOneAdapter(getContext(), (ArrayList<ChangeShopBean.Data>) totalList) {
            @Override
            public void choose() {
                boolean choose = true;
                ArrayList<ChangeShopBean.Data> totalList = (ArrayList<ChangeShopBean.Data>) ChangeShopOneFragment.this.totalList;
                exit:
                for (ChangeShopBean.Data data : totalList) {
                    if (!data.isChoose) {
                        choose = false;
                        break exit;
                    }
                }
                ((ChangeShopOneContentFragment) getParentFragment()).setChoose(choose);
            }
        };
        adapter.setOnChangeShopChooseListener(this);
        return adapter;
    }


    @Override
    protected String url() {
        return ApiConstant.EXGOODS;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "change_one");
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
                MyToast.showToast("请选择换货商品");
                return false;
            }
            Log.d("换货", oneStr.substring(0,oneStr.length()-1));
            new SharedPreferenUtil(getContext(), "changeGoods").setData(new String[]{"one", oneStr.substring(0,oneStr.length()-1), "one_price", price + "", "one_count", chooseCount + ""});
            return true;
        }

        return false;
    }


    public boolean choose(boolean choose) {
        if (mAdapter == null && totalList.size() > 0 && canChoosePrice != -1) {
            return false;
        }
        ArrayList<ChangeShopBean.Data> totalList = (ArrayList<ChangeShopBean.Data>) this.totalList;
        boolean isChoose;
        double price = 0;
        for (ChangeShopBean.Data data : totalList) {
            if (choose) {
                price += data.goods_price * data.count;
                if (price > canChoosePrice) {
                    MyToast.showToast("换货商品总金额大于可选金额");
                    Log.d("ddd", "ddd");
                    return false;
                }
            }
            data.isChoose = choose;
        }
        mAdapter.notifyDataSetChanged();
        return true;
    }


    private double canChoosePrice = -1;

    private ChangeShopBean bean;

    @Override
    protected void writeData(boolean isWrite, ChangeShopBean bean) {
        super.writeData(isWrite, bean);
        this.bean = bean;
        canChoosePrice = bean.info.stockprice;
    }

    @Override
    public boolean isChoose() {
        double price = 0;
        ArrayList<ChangeShopBean.Data> totalList = (ArrayList<ChangeShopBean.Data>) this.totalList;
        for (ChangeShopBean.Data data : totalList) {
            if (data.isChoose) {
                price += data.goods_price * data.count;
                if (price > canChoosePrice) {
                    MyToast.showToast("换货商品总金额大于可选金额");
                    return false;
                }
            }
        }
        return true;
    }
}
