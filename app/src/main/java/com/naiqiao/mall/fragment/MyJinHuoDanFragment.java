package com.naiqiao.mall.fragment;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.MyJinHuoDanAdapter;
import com.naiqiao.mall.bean.MyJinHuoDanBean;
import com.naiqiao.mall.bean.SendCarBean;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/23.
 */

public class MyJinHuoDanFragment extends ListNetWorkBaseFragment<MyJinHuoDanBean> {
    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new MyJinHuoDanAdapter(getContext(), (ArrayList<MyJinHuoDanBean.Data>) totalList);
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
    protected Class<MyJinHuoDanBean> getTClass() {
        return MyJinHuoDanBean.class;
    }


    @Override
    protected View getNoDataView() {
        View view = View.inflate(getContext(), R.layout.view_no_data_jin_huo_dan, null);
        TextView tv_guangguang= (TextView) view.findViewById(R.id.tv_guangguang);
        tv_guangguang.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tv_guangguang.getPaint().setAntiAlias(true);//抗锯齿
        return view;
    }
}
