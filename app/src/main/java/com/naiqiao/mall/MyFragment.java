package com.naiqiao.mall;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Map;

import base.NetworkBaseFragment;
import base.TipLoadingBean;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class MyFragment extends NetworkBaseFragment<User> {

    private TextView tv_content;


    @Override
    protected void manageError(boolean isWrite, User user, String msg) {
        Log.d("城市", msg);
    }

    @Override
    protected void writeData(boolean isWrite, User bean) {
        getCurrentView(ShowCurrentViewENUM.VIEW_HAVE_DATA);
        if (!isWrite) {
            stopRefresh();
        }
        for (int i = 0; i < bean.data.size(); i++) {
            tv_content.append(bean.data.get(i).name + "\n");
        }
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
        map.put("c", "area");
        map.put("a", "index");
        return map;
    }


    @Override
    protected Class<User> getTClass() {
        return User.class;
    }

    @Override
    protected View getHaveDataView() {
        tv_content = new TextView(getContext());
        tv_content.setTextColor(getResources().getColor(R.color.colorf00));
        return tv_content;
    }

    @Override
    protected boolean writeCache() {
        return false;
    }

    @Override
    protected boolean shouldCache() {
        return true;
    }

}
