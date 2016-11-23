package com.naiqiao.mall.fragment.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.naiqiao.mall.MyAdapter;
import com.naiqiao.mall.R;
import com.naiqiao.mall.User;

import java.util.ArrayList;
import java.util.Map;

import base.fragment.DefaultTitleBarListNetWorkBaseFragment;
import base.fragment.NetworkBaseFragment;
import base.fragment.SingleNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class FourFragment extends SingleNetWorkBaseFragment<User> {

    @Override
    protected void writeData(boolean isWrite, User bean) {
        super.writeData(isWrite, bean);
    }

    @Override
    protected void manageError(boolean isWrite, User user, String msg) {
        super.manageError(isWrite, user, msg);
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
    protected Class<User> getTClass() {
        return User.class;
    }

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_four, null);
        return view;
    }

    @Override
    protected boolean isCanFirstInitData() {
        return false;
    }

    @Override
    protected boolean isCanRefresh() {
        return false;
    }
}
