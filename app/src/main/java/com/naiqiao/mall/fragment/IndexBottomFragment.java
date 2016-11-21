package com.naiqiao.mall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class IndexBottomFragment extends Fragment {
    @BindViews({R.id.frame_one, R.id.frame_two, R.id.frame_three, R.id.frame_four})
    List<FrameLayout> frams;
    @BindViews({R.id.iv_one, R.id.iv_two, R.id.iv_three, R.id.iv_four, R.id.iv_center})
    List<ImageView> ivs;
    @BindViews({R.id.tv_one, R.id.tv_two, R.id.tv_three, R.id.tv_four, R.id.tv_center})
    List<TextView> tvs;
    @BindView(R.id.rv_center)
    RelativeLayout rv_center;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_index_bottom, null);
        ButterKnife.bind(this, view);
        tvs.get(0).setText("你好");
        return view;
    }

    @OnClick({R.id.frame_one, R.id.frame_two, R.id.frame_three, R.id.frame_four, R.id.rv_center})
    void chooseView(View view) {
        Log.d("ddd", "订单");
    }

}
