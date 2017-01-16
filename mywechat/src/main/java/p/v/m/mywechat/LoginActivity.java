package p.v.m.mywechat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;

import base.activity.BaseActivity;
import util.ContextUtil;
import util.MyToast;
import util.SharedPreferenUtil;
import util.WindowUtil;

public class LoginActivity extends AppCompatActivity {
    private EditText et_name;
    private EditText et_password;
    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);//防止编辑框被键盘遮住
        setContentView(R.layout.activity_login);
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = ContextUtil.getAct().getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        et_name= (EditText) findViewById(R.id.et_name);
        et_password= (EditText) findViewById(R.id.et_password);
        bt_login= (Button) findViewById(R.id.bt_login);
        String name = new SharedPreferenUtil(this, "login").getString("name");
        if (!TextUtils.isEmpty(name)) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        } else {
            bt_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = et_name.getText().toString();
                    String password = et_password.getText().toString();
                    if ((TextUtils.equals(name, "18326167257") && TextUtils.equals(password, "dmz520xlp***")) || (TextUtils.equals(name, "15209892049") && TextUtils.equals(password, "xlp520dmz"))) {
                        if(TextUtils.equals("15209892049",name)){
                            new SharedPreferenUtil(LoginActivity.this, "login").setData("name", "萍萍大人");
                        }else {
                            new SharedPreferenUtil(LoginActivity.this, "login").setData("name", "邓如果");
                        }
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        MyToast.showToast(LoginActivity.this,"账号或密码错误");
                    }
                }
            });
        }


    }

}
