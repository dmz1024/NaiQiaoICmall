package com.naiqiao.mall.fragment.base;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.naiqiao.mall.bean.ThingBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.fragment.WriteFpInfoPuFragment;
import com.naiqiao.mall.interfaces.SingleTextWatcher;

import java.util.HashMap;
import java.util.Map;

import api.ApiRequest;
import base.bean.TipLoadingBean;
import base.fragment.NotNetWorkBaseFragment;
import interfaces.OnSingleRequestListener;
import util.MyToast;
import view.pop.ChooseStringView;

import static com.naiqiao.mall.R.id.et_price;
import static com.naiqiao.mall.R.id.et_taitou;

/**
 * Created by dengmingzhi on 2017/2/6.
 */

public abstract class WriteFpInfoBaseFragment extends NotNetWorkBaseFragment {
    protected ThingBean thingBean;

    protected void getContent(){
        if (thingBean == null) {
            new ApiRequest<ThingBean>() {
                @Override
                protected Map<String, String> getMap() {
                    Map<String, String> map = new HashMap<>();
                    map.put("act", "content_lista");
                    return map;
                }

                @Override
                protected String getUrl() {
                    return ApiConstant.INVOICE;
                }

                @Override
                protected Context getContext() {
                    return WriteFpInfoBaseFragment.this.getContext();
                }

                @Override
                protected Class<ThingBean> getClx() {
                    return ThingBean.class;
                }

                @Override
                protected boolean getShowSucces() {
                    return false;
                }
            }.setOnRequestListeren(new OnSingleRequestListener<ThingBean>() {

                @Override
                public void succes(boolean isWrite, final ThingBean bean) {
                    thingBean = bean;
                    showChontent();
                }

                @Override
                public void error(boolean isWrite, ThingBean bean, String msg) {

                }
            }).get(new TipLoadingBean("获取内容列表", "", ""));
        } else {
            showChontent();
        }

    }

    private boolean isChangeIng;

    @Override
    protected void initView() {
        getEditView().addTextChangedListener(new SingleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (isChangeIng) {
                    return;
                }
                isChangeIng = true;
                String fan = s.toString();
                if (fan.length() > 1) {
                    if (TextUtils.equals(fan.substring(0, 1), "0")) {
                        fan = fan.substring(1);
                        getEditView().setText(fan);
                        getEditView().setSelection(fan.length());
                    }

                } else if (TextUtils.isEmpty(fan)) {
                    fan = "0";
                }

                if (Integer.parseInt(fan) > 10000) {
                    fan = "10000";
                    getEditView().setText(fan);
                    getEditView().setSelection(fan.length());
                }

                isChangeIng = false;
            }
        });
    }

    protected abstract EditText getEditView();

    private void showChontent() {
        new ChooseStringView<ThingBean.Data>(getContext(), thingBean.data) {
            @Override
            protected void itemClick(int position) {
                setShowContent(thingBean.data.get(position).getString());
            }
        }.showAtLocation(false);
    }

    protected String content;
    protected  void setShowContent(String string){
        content=string;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        thingBean = null;
    }

    public String getInfo(){
        return null;
    }

}
