package com.naiqiao.mall.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.bean.UserSetBean;
import com.recker.flyshapeimageview.ShapeImageView;

import java.util.Map;

import api.TestConstant;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import view.DefaultTitleBarView;

/**
 * Created by dengmingzhi on 2016/12/7.
 */

public class UserSetFragment extends SingleNetWorkBaseFragment<UserSetBean> {
    @BindView(R.id.iv_head)
    ShapeImageView iv_head;
    @BindView(R.id.ll_gs)
    LinearLayout ll_gs;

    @Override
    protected String url() {
        return "http://www.ediancha.com/app.php";
    }


    @Override
    protected void writeData(boolean isWrite, UserSetBean bean) {
        super.writeData(isWrite, bean);
        Glide.with(getContext()).load(TestConstant.IMAGE).into(iv_head);
    }

    @Override
    protected Map<String, String> map() {
        map.put("c", "chahui");
        map.put("a", "index");
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


    @OnClick({R.id.iv_head})
    void onclick(View view) {
        switch (view.getId()) {
            case R.id.iv_head:
                if (ll_gs.getVisibility() == View.GONE) {
                    ll_gs.setVisibility(View.VISIBLE);
                } else {
                    ll_gs.setVisibility(View.GONE);
                }

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
