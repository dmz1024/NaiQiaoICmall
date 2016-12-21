package com.naiqiao.mall.fragment;


import base.bean.rxbus.AddFragmentBean;
import com.naiqiao.mall.fragment.base.JiaoYiJiFenFanDianBaseFragment;
import java.util.Map;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/25.
 * 我的积分
 */

public class MyJiFenFragment extends JiaoYiJiFenFanDianBaseFragment  {

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
        super.initTitleView();
        titleBarView.setTitleContent("我的积分");
        titleBarView.setButtonTitle("积分商城");
    }

    @Override
    public void rightBt() {
        RxBus.get().post("addFragment",new AddFragmentBean(new JiFenDuiContentFragment()));
    }
}
