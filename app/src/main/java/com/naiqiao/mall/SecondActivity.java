package com.naiqiao.mall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import util.Util;
import view.GmRefreshLayout;


public class SecondActivity extends AppCompatActivity {
    private GmRefreshLayout gm_content;
    private TextView tv_content;
    private TextView tv_head;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}
