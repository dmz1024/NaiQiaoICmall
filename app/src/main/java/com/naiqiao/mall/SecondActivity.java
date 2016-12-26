package com.naiqiao.mall;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.naiqiao.mall.fragment.AffirmOrderFragment;
import com.naiqiao.mall.fragment.ShopInfoDescRootFragment;
import com.naiqiao.mall.fragment.index.FourFragment;

public class SecondActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportFragmentManager().beginTransaction().add(R.id.fg_content,new ShopInfoDescRootFragment()).commit();
        findViewById(R.id.bt_test).setVisibility(View.GONE);
    }

}
