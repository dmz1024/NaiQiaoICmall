package com.naiqiao.mall.fragment.index;

import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;

import java.util.List;

import base.fragment.NotNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import rx.functions.Action1;
import util.RxBus;

/**
 * Created by dengmingzhi on 2016/11/21.
 */

public class IndexBottomFragment extends NotNetWorkBaseFragment {
    @BindViews({R.id.frame_one, R.id.frame_two, R.id.frame_three, R.id.frame_four})
    List<FrameLayout> frams;
    @BindViews({R.id.iv_one, R.id.iv_two, R.id.iv_three, R.id.iv_four, R.id.iv_center})
    List<ImageView> ivs;
    @BindViews({R.id.tv_one, R.id.tv_two, R.id.tv_three, R.id.tv_four, R.id.tv_center})
    List<TextView> tvs;
    @BindView(R.id.rv_center)
    RelativeLayout rv_center;
    private final int[] curImages = {R.mipmap.icon_common_index_cur, R.mipmap.icon_common_type_cur, R.mipmap.icon_common_send_cur, R.mipmap.icon_common_personal_cur, R.mipmap.icon_common_contact};
    private final int[] images = {R.mipmap.icon_common_index, R.mipmap.icon_common_type, R.mipmap.icon_common_send, R.mipmap.icon_common_personal, R.mipmap.icon_common_contact};

    @Override
    protected int getRId() {
        return R.layout.fragment_index_bottom;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        RxBus.get().register("indexBottomTabChangeFromOther", Integer.class).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                switch (integer) {
                    case 0:
                        chooseView(R.id.frame_one);
                        break;
                    case 1:
                        chooseView(R.id.frame_two);
                        break;
                    case 2:
                        chooseView(R.id.frame_three);
                        break;
                    case 3:
                        chooseView(R.id.frame_four);
                        break;
                    case 4:
                        chooseView(R.id.rv_center);
                        break;
                }
            }
        });
    }

    @OnClick({R.id.frame_one, R.id.frame_two, R.id.frame_three, R.id.frame_four, R.id.rv_center})
    void chooseView(View view) {
        chooseView(view.getId());
    }

    private void chooseView(int id) {
        int position = 0;
        switch (id) {
            case R.id.frame_one:
                position = 0;
                break;
            case R.id.frame_two:
                position = 1;
                break;
            case R.id.frame_three:
                position = 2;
                break;
            case R.id.frame_four:
                position = 3;
                break;
            case R.id.rv_center:
                position = 4;
                break;
        }

        changeImageColor(position);
        RxBus.get().post("indexBottomTabChange", position);
        if (position != 3) {
            RxBus.get().post("changeBarColor", "#ffffff");
        } else {
            RxBus.get().post("changeBarColor", "#f73f5f");
        }
    }


    private void changeImageColor(int position) {
        for (int i = 0; i < ivs.size(); i++) {
            ivs.get(i).setImageResource(images[i]);
            tvs.get(i).setTextColor(Color.parseColor("#666666"));
        }
        ivs.get(position).setImageResource(curImages[position]);
        tvs.get(position).setTextColor(Color.parseColor("#f73f5f"));
    }


    @Override
    protected View getTitleBarView() {
        return null;
    }


    @Override
    protected String getBackColor() {
        return "#00000000";
    }

}
