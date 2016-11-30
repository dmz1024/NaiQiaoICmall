package com.naiqiao.mall.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naiqiao.mall.adapter.SendCarAdapter;
import com.naiqiao.mall.bean.SendCarBean;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class SendCarFragment extends ListNetWorkBaseFragment<SendCarBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new SendCarAdapter(getContext(), (ArrayList<SendCarBean.Data>) totalList);
    }


    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected String url() {
        return "http://www.ediancha.com/app.php";
    }

    @Override
    protected Map<String, String> map() {
        map.put("c", "chahui");
        map.put("a", "index");
        map.put("type", "1");
        return super.map();
    }

    @Override
    protected Class<SendCarBean> getTClass() {
        return SendCarBean.class;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }

}
