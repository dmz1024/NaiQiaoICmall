package com.naiqiao.mall.fragment.index;

import android.view.View;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.User;
import com.recker.flyshapeimageview.ShapeImageView;

import java.util.Map;

import api.TestConstant;
import base.fragment.SingleNetWorkBaseFragment;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class FourFragment extends SingleNetWorkBaseFragment<User> {

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
        ShapeImageView iv_head= (ShapeImageView) view.findViewById(R.id.iv_head);
        Glide.with(getContext()).load(TestConstant.IMAGE).into(iv_head);
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

    @Override
    protected View getTitleBarView() {
        return null;
    }
}
