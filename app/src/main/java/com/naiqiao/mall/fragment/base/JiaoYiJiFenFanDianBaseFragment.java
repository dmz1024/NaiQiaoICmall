package com.naiqiao.mall.fragment.base;
import android.view.View;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.interfaces.OnJiaoYi_JiFen_FanDianTitleBarListener;
import com.naiqiao.mall.view.JiaoYi_JiFen_FanDianTitleBarView;
import java.util.Map;
import base.bean.ListBaseBean;
import base.fragment.ListNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public abstract class JiaoYiJiFenFanDianBaseFragment<D extends ListBaseBean> extends ListNetWorkBaseFragment<D> implements OnJiaoYi_JiFen_FanDianTitleBarListener {
    protected JiaoYi_JiFen_FanDianTitleBarView titleBarView;


    @Override
    protected Map<String, String> map() {
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }


    @Override
    protected View getTitleBarView() {
        return titleBarView = new JiaoYi_JiFen_FanDianTitleBarView(getContext());
    }

    @Override
    protected void initTitleView() {
        titleBarView.setOnTitleBarListener(this);
    }

    @Override
    protected float top() {
        return 80;
    }

    @Override
    public void rightBt() {

    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public void center() {

    }
}
