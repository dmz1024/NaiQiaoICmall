package com.naiqiao.mall.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.SecondActivity;

import java.util.List;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class IndexBottomFragment extends NotNetWorkBaseFragment {
    @BindViews({R.id.frame_one, R.id.frame_two, R.id.frame_three, R.id.frame_four})
    List<FrameLayout> frams;
    @BindViews({R.id.iv_one, R.id.iv_two, R.id.iv_three, R.id.iv_four, R.id.iv_center})
    List<ImageView> ivs;
    @BindViews({R.id.tv_one, R.id.tv_two, R.id.tv_three, R.id.tv_four, R.id.tv_center})
    List<TextView> tvs;
    @BindView(R.id.rv_center)
    RelativeLayout rv_center;


    @Override
    protected int getRId() {
        return R.layout.fragment_index_bottom;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.frame_one, R.id.frame_two, R.id.frame_three, R.id.frame_four, R.id.rv_center})
    void chooseView(View view) {
        int position = 0;
        switch (view.getId()) {
            case R.id.frame_one:
                position = 0;
                break;
            case R.id.frame_two:
                position = 1;
                break;
            case R.id.frame_three:
                position = 2;
                break;
            case R.id.frame_four:
                position = 3;
                break;
            case R.id.rv_center:
                startActivity(new Intent(getContext(), SecondActivity.class));
                return;
        }

        RxBus.get().post("indexBottomTabChange", position);

    }


    @Override
    protected View getTitleBarView() {
        return null;
    }


    @Override
    protected String getBackColor() {
        return "#00000000";
    }
}
