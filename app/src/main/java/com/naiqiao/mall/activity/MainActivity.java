package com.naiqiao.mall.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.fragment.WelComeFragment;
import com.naiqiao.mall.fragment.index.IndexFragment;

import base.activity.BaseActivity;
import rx.Observable;
import rx.functions.Action1;
import util.RxBus;

public class MainActivity extends BaseActivity {
    Observable<AddFragmentBean> addFragmentRxBus;
    Observable<String> changeBarColorRxBus;
    private View barView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setShowBar(barView = findViewById(R.id.fg_bar));
            initChangeBarColor();
        }
        initFragmentRxBus();

        sendFragment();

    }

    private void initChangeBarColor() {
        changeBarColorRxBus = RxBus.get().register("changeBarColor", String.class);
        changeBarColorRxBus.subscribe(new Action1<String>() {
            @Override
            public void call(String color) {
                barView.setBackgroundColor(Color.parseColor(color));
            }
        });
    }

    private void sendFragment() {
        AddFragmentBean addFragmentBean = new AddFragmentBean(new IndexFragment());
        addFragmentBean.setAddBack(true);
        addFragmentBean.setHaveAnima(true);
        RxBus.get().post("addFragment", addFragmentBean);


    }

    private void initFragmentRxBus() {
        addFragmentRxBus = RxBus.get().register("addFragment", AddFragmentBean.class);
        addFragmentRxBus.subscribe(new Action1<AddFragmentBean>() {
            @Override
            public void call(AddFragmentBean bean) {
                replace(bean);
            }
        });
    }


    private void replace(AddFragmentBean bean) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (!bean.isHaveAnima()) {
            fragmentTransaction.setCustomAnimations(bean.getInAnimation(), bean.getOutAnimation(), bean.getInAnimation(), bean.getOutAnimation());
        }
        if (!bean.isAddBack()) {
            fragmentTransaction.addToBackStack(bean.getBackName());
        }
        fragmentTransaction.add(R.id.fg_base, bean.getFragment(), bean.getBackName()).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("addFragment", addFragmentRxBus);
        RxBus.get().unregister("changeBarColor", changeBarColorRxBus);
    }


}
