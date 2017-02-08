package com.naiqiao.mall.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.controller.CodeController;

import base.bean.SingleBaseBean;
import interfaces.OnSingleRequestListener;

/**
 * Created by dengmingzhi on 2016/12/12.
 */

public class ViewSendCode extends LinearLayout {
    private EditText et_code;
    private Button bt_send;
    private TextView tv_tel;

    public ViewSendCode(Context context) {
        this(context, null);
    }

    public ViewSendCode(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private CountDownTimer timer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            bt_send.setText((millisUntilFinished / 1000) + "S重新发送");
        }

        @Override
        public void onFinish() {
            bt_send.setEnabled(true);
            bt_send.setText("发送验证码");
            bt_send.setBackgroundResource(R.drawable.shape_f73f5f_radius_3);
        }
    };

    private void initView(Context context) {
        View.inflate(context, R.layout.view_send_code, this);
        et_code = (EditText) findViewById(R.id.et_send_code_code);
        bt_send = (Button) findViewById(R.id.bt_send_code_send);
        tv_tel = (TextView) findViewById(R.id.tv_send_code_tel);
        bt_send.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                CodeController.getInstance().setContext(getContext()).setOnRequestListeren(new OnSingleRequestListener<SingleBaseBean>() {
                    @Override
                    public void succes(boolean isWrite, SingleBaseBean bean) {
                        timer.start();
                        bt_send.setEnabled(false);
                        bt_send.setBackgroundResource(R.drawable.shape_999_radius_3);
                    }

                    @Override
                    public void error(boolean isWrite, SingleBaseBean bean, String msg) {

                    }
                }).getCode(UserInfo.mobile, type);
            }
        });
    }

    private String type;

    public void setType(String type) {
        this.type = type;
    }


    public String getCode(){
        return et_code.getText().toString();
    }

}
