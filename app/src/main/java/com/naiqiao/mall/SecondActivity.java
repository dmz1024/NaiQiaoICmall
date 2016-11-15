package com.naiqiao.mall;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import api.ApiRequest;
import base.TipLoadingBean;
import interfaces.OnRequestListeren;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ApiRequest<User>() {
                    @Override
                    protected Map<String, String> getMap() {
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("c", "area");
                        map.put("a", "index");
                        return map;
                    }

                    @Override
                    protected boolean getShouldCache() {
                        return true;
                    }

                    @Override
                    protected boolean getWriteCache() {
                        return true;
                    }

                    @Override
                    protected boolean getShowSucces() {
                        return false;
                    }

                    @Override
                    protected String getUrl() {
                        return "http://www.ediancha.com/app.php";
                    }

                    @Override
                    protected Context getContext() {
                        return SecondActivity.this;
                    }

                    @Override
                    protected Class<User> getClx() {
                        return User.class;
                    }
                }.setOnRequestListeren(new OnRequestListeren<List<User.Data>>() {
                    @Override
                    public void succes(List<User.Data> bean) {
                        for (int i = 0; i < bean.size(); i++) {
                            Log.d("城市", bean.get(i).name);
                        }
                    }

                    @Override
                    public void error(String msg) {

                    }
                }).creatRequestGet(new TipLoadingBean());
            }
        });


    }

}
