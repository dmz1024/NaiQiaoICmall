package com.naiqiao.mall.fragment.index;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.naiqiao.mall.R;
import com.naiqiao.mall.User;
import com.naiqiao.mall.view.FourTitleBarView;
import com.recker.flyshapeimageview.ShapeImageView;

import java.util.List;
import java.util.Map;

import api.TestConstant;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import view.TextImage;
import view.TitleRelativeLayout;

/**
 * Created by dengmingzhi on 2016/11/16.
 */

public class FourFragment extends SingleNetWorkBaseFragment<User> {
    @BindViews({R.id.tv_1_1, R.id.tv_1_2, R.id.tv_1_3, R.id.tv_1_4, R.id.tv_1_5})
    List<TextView> tv1s;
    @BindViews({R.id.tv_2_1, R.id.tv_2_2, R.id.tv_2_3, R.id.tv_2_4})
    List<TextImage> tv2s;
    @BindViews({R.id.tv_3_1, R.id.tv_3_2, R.id.tv_3_3, R.id.tv_3_4})
    List<TextImage> tv3s;
    @BindViews({R.id.tv_4_1, R.id.tv_4_2, R.id.tv_4_3, R.id.tv_4_4})
    List<TextImage> tv4s;
    @BindViews({R.id.tv_5_1, R.id.tv_5_2})
    List<TextImage> tv5s;
    @BindViews({R.id.trl_1, R.id.trl_2})
    List<TitleRelativeLayout> trls;
    @BindViews({R.id.fg_1, R.id.fg_2})
    List<FrameLayout> fgs;
    @BindView(R.id.iv_head)
    ShapeImageView iv_head;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_level)
    TextView tv_level;

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
        ButterKnife.bind(this, view);
        Glide.with(getContext()).load(TestConstant.IMAGE).into(iv_head);
        return view;
    }


    @OnClick({R.id.tv_1_1, R.id.tv_1_2, R.id.tv_1_3, R.id.tv_1_4, R.id.tv_1_5})
    void tv1Click(View view) {
        switch (view.getId()) {
            case R.id.tv_1_1:
                Log.d("点击了", tv1s.get(0).getText().toString());
                break;
            case R.id.tv_1_2:
                Log.d("点击了", tv1s.get(1).getText().toString());
                break;
            case R.id.tv_1_3:
                Log.d("点击了", tv1s.get(2).getText().toString());
                break;
            case R.id.tv_1_4:
                Log.d("点击了", tv1s.get(3).getText().toString());
                break;
            case R.id.tv_1_5:
                Log.d("点击了", tv1s.get(4).getText().toString());
                break;
        }
    }

    @OnClick({R.id.tv_2_1, R.id.tv_2_2, R.id.tv_2_3, R.id.tv_2_4})
    void tv2Click(View view) {
        switch (view.getId()) {
            case R.id.tv_2_1:
                Log.d("点击了", tv2s.get(0).getText().toString());
                break;
            case R.id.tv_2_2:
                Log.d("点击了", tv2s.get(1).getText().toString());
                break;
            case R.id.tv_2_3:
                Log.d("点击了", tv2s.get(2).getText().toString());
                break;
            case R.id.tv_2_4:
                Log.d("点击了", tv2s.get(3).getText().toString());
                break;
        }
    }

    @OnClick({R.id.tv_3_1, R.id.tv_3_2, R.id.tv_3_3, R.id.tv_3_4})
    void tv3Click(View view) {
        switch (view.getId()) {
            case R.id.tv_3_1:
                Log.d("点击了", tv3s.get(0).getText().toString());
                break;
            case R.id.tv_3_2:
                Log.d("点击了", tv3s.get(1).getText().toString());
                break;
            case R.id.tv_3_3:
                Log.d("点击了", tv3s.get(2).getText().toString());
                break;
            case R.id.tv_3_4:
                Log.d("点击了", tv3s.get(3).getText().toString());
                break;
        }
    }

    @OnClick({R.id.tv_4_1, R.id.tv_4_2, R.id.tv_4_3, R.id.tv_4_4})
    void tv4Click(View view) {
        switch (view.getId()) {
            case R.id.tv_4_1:
                Log.d("点击了", tv4s.get(0).getText().toString());
                break;
            case R.id.tv_4_2:
                Log.d("点击了", tv4s.get(1).getText().toString());
                break;
            case R.id.tv_4_3:
                Log.d("点击了", tv4s.get(2).getText().toString());
                break;
            case R.id.tv_4_4:
                Log.d("点击了", tv4s.get(3).getText().toString());
                break;
        }
    }


    @OnClick({R.id.fg_1, R.id.fg_2})
    void fgClick(View view) {
        switch (view.getId()) {
            case R.id.fg_1:
                Log.d("点击了", tv5s.get(0).getText().toString());
                break;
            case R.id.fg_2:
                Log.d("点击了", tv5s.get(1).getText().toString());
                break;
        }
    }

    @OnClick(R.id.iv_head)
    void headClick() {
        Log.d("点击了", "图像点击了");
    }

    @OnClick({R.id.trl_1, R.id.trl_2})
    void trlClick(View view) {
        switch (view.getId()) {
            case R.id.trl_1:
                Log.d("点击了", trls.get(0).getTitleContent());
                break;
            case R.id.trl_2:
                Log.d("点击了", trls.get(1).getTitleContent());
                break;
        }
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
        return new FourTitleBarView(getContext());
    }

    @Override
    protected boolean shouldCache() {
        return true;
    }

    @Override
    protected boolean writeCache() {
        return true;
    }

}
