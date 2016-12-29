package com.naiqiao.mall.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.WriteSendCarAdapter;
import com.naiqiao.mall.bean.SendCarBean;
import com.naiqiao.mall.view.pop.AffirmSendPopView;

import java.util.ArrayList;

import base.fragment.NotNetWorkBaseFragment;
import base.other.ItemDecoration;
import butterknife.BindView;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/12.
 */

public class WriteSendShopFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.rv_shop)
    RecyclerView rv_shop;

    @Override
    protected void initData() {
        creatShop();
    }

    private void creatShop() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        WriteSendCarAdapter mAdapter=new WriteSendCarAdapter(getContext(),data);
//        rv_shop.addItemDecoration(new ItemDecoration(getContext(),LinearLayoutManager.HORIZONTAL,1,"#e0e0e0"));
        rv_shop.setAdapter(mAdapter);
        rv_shop.setLayoutManager(manager);

    }

    @Override
    protected int getRId() {
        return R.layout.fragment_write_send_shop;
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.bt_pay)
    void pay(){
        new AffirmSendPopView(getContext()).showAtLocation(false);
    }


    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("填写发货单");
    }

    private ArrayList<SendCarBean.Data> data;

    public void setData(ArrayList<SendCarBean.Data> data) {
        this.data = data;
    }
}
