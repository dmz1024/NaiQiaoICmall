package com.naiqiao.mall;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.naiqiao.mall.fragment.AffirmOrderFragment;

public class SecondActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportFragmentManager().beginTransaction().add(R.id.fg_content, new AffirmOrderFragment()).commit();
    }

}
