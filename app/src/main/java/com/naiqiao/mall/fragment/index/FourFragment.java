package com.naiqiao.mall.fragment.index;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.UserCenter;
import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.fragment.AllShopContentFragment;
import com.naiqiao.mall.fragment.DaoHuoTZFragment;
import com.naiqiao.mall.fragment.HelpCenterFragment;
import com.naiqiao.mall.fragment.JiaoYiJiLvFragment;
import com.naiqiao.mall.fragment.MyCollectFragment;
import com.naiqiao.mall.fragment.MyFaPiaoFragment;
import com.naiqiao.mall.fragment.MyFanDianFragment;
import com.naiqiao.mall.fragment.MyJInHuoDanContentFragment;
import com.naiqiao.mall.fragment.MyJiFenFragment;
import com.naiqiao.mall.fragment.MyOrderContentFragment;
import com.naiqiao.mall.fragment.SetFragment;
import com.naiqiao.mall.fragment.XiaoLiangPaiHangFragment;
import com.naiqiao.mall.fragment.XiaoXiTZFragment;
import com.naiqiao.mall.fragment.YiFaHuoRootFragment;
import com.naiqiao.mall.fragment.YuCunHuoContentFragment;
import com.naiqiao.mall.fragment.ZaiTuDingDanFragment;
import com.naiqiao.mall.fragment.login.LoginFragment;
import com.naiqiao.mall.view.FourTitleBarView;
import com.naiqiao.mall.view.pop.BackShopUpdateAccountPopView;
import com.naiqiao.mall.view.pop.JiaMengSQPopView;
import com.recker.flyshapeimageview.ShapeImageView;

import java.util.List;
import java.util.Map;

import api.TestConstant;
import base.bean.rxbus.AddFragmentBean;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interfaces.OnTitleBarListener;
import interfaces.ScrollChangeViewListener;
import rx.Observable;
import rx.functions.Action1;
import util.JLogUtils;
import util.RxBus;
import view.ScrollChangeScrollView;
import view.TextImage;
import view.TitleRelativeLayout;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class FourFragment extends SingleNetWorkBaseFragment<UserCenter> implements ScrollChangeViewListener, OnTitleBarListener {
    @BindViews({R.id.tv_1_1, R.id.tv_1_2, R.id.tv_1_3, R.id.tv_1_4, R.id.tv_1_5})
    List<TextView> tv1s;
    @BindViews({R.id.tv_2_1, R.id.tv_2_2, R.id.tv_2_3, R.id.tv_2_4})
    List<TextImage> tv2s;
    @BindViews({R.id.tv_3_1, R.id.tv_3_2, R.id.tv_3_3, R.id.tv_3_4})
    List<TextImage> tv3s;
    @BindViews({R.id.tv_4_1, R.id.tv_4_2, R.id.tv_4_3, R.id.tv_4_4})
    List<TextImage> tv4s;
    @BindViews({R.id.tv_5_1, R.id.tv_5_2})
    List<TextImage> tv5s;
    @BindViews({R.id.trl_1, R.id.trl_2})
    List<TitleRelativeLayout> trls;
    @BindViews({R.id.fg_1, R.id.fg_2})
    List<FrameLayout> fgs;
    @BindView(R.id.iv_head)
    ShapeImageView iv_head;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_level)
    TextView tv_level;
    @BindView(R.id.sc_root)
    ScrollChangeScrollView sc_root;

    @Override
    protected String url() {
        return ApiConstant.USER;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "my_user");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }

    @Override
    protected void writeData(boolean isWrite, UserCenter bean) {
        super.writeData(isWrite, bean);
        UserCenter.Data data = bean.data;
        Glide.with(getContext()).load(data.avatar).into(iv_head);
        tv_level.setText(data.user_rank);
        tv_name.setText(data.user_name);
        tv1s.get(0).setText("库存预警\n" + data.notice);
        tv1s.get(1).setText("到货通知\n" + data.booking_goods);
        tv1s.get(2).setText("在途中\n" + data.zaitu);
        tv1s.get(3).setText("虚拟仓\n" + data.stock_goods);
        tv1s.get(4).setText("积分\n" + data.integral);
        titleBarView.setRightContent(data.news);
        userInfoChange();
    }

    @Override
    protected void manageError(boolean isWrite, UserCenter userCenter, String msg) {
        super.manageError(isWrite, userCenter, msg);
        if (TextUtils.equals("token不正确", msg)) {
            RxBus.get().post("addFragment", new AddFragmentBean(new LoginFragment()));
        }
    }

    @Override
    protected Class<UserCenter> getTClass() {
        return UserCenter.class;
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_four, null);
        ButterKnife.bind(this, view);
        sc_root.setScrollViewListener(this);
        return view;
    }

    @OnClick({R.id.tv_1_1, R.id.tv_1_2, R.id.tv_1_3, R.id.tv_1_4, R.id.tv_1_5})
    void tv1Click(View view) {
        switch (view.getId()) {
            case R.id.tv_1_1:
                RxBus.get().post("addFragment", new AddFragmentBean(DaoHuoTZFragment.getInstance(false)));
                break;
            case R.id.tv_1_2:
                RxBus.get().post("addFragment", new AddFragmentBean(DaoHuoTZFragment.getInstance(true)));
                break;
            case R.id.tv_1_3:
                RxBus.get().post("addFragment", new AddFragmentBean(new ZaiTuDingDanFragment()));
                break;
            case R.id.tv_1_4:
                RxBus.get().post("addFragment", new AddFragmentBean(new AllShopContentFragment()));
                break;
            case R.id.tv_1_5:
                RxBus.get().post("addFragment", new AddFragmentBean(new MyJiFenFragment()));
                break;
        }
    }

    @OnClick({R.id.tv_2_1, R.id.tv_2_2, R.id.tv_2_3, R.id.tv_2_4})
    void tv2Click(View view) {
        switch (view.getId()) {
            case R.id.tv_2_1:
                Log.d("点击了", tv2s.get(0).getText().toString());
                RxBus.get().post("addFragment", new AddFragmentBean(new MyOrderContentFragment()));
                break;
            case R.id.tv_2_2:
                RxBus.get().post("addFragment", new AddFragmentBean(new JiaoYiJiLvFragment()));
                break;
            case R.id.tv_2_3:
                RxBus.get().post("addFragment", new AddFragmentBean(new MyJInHuoDanContentFragment()));
                Log.d("点击了", tv2s.get(2).getText().toString());
                break;
            case R.id.tv_2_4:
                RxBus.get().post("addFragment", new AddFragmentBean(new ZaiTuDingDanFragment()));
                Log.d("点击了", tv2s.get(3).getText().toString());
                break;
        }
    }

    @OnClick({R.id.tv_3_1, R.id.tv_3_2, R.id.tv_3_3, R.id.tv_3_4})
    void tv3Click(View view) {
        switch (view.getId()) {
            case R.id.tv_3_1:
                RxBus.get().post("addFragment", new AddFragmentBean(new MyJiFenFragment()));
                Log.d("点击了", tv3s.get(0).getText().toString());
                break;
            case R.id.tv_3_2:
                RxBus.get().post("addFragment", new AddFragmentBean(new MyFanDianFragment()));
                Log.d("点击了", tv3s.get(1).getText().toString());
                break;
            case R.id.tv_3_3:
                RxBus.get().post("addFragment", new AddFragmentBean(new MyCollectFragment()));
                Log.d("点击了", tv3s.get(2).getText().toString());
                break;
            case R.id.tv_3_4:
                RxBus.get().post("addFragment", new AddFragmentBean(new MyFaPiaoFragment()));
                Log.d("点击了", tv3s.get(3).getText().toString());
                break;
        }
    }

    @OnClick({R.id.tv_4_1, R.id.tv_4_2, R.id.tv_4_3, R.id.tv_4_4})
    void tv4Click(View view) {
        switch (view.getId()) {
            case R.id.tv_4_1:
                RxBus.get().post("addFragment", new AddFragmentBean(new AllShopContentFragment()));
                break;
            case R.id.tv_4_2:
                RxBus.get().post("addFragment", new AddFragmentBean(new YuCunHuoContentFragment()));
                break;
            case R.id.tv_4_3:
                RxBus.get().post("indexBottomTabChangeFromOther", 2);
                break;
            case R.id.tv_4_4:
                RxBus.get().post("addFragment", new AddFragmentBean(new YiFaHuoRootFragment()));
                break;
        }
    }


    @OnClick({R.id.fg_1, R.id.fg_2})
    void fgClick(View view) {
        switch (view.getId()) {
            case R.id.fg_1:
                Log.d("点击了", tv5s.get(0).getText().toString());
                break;
            case R.id.fg_2:
                RxBus.get().post("addFragment", new AddFragmentBean(new XiaoLiangPaiHangFragment()));
                break;
        }
    }

    @OnClick(R.id.iv_head)
    void headClick() {
        RxBus.get().post("addFragment", new AddFragmentBean(new LoginFragment()));
    }

    @OnClick({R.id.trl_1, R.id.trl_2})
    void trlClick(View view) {
        switch (view.getId()) {
            case R.id.trl_1:
                new JiaMengSQPopView(getContext()).showAtLocation(false);
                break;
            case R.id.trl_2:
                RxBus.get().post("addFragment", new AddFragmentBean(new HelpCenterFragment()));
                break;
        }
    }


    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }

    @Override
    protected View getTitleBarView() {
        return new FourTitleBarView(getContext());
    }

    private FourTitleBarView titleBarView;

    @Override
    protected void initTitleView() {
        titleBarView = (FourTitleBarView) getTitleBar();
        titleBarView.setOnTitleBarListener(this);
    }


    @Override
    public void onScrollChanged(ScrollView scrollView, int x, int y, int oldx, int oldy) {
        int bottom = tv_name.getBottom();
        if (y >= bottom) {
            titleBarView.setTitleContent(tv_name.getText().toString());
        } else {
            titleBarView.setTitleContent("");
        }
    }


    @Override
    public void left() {
        RxBus.get().post("addFragment", new AddFragmentBean(new SetFragment()));
    }

    @Override
    public void right() {
        RxBus.get().post("addFragment", new AddFragmentBean(new XiaoXiTZFragment()));
    }

    @Override
    public void center() {

    }

    private Observable<String> userChangeRxbus;

    private void userInfoChange() {
        if (userChangeRxbus == null) {
            userChangeRxbus = RxBus.get().register("userChange", String.class);
            userChangeRxbus.subscribe(new Action1<String>() {
                @Override
                public void call(String s) {
                    getData();
                    JLogUtils.D("这里");
                }
            });
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister("userChange", userChangeRxbus);
    }
}
