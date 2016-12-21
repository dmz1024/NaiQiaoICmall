package com.naiqiao.mall.fragment;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.naiqiao.mall.R;
import com.naiqiao.mall.adapter.SendMonadAdapter;
import com.naiqiao.mall.bean.SendCarBean;
import base.bean.rxbus.AddFragmentBean;

import java.util.ArrayList;

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

public class SendMonadContentFragment extends NotNetWorkBaseFragment {
    @BindView(R.id.tv_count)
    Color2Text tv_count;
    @BindView(R.id.tv_choose)
    TextView tv_choose;
    @BindView(R.id.rv_content)
    RecyclerView rv_content;
    @BindView(R.id.bt_send_car)
    Button bt_send_car;
    private SendMonadAdapter mAdapter;
    private boolean isChoose = true;

    @Override
    protected int getRId() {
        return R.layout.fragment_send_monad;
    }

    ArrayList<SendCarBean.Data> data;
    private int count;

    @Override
    protected void initView() {
        data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SendCarBean.Data send = new SendCarBean.Data();
            send.count = i;
            data.add(send);
        }
        count = data.size();
        creatSendAdapter();

    }

    private void creatSendAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mAdapter = new SendMonadAdapter(getContext(), data) {
            @Override
            protected void choose() {
                isChoose = true;
                int count = 0;
                int chooseCount = 0;
                for (int i = 0; i < SendMonadContentFragment.this.count; i++) {
                    if (!data.get(i).isChoose) {
                        isChoose = false;
                    } else {
                        count += data.get(i).count;
                        chooseCount += 1;
                    }
                }
                ChangeButton(chooseCount, count);

                changeChoose();
            }
        };
        rv_content.setAdapter(mAdapter);
        rv_content.setLayoutManager(manager);
    }

    @Override
    protected void initData() {
        bt_send_car.postDelayed(new Runnable() {
            @Override
            public void run() {
                notifyData();
            }
        }, 200);
    }

    @OnClick(R.id.bt_send_car)
    void sendCar() {
        WriteSendShopFragment writeSendShopFragment = new WriteSendShopFragment();
        ArrayList<SendCarBean.Data> sendData = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).isChoose) {
                sendData.add(data.get(i));
            }
        }

        writeSendShopFragment.setData(sendData);
        RxBus.get().post("addFragment", new AddFragmentBean(writeSendShopFragment));
    }

    @OnClick(R.id.tv_choose)
    void choose() {
        isChoose = !isChoose;
        changeChoose();
        notifyData();
    }

    private void changeChoose() {
        tv_choose.setCompoundDrawables(DrawableUtil.setBounds(isChoose ? getResources().getDrawable(R.mipmap.icon_checked) : getResources().getDrawable(R.mipmap.icon_check)), null, null, null);
    }

    private boolean isFirst = true;

    private void notifyData() {
        int count = 0;
        int chooseCount = 0;
        for (int i = 0; i < this.count; i++) {
            data.get(i).isChoose = isChoose;
            if (isChoose) {
                count += data.get(i).count;
                chooseCount += 1;
            }
        }


        ChangeButton(chooseCount, count);
        if (!isFirst) {
            mAdapter.notifyDataSetChanged();
        } else {
            isFirst = false;
        }

    }


    private void ChangeButton(int chooseCount, int count) {
        if (count > 0) {
            bt_send_car.setEnabled(true);
            bt_send_car.setAlpha(1);
            tv_count.setTextNotChange("共" + chooseCount + "种" + count + "件");
        } else {
            bt_send_car.setEnabled(false);
            bt_send_car.setAlpha(0.5f);
            tv_count.setTextNotChange("请选择发货商品");
        }
    }


    @Override
    protected void initTitleView() {
        DefaultTitleBarView defaultTitleBarView = (DefaultTitleBarView) getTitleBar();
        defaultTitleBarView.setTitleContent("发货单");
    }

}
