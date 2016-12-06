package com.naiqiao.mall.fragment;

import com.naiqiao.mall.fragment.base.JiaoYiJiFenFanDianBaseFragment;

import java.util.Map;

/**
 * Created by dengmingzhi on 2016/11/25.
 */

public class MyFanDianFragment extends JiaoYiJiFenFanDianBaseFragment {

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
    protected void initTitleView() {
        titleBarView.setTitleContent("我的返点");
        titleBarView.setButtonTitle("返点规则");
    }

}
