package com.naiqiao.mall.fragment;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.fragment.login.PayFragment;

import base.bean.rxbus.AddFragmentBean;
import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.OnClick;
import util.DrawableUtil;
import util.RxBus;
import view.Color2Text;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class MyJInHuoDanContentFragment extends NotNetWorkBaseFragment implements MyJinHuoDanFragment.OnDataChangeListener {
    @BindView(R.id.tv_count)
    Color2Text tv_count;
    @BindView(R.id.tv_choose)
    TextView tv_choose;
    @BindView(R.id.bt_pay)
    Button bt_pay;
    private boolean isChoose = false;

    @Override
    protected int getRId() {
        return R.layout.fragment_jinhuodan;
    }

    private MyJinHuoDanFragment danFragment;


    @Override
    protected void initData() {
        getChildFragmentManager().beginTransaction().add(R.id.fg_content, danFragment = new MyJinHuoDanFragment()).commit();
        danFragment.setOnDataChangeListener(this);
    }

    @OnClick(R.id.bt_pay)
    void payCar() {
        RxBus.get().post("addFragment",new AddFragmentBean(new PayFragment()));
    }

    @OnClick(R.id.tv_choose)
    void choose() {
        if (danFragment != null) {
            isChoose = !isChoose;
            danFragment.choose(isChoose);
        }
    }

    private void changeChoose() {
        tv_choose.setCompoundDrawables(DrawableUtil.setBounds(isChoose ? getResources().getDrawable(R.mipmap.icon_checked) : getResources().getDrawable(R.mipmap.icon_check)), null, null, null);
    }


    @Override
    protected void initTitleView() {
        DefaultTitleBarView defaultTitleBarView = (DefaultTitleBarView) getTitleBar();
        defaultTitleBarView.setTitleContent("我的进货单");
    }


    private double price = 0;
    private int count = 0;

    @Override
    public void choose(boolean choose, double price, int count) {
        isChoose = choose;
        changeChoose();
        this.price = price;
        this.count = count;
        showPriceInfo();
    }

    @Override
    public void price(int count, double price) {
        Log.d("price",price+"--"+count);
        this.price =this.price+( price * count);
        this.count += count;
        showPriceInfo();
    }

    private void showPriceInfo() {
        tv_count.setContentNotChange("合计：￥" + String.format("%.2f", price));
        tv_count.setTextNotChange("\n共" + count + "件");
        bt_pay.setEnabled(count > 0);
        bt_pay.setAlpha(count > 0 ? 1f : 0.5f);
    }

}
