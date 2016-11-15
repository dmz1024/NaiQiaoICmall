package api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Response;

import java.util.HashMap;
import java.util.Map;

import base.BaseBean;
import base.TipLoadingBean;
import interfaces.OnControlListeren;
import interfaces.OnMyResponseListener;
import interfaces.OnRequestListeren;
import util.FileUtil;
import util.JLogUtils;
import util.JsonUtil;
import util.Util;
import view.pop.TipLoading;

/**
 * Created by dengmingzhi on 2016/11/15.
 */

public abstract class ApiRequest<T extends BaseBean> {

    protected abstract Map<String, String> getMap();

    protected abstract String getUrl();

    protected abstract Class<T> getClx();

    protected Context getContext() {
        return null;
    }

    protected boolean getShowInfo() {
        return true;
    }

    protected boolean getShowSucces() {
        return true;
    }

    protected boolean getShouldCache() {
        return false;
    }

    protected boolean getWriteCache() {
        return false;
    }

    public ApiRequest creatRequestGet() {
        JavaBeanRequest<T> request = new JavaBeanRequest<>(getUrl(), getClx());
        creatRequest(request, null);
        return this;
    }

    public ApiRequest creatRequestGet(TipLoadingBean tip) {
        JavaBeanRequest<T> request = new JavaBeanRequest<>(getUrl(), getClx());
        creatRequest(request, tip);
        return this;
    }

    public ApiRequest creatRequestPost() {
        JavaBeanRequest<T> request = new JavaBeanRequest<>(getUrl(), RequestMethod.POST, getClx());
        creatRequest(request, null);
        return this;
    }

    public ApiRequest creatRequestPost(TipLoadingBean tip) {
        JavaBeanRequest<T> request = new JavaBeanRequest<>(getUrl(), RequestMethod.POST, getClx());
        creatRequest(request, tip);
        return this;
    }


    protected int getTime() {
        return 500;
    }

    private void creatRequest(final JavaBeanRequest<T> request, final TipLoadingBean tip) {
        TipLoading tipLoading = null;
        if (tip != null) {
            tipLoading = getLoading();
            tipLoading.showAtLocation(false);
            tipLoading.setLoadingContent(tip.getLoading());
        }


        final TipLoading finalTipLoading = tipLoading;
        if (getTime() == 0 || tipLoading == null) {
            request(request, tip, finalTipLoading);
        } else {
            tipLoading.view().postDelayed(new Runnable() {
                @Override
                public void run() {
                    request(request, tip, finalTipLoading);
                }
            }, getTime());
        }

    }

    private void request(JavaBeanRequest<T> request, final TipLoadingBean tip, final TipLoading finalTipLoading) {
        Map<String, String> map = getMap();
        if (map != null) {
            request.add(map);
        }
        String url = Util.getUrl(map, getUrl());
        Log.d("请求网址", url);
        if (getWriteCache()) {
            String json = FileUtil.getDataFromNative(url);
            if (!TextUtils.isEmpty(json)) {
                result(true, finalTipLoading, tip, JsonUtil.json2Bean(json, getClx()));
            }
        }
        saveCache(request, url);

        CallServer.getInstance().add(1, request, new OnMyResponseListener<T>() {
            @Override
            protected void onSucceed(Response<T> response) {
                result(false, finalTipLoading, tip, response.get());
            }

            @Override
            protected void onFailed(Response<T> response) {
                JLogUtils.D("请求数据错误" + response.getException().getMessage());
                if (finalTipLoading != null) {
                    finalTipLoading.showError("请求错误");
                }
            }
        });
    }

    private void result(boolean isWrite, TipLoading finalTipLoading, TipLoadingBean tip, T t) {
        if (t.result == 0) {
            if (finalTipLoading != null && !isWrite) {
                if (getShowSucces()) {
                    finalTipLoading.showSucces(tip.getSucces());
                } else {
                    finalTipLoading.dismiss();
                }

            }
            if (onRequestListeren != null) {
                onRequestListeren.succes(t.data);
            }

        } else {
            if (finalTipLoading != null && !isWrite) {
                if (getShowInfo()) {
                    finalTipLoading.showInfo(TextUtils.isEmpty(t.msg) ? tip.getError() : t.msg);
                } else {
                    finalTipLoading.dismiss();
                }

            }
            if (onRequestListeren != null) {
                onRequestListeren.error(t.msg);
            }
        }
    }

    private void saveCache(JavaBeanRequest<T> request, String url) {
        if (getShouldCache()) {
            request.setIsCache(true);
            request.setSaveUrl(url);
        }
    }


    private TipLoading getLoading() {
        return new TipLoading(getContext());
    }

    private OnRequestListeren onRequestListeren;

    public ApiRequest setOnRequestListeren(OnRequestListeren onRequestListeren) {
        this.onRequestListeren = onRequestListeren;
        return this;
    }

}
