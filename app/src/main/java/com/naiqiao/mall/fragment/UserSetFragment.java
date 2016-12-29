package com.naiqiao.mall.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.UserSetBean;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.controller.AccountController;
import com.naiqiao.mall.view.pop.PopEdit;
import com.recker.flyshapeimageview.ShapeImageView;

import java.util.HashMap;
import java.util.Map;

import api.TestConstant;
import base.bean.SingleBaseBean;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interfaces.OnSingleRequestListener;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import util.RxBus;
import view.DefaultTitleBarView;
import view.TitleRelativeLayout;

/**
 * Created by dengmingzhi on 2016/12/7.
 */

public class UserSetFragment extends SingleNetWorkBaseFragment<UserSetBean> {
    @BindView(R.id.iv_head)
    ImageView iv_head;
    @BindView(R.id.trl_name)
    TitleRelativeLayout trl_name;
    @BindView(R.id.trl_address)
    TitleRelativeLayout trl_address;
    @BindView(R.id.trl_tel)
    TitleRelativeLayout trl_tel;
    @BindView(R.id.trl_email)
    TitleRelativeLayout trl_email;
    @BindView(R.id.trl_true_name)
    TitleRelativeLayout trl_true_name;
    @BindView(R.id.trl_gs_name)
    TitleRelativeLayout trl_gs_name;
    @BindView(R.id.trl_gs_linkman)
    TitleRelativeLayout trl_gs_linkman;
    @BindView(R.id.trl_gs_tel)
    TitleRelativeLayout trl_gs_tel;
    @BindView(R.id.tv_level)
    TextView tv_level;
    @BindView(R.id.ll_gs)
    LinearLayout ll_gs;

    @Override
    protected String url() {
        return ApiConstant.PROFILE;
    }


    @Override
    protected void writeData(boolean isWrite, UserSetBean bean) {
        super.writeData(isWrite, bean);
        UserSetBean.Data data = bean.data;
        Glide.with(getContext()).load(data.avatar).bitmapTransform(new CropCircleTransformation(getContext())).into(iv_head);
        trl_name.setContent(data.user_name);
        trl_address.setContent(data.addr);
        trl_tel.setContent(data.mobile_phone);
        trl_email.setContent(data.email);
        if(data.type==1){
            ll_gs.setVisibility(View.VISIBLE);
            trl_gs_tel.setContent(data.company);
            trl_gs_linkman.setContent(data.name);
            trl_gs_tel.setContent(data.company_tel);
        }
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "index");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    protected Class<UserSetBean> getTClass() {
        return UserSetBean.class;
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_user_set, null);
        ButterKnife.bind(this, view);
        return view;
    }
//    http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg

    @OnClick({R.id.iv_head, R.id.trl_name})
    void onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_head:
                if (ll_gs.getVisibility() == View.GONE) {
                    ll_gs.setVisibility(View.VISIBLE);
                } else {
                    ll_gs.setVisibility(View.GONE);
                }

                break;
            case R.id.trl_name:
                new PopEdit(getContext(), false, trl_name.getContent()) {
                    @Override
                    protected void content(final String content) {
                        Map<String, String> map = new HashMap<>();
                        map.put("user_name", content);
                        new AccountController(getContext()).setOnRequestListeren(new OnSingleRequestListener<SingleBaseBean>() {
                            @Override
                            public void succes(boolean isWrite, SingleBaseBean bean) {
                                trl_name.setContent(content);
                                RxBus.get().post("userChange","aa");
                            }

                            @Override
                            public void error(boolean isWrite, SingleBaseBean bean, String msg) {

                            }
                        }).updateUserInfo(map);
                    }
                }.showAtLocation(false);
                break;
        }
    }


    @Override
    protected void initTitleView() {
        DefaultTitleBarView titleBar = (DefaultTitleBarView) getTitleBar();
        titleBar.setTitleContent("账号设置");
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }

}
