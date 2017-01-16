package p.v.m.mywechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketException;
import de.tavendo.autobahn.WebSocketHandler;
import util.JsonUtil;
import util.SharedPreferenUtil;
import util.Util;

public class MainActivity extends AppCompatActivity {
    private final WebSocketConnection mConnection = new WebSocketConnection();
    private RecyclerView rv_content;
    private EditText et_content;
    private Button bt_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);
        initView();
        initCon();
    }

    private void initView() {
        rv_content = (RecyclerView) findViewById(R.id.rv_content);
        et_content = (EditText) findViewById(R.id.et_content);
        bt_send = (Button) findViewById(R.id.bt_send);
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = et_content.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    et_content.setText("");
                    sendContent(content);
                }
            }
        });
    }

    private ArrayList<SendBean> datas = new ArrayList<>();

    private void sendContent(String content) {
        SendBean send=new SendBean();
        send.content=content;

    }

    private void initCon() {
        final String wsuri = "ws://oa.east-profit.com:7272";

        try {
            mConnection.connect(wsuri, new WebSocketHandler() {

                @Override
                public void onOpen() {
                    SendBean login = new SendBean();
                    login.type = "login";
                    login.client_name = new SharedPreferenUtil(MainActivity.this, "login").getString("name");
                    login.room_id = "100";
                    mConnection.sendTextMessage(JsonUtil.javaBean2Json(login));
                }

                @Override
                public void onTextMessage(String payload) {
                    Log.d("onTextMessage", "Got echo: " + payload);
                    SendBean data = JsonUtil.json2Bean(payload, SendBean.class);
                    managerData(data);
                }

                @Override
                public void onClose(int code, String reason) {
                    initCon();
                }
            });
        } catch (WebSocketException e) {
            Log.d("WebSocketException", "Got echo: " + e.getMessage());
        }
    }

    private void managerData(SendBean data) {
        switch (data.type) {
            case "ping":
                break;
            case "login":
                new SharedPreferenUtil(this, "login").setData("id", data.client_id);

                break;
        }
    }
}
