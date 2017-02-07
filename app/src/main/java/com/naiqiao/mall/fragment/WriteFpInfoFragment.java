package com.naiqiao.mall.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import util.RxBus;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2017/2/5.
 */

public class WriteFpInfoFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.tv_pu)
    TextView tv_pu;
    @BindView(R.id.tv_zhuan)
    TextView tv_zhuan;
    WriteFpInfoPuFragment puFragment;
    WriteFpInfoZhuanFragment zhuanFragment;

    @Override
    protected void initData() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, puFragment = new WriteFpInfoPuFragment()).commit();
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_write_fp_info;
    }

    @Override
    protected void initTitleView() {
        ((DefaultTitleBarView) getTitleBar()).setTitleContent("发票信息修改");
    }

    private boolean payType;

    @OnClick({R.id.tv_pu, R.id.tv_zhuan})
    void payType(View view) {
        if (view.getId() == R.id.tv_pu && payType) {
            payType = false;
        } else if (view.getId() == R.id.tv_zhuan && !payType) {
            payType = true;
        } else {
            return;
        }
        tv_pu.setTextColor(Color.parseColor(payType ? "#999999" : "#f73f5f"));
        tv_zhuan.setTextColor(Color.parseColor(payType ? "#f73f5f" : "#999999"));
        tv_pu.setBackgroundResource(payType ? R.drawable.shape_fff_b2b2b2_ra : R.drawable.shape_fff_f73f5f_ra);
        tv_zhuan.setBackgroundResource(payType ? R.drawable.shape_fff_f73f5f_ra : R.drawable.shape_fff_b2b2b2_ra);
        if (payType && zhuanFragment == null) {
            getChildFragmentManager().beginTransaction().add(R.id.fg_content, zhuanFragment = new WriteFpInfoZhuanFragment()).commit();
        }
        getChildFragmentManager().beginTransaction().show(payType ? zhuanFragment : puFragment).commit();
        getChildFragmentManager().beginTransaction().hide(!payType ? zhuanFragment : puFragment).commit();

    }

    @OnClick(R.id.tv_affirm)
    void affirm() {
        String contents = payType ? zhuanFragment.getInfo() : puFragment.getInfo();
        if(contents!=null){
            RxBus.get().post("fpInfoRxBus",contents);
            RxBus.get().post("back","back");
        }
    }
}
