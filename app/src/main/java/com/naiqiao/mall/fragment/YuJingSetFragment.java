package com.naiqiao.mall.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.YuJingSerBean;

import java.util.Map;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.NetworkBaseFragment;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import util.RxBus;
import view.SwitchButton;

/**
 * Created by dengmingzhi on 2017/1/3.
 */

public class YuJingSetFragment extends SingleNetWorkBaseFragment<YuJingSerBean> {
    @BindView(R.id.view_swich)
    SwitchButton view_swich;
    @BindView(R.id.ll_set)
    LinearLayout ll_set;

    @Override
    protected String url() {
        return "http://www.ediancha.com/app.php";
    }

    @Override
    protected Map<String, String> map() {
        map.put("c", "chahui");
        map.put("a", "index");
        return super.map();
    }

    @Override
    protected Class<YuJingSerBean> getTClass() {
        return YuJingSerBean.class;
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_yujing_set, null);
        ButterKnife.bind(this, view);
        view_swich.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton v, boolean isOn) {
                ll_set.setVisibility(isOn ? View.VISIBLE : View.GONE);
            }
        });
        return view;
    }

    @OnClick(R.id.ll_set)
    void setYJ() {
        RxBus.get().post("addFragment",new AddFragmentBean(new YuJingZhiSetContentFragment()));
    }

    @Override
    protected ShowCurrentViewENUM getDefaultView() {
        return ShowCurrentViewENUM.VIEW_HAVE_DATA;
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }
}
