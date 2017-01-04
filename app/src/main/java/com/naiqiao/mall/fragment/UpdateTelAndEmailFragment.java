package com.naiqiao.mall.fragment;

import android.support.v4.app.Fragment;

import com.naiqiao.mall.fragment.base.TabIndicatorBaseFragment;

import java.util.ArrayList;

/**
 * Created by dengmingzhi on 2017/1/4.
 */

public class UpdateTelAndEmailFragment extends TabIndicatorBaseFragment {
    @Override
    protected ArrayList<Fragment> getFragments() {
        return null;
    }

    @Override
    protected String[] getTabTitles() {
        return new String[]{"短信验证", "邮箱验证"};
    }

    @Override
    protected String getTitleContent() {
        return "修改手机号";
    }
}
