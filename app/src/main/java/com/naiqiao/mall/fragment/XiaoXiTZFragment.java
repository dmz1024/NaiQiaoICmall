package com.naiqiao.mall.fragment;

import android.view.View;
import android.widget.RelativeLayout;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.XiaoXiTZBean;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;

import java.util.List;
import java.util.Map;

import base.fragment.NetworkBaseFragment;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/12/2.
 */

public class XiaoXiTZFragment extends SingleNetWorkBaseFragment<XiaoXiTZBean> {
    @BindViews({R.id.rl_tzgg, R.id.rl_dhtz, R.id.rl_zxhd})
    List<RelativeLayout> rls;

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
    protected Class<XiaoXiTZBean> getTClass() {
        return XiaoXiTZBean.class;
    }

    @Override
    protected ShowCurrentViewENUM getDefaultView() {
        return ShowCurrentViewENUM.VIEW_HAVE_DATA;
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_xiao_xi_tz, null);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick({R.id.rl_tzgg, R.id.rl_dhtz, R.id.rl_zxhd})
    void rlOnClick(View view) {
        switch (view.getId()) {
            case R.id.rl_tzgg:
                RxBus.get().post("addFragment", new AddFragmentBean(new TongzhiGGFragment()));
                break;
            case R.id.rl_dhtz:
                RxBus.get().post("addFragment", new AddFragmentBean(new DaoHuoTZFragment()));
                break;
        }
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }
}
