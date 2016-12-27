package com.naiqiao.mall.fragment;

import com.naiqiao.mall.constant.ApiConstant;
import com.naiqiao.mall.constant.UserInfo;
import com.naiqiao.mall.fragment.base.JiaoYiJiFenFanDianBaseFragment;

import java.util.Map;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class MyFanDianFragment extends JiaoYiJiFenFanDianBaseFragment {

    @Override
    protected String url() {
        return ApiConstant.USER;
    }

    @Override
    protected Map<String, String> map() {
        map.put("act", "account_detail");
        map.put("user_id", UserInfo.uid);
        map.put("sign_token", UserInfo.token);
        return super.map();
    }


    @Override
    protected void initTitleView() {
        titleBarView.setTitleContent("我的返点");
        titleBarView.setButtonTitle("返点规则");
    }
}
