package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.YuJingZhiSetBean;
import com.naiqiao.mall.bean.rxbus.YuJingZhiRxBus;
import com.naiqiao.mall.controller.YuJingZhiController;
import com.naiqiao.mall.view.RightImageTitleBarView;
import com.naiqiao.mall.view.pop.PopEdit;

import java.util.ArrayList;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/12/8.
 */

public class YuJingZhiSetContentFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.tv_count)
    TextView tv_count;

    @Override
    protected void initData() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, fragment = new YuJingZhiSetListFragment()).commit();
    }


    private YuJingZhiSetListFragment fragment;

    @Override
    protected int getRId() {
        return R.layout.fragment_yujingzhi_set_content;
    }

    @Override
    protected View getTitleBarView() {
        return new RightImageTitleBarView(getContext());
    }

    @Override
    protected void initTitleView() {
        ((RightImageTitleBarView) getTitleBar()).setTitleContent("预警值设置");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRxBus();
    }

    private int count = 10;

    @OnClick(R.id.tv_count)
    void count() {
        count = Integer.parseInt(tv_count.getText().toString());
        new PopEdit(getContext(), false, tv_count.getText().toString()) {
            @Override
            protected void content(String content) {
                tv_count.setText(content);
                YuJingZhiController.getInstance().changeNum(new YuJingZhiRxBus(Integer.parseInt(content), count));
            }
        }.showAtLocation(false);
    }


    private Observable<YuJingZhiRxBus> yjz;

    private void initRxBus() {
        if (yjz == null) {
            yjz = RxBus.get().register("yjz", YuJingZhiRxBus.class);
            yjz.subscribe(new Action1<YuJingZhiRxBus>() {
                @Override
                public void call(YuJingZhiRxBus rxbus) {
                    if (rxbus.isAll) {
                        if (fragment != null) {
                            tv_count.setText(rxbus.num + "");
                            fragment.setCountChange(rxbus.num);
                        }
                    }
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("yjz",yjz);
    }
}
