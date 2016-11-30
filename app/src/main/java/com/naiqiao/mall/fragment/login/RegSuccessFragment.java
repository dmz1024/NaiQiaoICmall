package com.naiqiao.mall.fragment.login;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.fragment.WelComeFragment;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import view.Color2Text;

/**
 * Created by dengmingzhi on 2016/11/30.
 */

public class RegSuccessFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.tv_skip)
    TextView tv_skip;
    @BindView(R.id.tv_tip)
    TextView tv_tip;
    @BindView(R.id.bt_skip)
    Button bt_skip;
    private int time = 3;
    private ChangeRunnable skipRunnable = new ChangeRunnable();

    private class ChangeRunnable implements Runnable {

        @Override
        public void run() {
            time--;
            if (time <= 0) {
                tvSkip();
            } else {
                bt_skip.postDelayed(skipRunnable, 1000);
            }
            tv_tip.setText("即将跳转到申请加盟界面" + time + "s,   ");
        }
    }

    @Override
    protected void initData() {
        bt_skip.postDelayed(skipRunnable, 1000);
    }

    @Override
    protected int getRId() {
        return R.layout.fragment_reg_success;
    }

    @OnClick(R.id.tv_skip)
    void tvSkip() {
        bt_skip.removeCallbacks(skipRunnable);
        Log.d("跳转", "dddd");
    }

    @OnClick(R.id.bt_skip)
    void btSkip() {

    }
}
