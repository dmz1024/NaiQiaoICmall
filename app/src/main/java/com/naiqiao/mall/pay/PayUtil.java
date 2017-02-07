package com.naiqiao.mall.pay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.alipay.sdk.app.AuthTask;
import com.naiqiao.mall.activity.MainActivity;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;


import java.util.Map;

import base.bean.BaseBean;
import util.MyToast;


/**
 * Created by dengmingzhi on 2016/10/31.
 */

public class PayUtil {
    private Context ctx;

    public static PayUtil getInstance() {
        return new PayUtil();
    }

    public PayUtil setContext(Context ctx) {
        this.ctx = ctx;
        return this;
    }


    public void weChatPay(WechatInfo.Data data) {
        IWXAPI wxapi = WXAPIFactory.createWXAPI(ctx, "wx5054f38128ef0400", false);
        wxapi.registerApp("wx5054f38128ef0400");
        if (!wxapi.isWXAppInstalled()) {
            MyToast.showToast("请先下载微信客户端");
            return;
        }

        PayReq req = new PayReq();
        req.appId = "wx5054f38128ef0400";
        req.partnerId = data.partnerid;
        req.prepayId = data.prepayid;
        req.nonceStr = data.noncestr;
        req.timeStamp = data.timestamp;
        req.packageValue = "Sign=WXPay";
        req.sign = data.sign;
        req.extData = "app data"; // optional
        wxapi.sendReq(req);
    }
    public void aliPay(final String data) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 构造AuthTask 对象
                AuthTask authTask = new AuthTask(((Activity) ctx));
                // 调用授权接口，获取授权结果
                Map<String, String> result = authTask.authV2(data, true);
                Message msg = new Message();
                msg.what = 1;
                msg.obj = result;
                handler.sendMessage(msg);

            }
        }).start();


    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: {
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    String resultStatus = payResult.getResultStatus();
                    Intent intent = new Intent(ctx, MainActivity.class);
                    if (TextUtils.equals(resultStatus, "9000")) {
                        MyToast.showToast("支付成功");
                        intent.putExtra("pay_result", 0);
                    } else {
                        if (TextUtils.equals(resultStatus, "8000")) {
                            MyToast.showToast("系统处理中");
                        } else if (TextUtils.equals(resultStatus, "6001")) {
                            MyToast.showToast("用户取消");
                        } else if (TextUtils.equals(resultStatus, "6002")) {
                            MyToast.showToast("网络错误");
                        } else {
                            MyToast.showToast("支付失败");
                        }
                        intent.putExtra("pay_result", 1);

                    }
                    ctx.startActivity(intent);
                    break;
                }
            }
        }

    };

    public static class WechatInfo extends BaseBean<WechatInfo.Data> {
        public static class Data{
            public String appid;
            public String noncestr;
            public String partnerid;
            public String prepayid;
            public String sign;
            public String timestamp;
        }
    }
}
