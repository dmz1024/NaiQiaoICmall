package com.naiqiao.mall;

import android.os.Bundle;

import com.naiqiao.mall.fragment.ChangeShopContentFragment;
import com.naiqiao.mall.fragment.ChangeShopRootFragment;

import base.activity.BaseActivity;


public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportFragmentManager().beginTransaction().add(R.id.fg_content, new ChangeShopRootFragment()).commit();

    }


}
