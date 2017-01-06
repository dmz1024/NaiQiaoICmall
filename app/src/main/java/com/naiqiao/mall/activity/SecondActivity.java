package com.naiqiao.mall.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
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
//
        ImageView iv_img = (ImageView) findViewById(R.id.iv_img);
//        Glide.with(this).load(R.drawable.icon_loader).asGif().into(iv_img);
        Animation operatingAnim = AnimationUtils.loadAnimation(this, com.mall.naiqiao.mylibrary.R.anim.rotate);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);
        iv_img.setAnimation(operatingAnim);
    }


}
