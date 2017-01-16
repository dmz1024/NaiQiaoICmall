package com.naiqiao.mall.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.canyinghao.canphotos.CanPhotoHelper;
import com.naiqiao.mall.R;
import com.naiqiao.mall.fragment.ShopInfoDescRootFragment;

import java.util.ArrayList;

import base.fragment.WebViewFragment;
import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketException;
import de.tavendo.autobahn.WebSocketHandler;

public class SecondActivity extends FragmentActivity {
    private EditText ip;
    private EditText name;
    private EditText content;
    private Button lianjie;
    private Button send;
    private final WebSocketConnection mConnection = new WebSocketConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ip = (EditText) findViewById(R.id.ip);
        name = (EditText) findViewById(R.id.name);
        content = (EditText) findViewById(R.id.content);
        lianjie = (Button) findViewById(R.id.lianjie);
        send = (Button) findViewById(R.id.send);


        lianjie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String wsuri = "ws://oa.east-profit.com:7272";

                try {
                    mConnection.connect(wsuri, new WebSocketHandler() {

                        @Override
                        public void onOpen() {
                            mConnection.sendTextMessage("{\"type\":\"login\",\"client_name\":\"杨工吊小\",\"room_id\":\"3\"}");
                        }

                        @Override
                        public void onTextMessage(String payload) {
                            Log.d("onTextMessage", "Got echo: " + payload);
                        }

                        @Override
                        public void onClose(int code, String reason) {
                            Log.d("onClose", "Connection lost." + reason);
                        }
                    });
                } catch (WebSocketException e) {
                    Log.d("WebSocketException", "Got echo: " + e.getMessage());
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String say = content.getText().toString();
                String id = name.getText().toString();
                mConnection.sendTextMessage("{\"type\":\"say\",\"from_client_id\":\"" + id + "\",\"from_client_name\":\"\\u6768\\u5de5\\u540a\\u5c0f\",\"to_client_id\":\"all\",\"content\":\"" + say + "\",\"time\":\"2017-01-11 16:18:19\"}");
            }
        });
    }


}
