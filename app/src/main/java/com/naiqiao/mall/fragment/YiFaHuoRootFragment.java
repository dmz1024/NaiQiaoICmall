package com.naiqiao.mall.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;
import base.bean.rxbus.AddFragmentBean;

import java.util.List;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import util.DrawableUtil;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/12/7.
 */

public class YiFaHuoRootFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.tv_choose)
    TextView tv_choose;
    @BindViews({R.id.bt_left, R.id.bt_right})
    List<Button> bts;

    private boolean isChoose;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, new YiFaHuoContentFragment()).commit();
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_yifahuo_root;
    }

    @OnClick(R.id.tv_choose)
    void choose() {
        tv_choose.setCompoundDrawables(DrawableUtil.setBounds(getResources().getDrawable((isChoose = !isChoose) ? R.mipmap.icon_achecked : R.mipmap.icon_acheck)), null, null, null);
    }


    @Override
    protected View getTitleBarView() {
        return null;
    }

    @OnClick({R.id.bt_left, R.id.bt_right})
    void btOnClick(View view) {
        RxBus.get().post("addFragment", new AddFragmentBean(new PayFragment()));
    }
}
