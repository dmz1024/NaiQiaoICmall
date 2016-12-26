package com.naiqiao.mall.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.naiqiao.mall.R;

import java.util.Map;

import base.bean.SingleBaseBean;
import base.fragment.SingleNetWorkBaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import view.CustomScrollView;
import view.DragSwitchLayout;

/**
 * Created by dengmingzhi on 2016/12/26.
 */

public class ShopInfoDescRootFragment extends SingleNetWorkBaseFragment<SingleBaseBean> {
    @BindView(R.id.sc_root)
    CustomScrollView sc_root;
    @BindView(R.id.tv_load)
    TextView tv_load;

    @BindView(R.id.ds_root)
    DragSwitchLayout ds_root;
    @BindView(R.id.wv_desc)
    FrameLayout wv_desc;


    @Override
    protected String url() {
        return "http://www.ediancha.com/app.php";
    }

    @Override
    protected Map<String, String> map() {
        map.put("c", "chahui");
        map.put("a", "index");
        return super.map();
    }

    @Override
    protected Class<SingleBaseBean> getTClass() {
        return SingleBaseBean.class;
    }

    private boolean isFirst;

    @Override
    protected View getHaveDataView() {
        View view = View.inflate(getContext(), R.layout.fragment_shop_info_desc_root, null);
        ButterKnife.bind(this, view);
        ds_root.setDragSwitchListener(new DragSwitchLayout.DragSwitchListener() {
            @Override
            public void onDragToBottomView() {
                if (!isFirst) {
                    getChildFragmentManager().beginTransaction().add(R.id.wv_desc, new AddressFragment()).commit();
                    isFirst = true;
                }
            }

            @Override
            public void onDragToTopView() {

            }
        });

        return view;
    }


    @Override
    protected boolean isCanRefresh() {
        return false;
    }
}
