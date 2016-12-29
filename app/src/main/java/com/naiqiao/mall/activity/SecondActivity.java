package com.naiqiao.mall.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import com.canyinghao.canphotos.CanPhotoHelper;
import com.naiqiao.mall.R;
import com.naiqiao.mall.fragment.ShopInfoDescRootFragment;

import java.util.ArrayList;

import base.fragment.WebViewFragment;

public class SecondActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportFragmentManager().beginTransaction().add(R.id.fg_content, new WebViewFragment()).commit();
        findViewById(R.id.bt_test).setVisibility(View.GONE);
    }



}
