package com.naiqiao.mall.fragment;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.User;
import com.naiqiao.mall.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.fragment.index.IndexFragment;

import java.util.Map;

import base.fragment.NetworkBaseFragment;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import util.RxBus;
import view.Color2Text;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class WelComeFragment extends SingleNetWorkBaseFragment<User> {
    @BindView(R.id.view_root)
    LinearLayout view_root;
    @BindView(R.id.iv_bg)
    ImageView iv_bg;
    @BindView(R.id.tv_next)
    Color2Text tv_next;
    @BindView(R.id.iv_img)
    ImageView iv_img;
    private int time = 3;
    private int adTime = 5;
    private boolean isHaveAd;
    private ChangeRunnable changeRunnable = new ChangeRunnable();

    private class ChangeRunnable implements Runnable {

        @Override
        public void run() {
            int i = isHaveAd ? (adTime--) : (time--);
            if (i <= 0) {
                next();
            } else {
                if (isHaveAd) {
                    tv_next.setVisibility(View.VISIBLE);
                    tv_next.setTextNotChange(i + "");
                }
                view_root.postDelayed(changeRunnable, 1000);
            }
        }
    }

    @Override
    protected Class<User> getTClass() {
        return User.class;
    }

    @Override
    protected void writeData(boolean isWrite, User bean) {
        super.writeData(isWrite, bean);
        isHaveAd = true;
        view_root.removeCallbacks(changeRunnable);
        view_root.postDelayed(changeRunnable, 1000);
    }

    @Override
    protected void manageError(boolean isWrite, User user, String msg) {
        super.manageError(isWrite, user, msg);

    }


    @Override
    protected ShowCurrentViewENUM getDefaultView() {
        return ShowCurrentViewENUM.VIEW_HAVE_DATA;
    }

    @Override
    protected String url() {
        return "http://www.ediancha.com/app.php";
    }

    @Override
    protected Map<String, String> map() {
        map.put("c", "chahui");
        map.put("a", "index");
        map.put("type", "1");
        return super.map();
    }


    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_welcome, null);
        ButterKnife.bind(this, view);
        view_root.postDelayed(changeRunnable, 1000);
        return view;
    }


    @OnClick(R.id.tv_next)
    void next() {
        AddFragmentBean addFragmentBean = new AddFragmentBean(new IndexFragment());
        addFragmentBean.setAddBack(true);
        addFragmentBean.setHaveAnima(true);
        RxBus.get().post("addFragment", addFragmentBean);
        view_root.removeCallbacks(changeRunnable);
        onDestroy();
    }

    @Override
    protected View getTitleBarView() {
        return null;
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }

    @Override
    protected boolean writeCache() {
        return false;
    }
}
